package com.xxh.summary.utils

import java.text.SimpleDateFormat
import java.util.Date

object CommonUtil {

    fun dateFormatConvert(data: Date): String {

        /**
         * hh:小时，HH：24小时制
         * S：毫秒
         * E：星期
         * a：A.M./P.M. 标记
         * z：时区
         */
        val ft = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS E a zzz")
        return ft.format(data)
    }

    fun stringToDate(dataString: String): Long {
        return Date.parse(dataString)
    }

}