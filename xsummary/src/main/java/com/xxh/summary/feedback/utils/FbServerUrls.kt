package com.xxh.summary.feedback.utils

object FbServerUrls {
    private const val TEST_SERVER_URL = "https://browser-test.server.nubia.cn"
    private const val RELEASE_SERVER_URL = "https://browser.server.nubia.cn"
    private const val SERVER_HOME = "/indexSJ.html"
    private const val SERVER_UPLOAD_LOG = "/feedback/saveLogFile.do"
    private var mDebug = true

    fun debug(enable: Boolean) {
        mDebug = enable
    }

    //todo
    private fun getServerBaseUrl(): String {
        return if (mDebug) {
            TEST_SERVER_URL
        } else {
            RELEASE_SERVER_URL
        }
    }

    fun getFeedbackHomeUrl(): String {
        return getServerBaseUrl() + SERVER_HOME
    }

    fun getUploadLogUrl(): String {
        return getServerBaseUrl() + SERVER_UPLOAD_LOG
    }

}