package com.xxh.summary.feedback.log

import android.content.Context
import android.os.Handler
import android.os.HandlerThread
import com.xxh.summary.feedback.FeedbackConfig
import com.xxh.summary.feedback.utils.LEVEL
import com.xxh.summary.feedback.utils.FbLog
import java.util.Timer
import java.util.TimerTask

object LogManager {
    private const val TAG = "LogManager"
    private const val SAVE_LOG = 1
    private const val CLOSE_LOG = 2
    private var isInit: Boolean = false
    private var mRunning: Boolean = false
    private lateinit var logConfig: LogConfig
    private lateinit var mHandler: Handler
    private var exec: Process? = null
    private var mCallback: ILogFinishCallback? = null

    @JvmOverloads
    fun init(
        context: Context,
        pkg: Boolean = false,
        tag: String = "*",
        level: LEVEL = LEVEL.V,
        callback: ILogFinishCallback
    ) {
        logConfig = LogConfig(context, pkg, tag, level)
        initHandler()
        mCallback = callback
        isInit = true
    }

    private fun initHandler() {
        val handlerHandler = HandlerThread("handler_thread_log")
        handlerHandler.start()
        mHandler = Handler(handlerHandler.looper) { msg ->
            when (msg.what) {
                SAVE_LOG -> logSave()
                CLOSE_LOG -> stopLogRecord()
            }
            return@Handler true
        }
    }

    //todo 超时时间设置
    fun startLogRecord() {
        if (!isInit) {
            throw Exception("Log system is not initialized")
        }
        mHandler.sendEmptyMessage(SAVE_LOG)
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                stopLogRecord()
            }
        }, FeedbackConfig.FbConfig.logDuration*1000L)
    }

    fun interruptLogRecord() {
        FbLog.d(TAG, "interruptLogRecord ")
        closeLog(Result.INTERRUPT)
    }

    private fun stopLogRecord() {
        FbLog.d(TAG, "stopLogRecord ")
        closeLog(Result.SUCCESS, logConfig.path)
    }

    /**
     * 1.该方法在保存日志中多次调用，日志保存完成之前不响应。
     * 2.每次执行日志文件删除重新创建。建议每次执行完成，回调上传，
     */
    private fun logSave() {
        if (mRunning) {
            return
        }
        mRunning = true
        try {
            //直接导出，不用写文件
            exec = Runtime.getRuntime().exec(logConfig.cmds)
        } catch (e: Exception) {
            e.printStackTrace()
            closeLog(Result.FAIL, msg = e.message)
            FbLog.d(TAG, "logSave err=" + e.message)
        }
        mRunning = false//异常需要恢复
    }

    private fun closeLog(type: Result, filePath: String? = "", msg: String? = "") {
        try {
            exec?.destroy()
        } catch (e: Exception) {
            e.printStackTrace()
            FbLog.d(TAG, "closeLog err=${e.message}")
        }
        mCallback?.finish(type, filePath, msg)
    }

}