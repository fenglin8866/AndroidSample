package com.xxh.summary.feedback.log

import android.content.Context
import android.os.Environment
import com.xxh.summary.feedback.FeedbackConfig
import com.xxh.summary.feedback.utils.FbLog
import com.xxh.summary.feedback.utils.FbServerUrls
import com.xxh.summary.feedback.utils.Util
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.Response
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * 日志文件的管理
 */
object FileManager {

    private const val LOG_DIR = "/logs"
    fun getLogFilePath(context: Context): String {
        val fileDirPath = fileDirHandler(context)
        return "$fileDirPath/${getFileName()}.log"
    }
    private fun getFileName(): String {
        val format = SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA)
        return format.format(Date())
    }
    /**
     *  日志目录处理
     *  生成日志文件前：先删除之前的日志
     */
    private fun fileDirHandler(context: Context): String {
        val fileDirPath =
            context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString() + LOG_DIR
        val dir = File(fileDirPath)
        if (!dir.exists()) {
            dir.mkdirs()
        } else {
            dir.listFiles()?.forEach {
                it.delete()
            }
        }
        return fileDirPath
    }

    /**
     * 日志文件上传
     */
    fun uploadLogFile(filePath: String) {
        val file = File(filePath)
        if (!file.exists()) {
            FbLog.i("FileManager", "日志文件不存在")
            return
        }
        try {
            val requestBody: RequestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                //todo
                .addFormDataPart("deviceId", FeedbackConfig.FbConfig.deviceId)
                .addFormDataPart(
                    "file",
                    file.name,
                    file.asRequestBody("text/plain".toMediaTypeOrNull())
                )
                .build()
            val request: Request = Request.Builder()
                .url(FbServerUrls.getUploadLogUrl())
                .post(requestBody)
                .build()
            val client = OkHttpClient()
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    FbLog.d("FileManager", "uploadLogFile失败 err=${e.message}")
                }

                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    FbLog.d("FileManager", "uploadLogFile成功")
                }
            })
        } catch (e: Exception) {
            FbLog.i("FileManager", "uploadLogFile err=${e.message}")
            e.printStackTrace()
        }
    }

    /**
     * 日志文件上传
     */
    fun uploadLogFile2(context: Context, filePath: String) {
        val file = File(filePath)
        if (!file.exists()) {
            FbLog.i("FileManager", "日志文件不存在")
            return
        }
        try {
            val requestBody: RequestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                //todo
                .addFormDataPart("deviceId", FeedbackConfig.FbConfig.deviceId)
                .addFormDataPart(
                    "file",
                    file.name,
                    file.asRequestBody("text/plain".toMediaTypeOrNull())
                )
                .build()
            val request: Request = Request.Builder()
                .url(FbServerUrls.getUploadLogUrl())
                .post(requestBody)
                .build()
            val client = OkHttpClient()
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    FbLog.d("FileManager", "uploadLogFile失败 err=${e.message}")
                }

                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    FbLog.d("FileManager", "uploadLogFile成功")
                }
            })
        } catch (e: Exception) {
            FbLog.i("FileManager", "uploadLogFile err=${e.message}")
            e.printStackTrace()
            if (Util.isNetAvailable(context)) {
                Util.toastShow(context, "日志上传失败，请重新操作")
            } else {
                Util.toastShow(context, "网络异常，请检查网络，重新操作")
            }

        }
    }

}