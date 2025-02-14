package com.xxh.dev.update

class UpdateStrategy {
    /**
     * 主页七天内同一个更新版本只提示一次灵活更新
     */
    private val timeInterval = 7 * 24 * 60 * 60

    fun a(info: String) {
        var versionCode = 0
        var lastHintTime = 0L
        if (info.isNotEmpty()) {
            val (versionCodeStr, lastHintTimeStr) = info.split("|")
            versionCode = versionCodeStr.toInt()
            lastHintTime = lastHintTimeStr.toLong()
        }
    }

}