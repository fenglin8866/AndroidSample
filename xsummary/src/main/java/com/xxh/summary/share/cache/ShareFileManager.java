package com.xxh.summary.share.cache;

import android.content.Context;
import android.content.Intent;

public class ShareFileManager implements IShareFileCache {
    private static volatile ShareFileManager mShareFileManager;
    ShareFileExpiredHandler fileExpiredHandler = new ShareFileExpiredHandler();
    private final Context mContext;
    private final ShareFileHandler mShareFileHandler;

    private ShareFileManager(Context context) {
        mContext = context.getApplicationContext();
        mShareFileHandler = new ShareFileHandler(mContext);
    }

    private ShareFileManager(Context context, double expiredTime) {
        this(context);
        fileExpiredHandle(expiredTime);
    }

    public static ShareFileManager getInstance(Context mContext, double expiredTime) {
        if (expiredTime < 0.5) {
            expiredTime = ShareFileExpiredHandler.DEFAULT_EXPIRED_TIME;
        }
        if (mShareFileManager == null) {
            synchronized (ShareFileManager.class) {
                if (mShareFileManager == null) {
                    mShareFileManager = new ShareFileManager(mContext, expiredTime);
                }
            }
        }
        return mShareFileManager;
    }

    public void setShareFileCacheListener(IShareFileCacheListener listener) {
        mShareFileHandler.setShareFileCacheListener(listener);
    }

    private void fileExpiredHandle(double expiredTime) {
        fileExpiredHandler.setExpiredTime(expiredTime);
        fileExpiredHandler.shareFileExpiredHandle(mContext);
    }

    @Override
    public int getShareFileCount(Intent mIntent) {
        return mShareFileHandler.getShareFileCount(mIntent);
    }

    @Override
    public long getShareFileTotalSize(Intent intent) {
        return mShareFileHandler.getShareFileTotalSize(intent);
    }

    @Override
    public void getFilePathFromContentUriOnMain(Intent intent, IShareFileCacheListener listener) {
        mShareFileHandler.getFilePathFromContentUriOnMain(intent, listener);
    }

    @Override
    public void getFilePathFromContentUriOnMain(Intent intent) {
        mShareFileHandler.getFilePathFromContentUriOnMain(intent);
    }

    @Override
    public void getFilePathFromContentUri(Intent intent, IShareFileCacheListener listener) {
        mShareFileHandler.getFilePathFromContentUri(intent, listener);
    }

    @Override
    public void getFilePathFromContentUri(Intent intent) {
        mShareFileHandler.getFilePathFromContentUri(intent);
    }

    @Override
    public boolean deleteForFileName(String fileName) {
        return mShareFileHandler.deleteForFileName(fileName);
    }

    public static boolean deleteForFileName(Context context, String fileName) {
        return CommonUtils.deleteForFileName(context, fileName);
    }
}
