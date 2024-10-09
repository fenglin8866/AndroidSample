package com.xxh.summary;

import android.util.Log;

public class LogUtil {
    private static final String TAG = "XXH_DEMO";
    private static final boolean ENABLE = true;

    public static void d(String tag, String msg) {
        if (ENABLE) {
            Log.d(TAG, getMsg(tag, msg));
        }
    }

    public static void i(String tag, String msg) {
        Log.i(TAG, getMsg(tag, msg));
    }

    public static void w(String tag, String msg) {
        Log.w(TAG, getMsg(tag, msg));
    }

    public static void e(String tag, String msg) {
        Log.e(TAG, getMsg(tag, msg));
    }

    private static String getMsg(String tag, String msg) {
        return "[" + tag + "]" + msg;
    }

}
