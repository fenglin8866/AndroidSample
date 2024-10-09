package com.xxh.summary.share.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class CommonUtils {
    private final SharedPreferences mSpf;
    private static final String NAME = "ShareFileCacheSP";
    public static final String EXPIRED_DIR = "expired_dir";
    public static final String CUR_DIR = "cur_dir";
    private Context mContext;

    public CommonUtils(Context context) {
        mContext = context;
        mSpf = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public void saveDirName(String key, long value) {
        SharedPreferences.Editor editor = mSpf.edit();
        editor.putLong(key, value).apply();
    }

    public long getDirName(String key) {
        return mSpf.getLong(key, 0L);
    }

    public String getShareFileDirPath(String dir) {
        return mContext.getExternalFilesDir(null).getPath() + File.separator + dir;
    }

    public String getShareFileDirPath() {
        String dir = getDirName(CUR_DIR) + "";
        File filesDir = new File(mContext.getExternalFilesDir(null).getPath() + File.separator + dir);
        if (!filesDir.exists()) {
            filesDir.mkdir();
        }
        return filesDir.getPath();
    }

    public void   deleteFile(String dir) {
        File file = new File(getShareFileDirPath(dir));
        if (!file.exists()) {
            return;
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                f.delete();
            }
        }
        file.delete();
    }


    public String getStringToday(long mills) {
        Date curTime = new Date(mills);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(curTime);
    }

    public static boolean deleteForFileName(Context context, String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return false;
        }
        String dir = context.getSharedPreferences(NAME, Context.MODE_PRIVATE).getLong(CUR_DIR, 0L) + "";
        String path = context.getExternalFilesDir(null).getPath() + File.separator + dir;
        File file = new File(path + File.separator + fileName);
        if (!file.exists()) {
            return false;
        }
        return file.delete();
    }


}
