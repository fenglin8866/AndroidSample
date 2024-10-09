package com.xxh.summary.feedback.log

import android.content.Context
import com.xxh.summary.feedback.utils.LEVEL
import com.xxh.summary.feedback.utils.FbLog

class LogConfig @JvmOverloads constructor(
    context: Context,
    pkg: Boolean = false,
    var tag: String = "*",
    level: LEVEL = LEVEL.V,
) {

    private var mPkg = ""

    private var mLevel: String

    var cmds:String

    var path: String

    init {
        if (pkg) {
            mPkg = context.packageName
        }
        mLevel = ":${level.name}"

        path = FileManager.getLogFilePath(context)

        //  cmds = arrayOf("logcat", "-s", "adb logcat $tag$mLevel | grep $mPkg | $mPId -f $path")
        cmds = "logcat $tag$mLevel | grep $mPkg  -f $path "

        FbLog.d("LogConfig", "cmds=${cmds}")
    }

}

