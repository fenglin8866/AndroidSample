package com.xxh.summary.share.cache;

import android.content.Intent;

import androidx.annotation.MainThread;

public interface IShareFileCache {

    int getShareFileCount(Intent intent);

    long getShareFileTotalSize(Intent intent);

    @MainThread
    void getFilePathFromContentUriOnMain(Intent intent, IShareFileCacheListener listener);

    @MainThread
    void getFilePathFromContentUriOnMain(Intent intent);

    void getFilePathFromContentUri(Intent intent, IShareFileCacheListener listener);

    void getFilePathFromContentUri(Intent intent);

    boolean deleteForFileName(String fileName);

}
