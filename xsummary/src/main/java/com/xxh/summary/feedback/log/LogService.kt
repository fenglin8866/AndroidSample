package com.xxh.summary.feedback.log

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import com.xxh.summary.feedback.FeedbackConfig
import com.xxh.summary.feedback.utils.FbLog

class LogService : Service() {
    private val tag = "LogService"
    private val channelId = "LogService"
    private val notificationId = 1

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        FbLog.d(tag, "LogService onStartCommand")
        showForegroundNotificationIfNeed()
        LogManager.init(
            this,
            true,
            FeedbackConfig.FbConfig.tag,
            FeedbackConfig.FbConfig.level,
            callback = object : ILogFinishCallback {
                override fun finish(type: Result, filePath: String?, msg: String?) {
                    if (type == Result.SUCCESS) {
                        FbLog.d(tag, "onStartCommand filePath=$filePath")
                        filePath?.let {
                            //FileManager.uploadLogFile(filePath)
                            FileManager.uploadLogFile2(this@LogService,filePath)
                        }
                        stopSelf()
                    } else if (type == Result.FAIL) {
                        stopSelf()
                    }
                }
            })
        LogManager.startLogRecord()
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        FbLog.d(tag, "LogService onDestroy")
        LogManager.interruptLogRecord()
    }

    private fun showForegroundNotificationIfNeed() {
        if (isSupportForegroundService()) {
            /*val pManager = packageManager.getApplicationIcon(packageName)

            val pendingIntent: PendingIntent =
                Intent(this, MainActivity::class.java).let { notificationIntent ->
                    PendingIntent.getActivity(
                        this, 0, notificationIntent,
                        PendingIntent.FLAG_IMMUTABLE
                    )
                }*/
            val notificationChannel =
                NotificationChannel(channelId, "upload log", NotificationManager.IMPORTANCE_LOW)
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(notificationChannel);
            val notification: Notification = Notification.Builder(this, channelId)
                .setContentTitle("意见反馈")
                .setContentText("正在上传日志中...")
               // .setSmallIcon(R.drawable.point1)
                // .setContentIntent(pendingIntent)
                .build()

            startForeground(notificationId, notification)
        }
    }

    companion object {

        @JvmStatic
        fun startLogService(context: Context) {
            val intent = Intent(context, LogService::class.java)
            if (isSupportForegroundService()) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }

        @JvmStatic
        fun stopLogService(context: Context) {
            val intent = Intent(context, LogService::class.java)
            context.stopService(intent)
        }

        fun isSupportForegroundService(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
        }
    }

}