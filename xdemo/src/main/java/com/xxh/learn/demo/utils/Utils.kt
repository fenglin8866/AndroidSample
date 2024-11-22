package com.xxh.learn.demo.utils

import java.util.UUID

object Utils {
    private var deviceId: String? = null

    fun getDeviceId(): String {
        if (deviceId == null) {
            deviceId = UUID.randomUUID().toString()
        }
        return deviceId ?: "000"
    }
}