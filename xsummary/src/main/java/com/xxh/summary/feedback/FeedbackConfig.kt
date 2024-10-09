package com.xxh.summary.feedback

import com.xxh.summary.feedback.utils.DeviceIdType
import com.xxh.summary.feedback.utils.LEVEL
import com.xxh.summary.feedback.utils.FbLog
import com.xxh.summary.feedback.utils.FbServerUrls

class FeedbackConfig {

    object FbConfig {
        var logDuration: Int = 10
        var deviceId: String = ""
        var tag = "*"
        var level = LEVEL.V
        var origin: String = "nubia"
        var nickName: String = ""
        var isDarkMode: Boolean = false
        var isInit: Boolean = false

        fun init(builder: Builder) {
            logDuration = builder.logDuration
            deviceId = builder.deviceId
            tag = builder.tag
            level = builder.level
            origin = builder.origin
            nickName = builder.nickName
            isDarkMode = builder.isDarkMode
            debug(builder.isDebug)
            isInit = true
        }

        private fun debug(isDebug: Boolean) {
            FbServerUrls.debug(isDebug)
            FbLog.debug(isDebug)
        }

    }

    class Builder {
        /**
         * 抓取日志的时长，默认10s
         */
        var tag = "*"
        var level = LEVEL.V
        var logDuration = 10
        var nickName: String = ""
        var deviceId: String = ""
        var origin: String = "nubia"
        var isDarkMode: Boolean = false
        var isDebug: Boolean = false

        fun setDebug(isDebug: Boolean): Builder {
            this.isDebug = isDebug
            return this
        }

        /**
         * （必选）用于标识用户和客服回复消息后推送,一般为VAID或OAID
         * setDeviceId(DeviceIdType.VAID, "xxxxxxx") 或 setDeviceId(DeviceIdType.OAID, "xxxxxxx")
         */
        fun setDeviceId(type: DeviceIdType, deviceId: String): Builder {
            when (type) {
                DeviceIdType.VAID -> this.deviceId = "vaid|$deviceId"
                DeviceIdType.OAID -> this.deviceId = "oaid|$deviceId"
            }
            return this
        }

        /**
         * （可选）应用来源，目前为nubia，zte。默认nubia
         */
        fun setOrigin(origin: String): Builder {
            this.origin = origin
            return this
        }

        /**
         * （可选）用户的昵称，通过账号sdk获取用户昵称。默认空
         */
        fun setNickName(nickName: String?): Builder {
            if (!nickName.isNullOrEmpty()) {
                this.nickName = nickName
            }
            return this
        }

        /**
         * （可选）设置日间模式还是夜间模式。默认日间模式
         */
        fun setDarkMode(isDarkMode: Boolean): Builder {
            this.isDarkMode = isDarkMode
            return this
        }

        /**
         * （可选）设置抓取日志时长，单位秒。默认是10秒
         */
        fun setLogDuration(logDuration: Int): Builder {
            this.logDuration = logDuration
            return this
        }

        /**
         * （可选）设置日志过滤标签。默认是不过滤标签
         */
        fun setTag(tag: String): Builder {
            this.tag = tag
            return this
        }

        /**
         * （可选）设置日志过滤级别。默认是V
         */
        fun setLevel(level: LEVEL): Builder {
            this.level = level
            return this
        }

        fun build() {
            if (deviceId.isEmpty()) {
                throw Exception("deviceId not init")
            }
            FbConfig.init(this)
        }
    }

}