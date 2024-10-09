package com.xxh.summary.share.cache;

import static com.xxh.summary.share.cache.CacheError.CACHE_FILE_ERROR;
import static com.xxh.summary.share.cache.CacheError.INTENT_NULL_ERROR;
import static com.xxh.summary.share.cache.CacheError.QUERY_FILE_ERROR;
import static com.xxh.summary.share.cache.CacheError.URI_NULL_ERROR;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.text.TextUtils;

import androidx.arch.core.executor.ArchTaskExecutor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ShareFileHandler implements IShareFileCache {

    private final Context mContext;
    private IShareFileCacheListener mListener;
    private final List<String> mCacheSuccessPaths = new ArrayList<>();
    private final Map<Uri, String> mCacheFailFiles = new HashMap<>();
    private long mTotalSize = 0L;
    private final CacheError error = new CacheError();
    private final CommonUtils utils;

    private final Runnable RunnableCacheSuccess = new Runnable() {
        @SuppressWarnings("unchecked")
        @Override
        public void run() {
            if (mListener != null) {
                mListener.cacheSuccess(mCacheSuccessPaths, mTotalSize);
            }
        }
    };

    private final Runnable RunnableCacheFail = new Runnable() {
        @SuppressWarnings("unchecked")
        @Override
        public void run() {
            if (mListener != null) {
                mListener.cacheFail(error);
            }
        }
    };

    public ShareFileHandler(Context context) {
        mContext = context;
        utils = new CommonUtils(context);
    }

    public void setShareFileCacheListener(IShareFileCacheListener listener) {
        mListener = listener;
    }

    @Override
    public void getFilePathFromContentUriOnMain(Intent intent, IShareFileCacheListener listener) {
        mListener = listener;
        getFilePathFromContentUriOnMain(intent);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void getFilePathFromContentUriOnMain(Intent intent) {
        new Thread(() -> {
            handleIntent(intent);
            if (mCacheSuccessPaths.size() != 0)
                ArchTaskExecutor.getInstance().postToMainThread(RunnableCacheSuccess);
            if (mCacheFailFiles.size() != 0) {
                error.setErrorInfo(CACHE_FILE_ERROR, mCacheFailFiles);
            }
            if (error.getErrorCode() != -1) {
                ArchTaskExecutor.getInstance().postToMainThread(RunnableCacheFail);
            }
        }).start();
    }

    @Override
    public void getFilePathFromContentUri(Intent intent, IShareFileCacheListener listener) {
        mListener = listener;
        getFilePathFromContentUri(intent);

    }

    @Override
    public void getFilePathFromContentUri(Intent intent) {
        handleIntent((intent));
        callbackListener();
    }

    private void handleIntent(Intent intent) {
        if (intent != null) {
            mCacheSuccessPaths.clear();
            mCacheFailFiles.clear();
            mTotalSize = 0;
            String action = intent.getAction();
            if (Intent.ACTION_SEND_MULTIPLE.equals(action)) {
                ArrayList<Uri> uris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                for (Uri uri : uris) {
                    handleUri(uri);
                }
            } else if (Intent.ACTION_SEND.equals(action)) {
                Uri uri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
                handleUri(uri);
            } else if (Intent.ACTION_VIEW.equals(action)) {
                Uri uri = intent.getData();
                handleUri(uri);
            }
        } else {
            error.setErrorCode(INTENT_NULL_ERROR);
        }
    }

    /**
     * 分享文件的个数
     *
     * @param mIntent
     * @return
     */
    @Override
    public int getShareFileCount(Intent mIntent) {
        int count = 0;
        if (mIntent != null) {
            String action = mIntent.getAction();
            if (Intent.ACTION_SEND_MULTIPLE.equals(action)) {
                ArrayList<Uri> uris = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                count = uris.size();
            } else {
                count = 1;
            }
        } else {
            error.setErrorCode(INTENT_NULL_ERROR);
        }
        return count;
    }

    /**
     * 分享文件的总大小
     *
     * @param intent
     * @return
     */
    @Override
    public long getShareFileTotalSize(Intent intent) {
        mTotalSize = 0;
        if (intent != null) {
            String action = intent.getAction();
            if (Intent.ACTION_SEND_MULTIPLE.equals(action)) {
                ArrayList<Uri> uris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                for (Uri uri : uris) {
                    queryFileSize(uri);
                }
            } else if (Intent.ACTION_SEND.equals(action)) {
                Uri uri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
                queryFileSize(uri);
            } else if (Intent.ACTION_VIEW.equals(action)) {
                Uri uri = intent.getData();
                queryFileSize(uri);
            }
        } else {
            error.setErrorCode(INTENT_NULL_ERROR);
        }
        return mTotalSize;
    }

    private void queryFileSize(Uri uri) {
        if (uri != null && uri.toString().startsWith("content")) {
            try (Cursor cursor = mContext.getContentResolver().query(uri, null, null, null, null)) {
                int sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE);
                cursor.moveToFirst();
                long size = cursor.getLong(sizeIndex);
                mTotalSize += size;
            } catch (Exception e) {
                e.printStackTrace();
                error.setErrorCode(QUERY_FILE_ERROR);
            }
        }
    }

    private void handleUri(Uri uri) {
        if (uri != null) {
            if (uri.toString().startsWith("content")) {
                String fileName = queryShareFileInfo(uri);
                readFileFromShare(uri, fileName);
            } else if (uri.toString().startsWith("file")) {
                mCacheSuccessPaths.add(uri.getPath());
            }
        } else {
            error.setErrorCode(URI_NULL_ERROR);
        }
    }

    /**
     * 检索分享文件名和文件大小
     *
     * @param uri
     * @return
     */
    private String queryShareFileInfo(Uri uri) {
        String name = "";
        try (Cursor cursor = mContext.getContentResolver().query(uri, null, null, null, null)) {
            int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
            int sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE);
            cursor.moveToFirst();
            long size = cursor.getLong(sizeIndex);
            name = cursor.getString(nameIndex);
            mTotalSize += size;
        } catch (Exception e) {
            e.printStackTrace();
            error.setErrorCode(QUERY_FILE_ERROR);
        }
        return name;
    }

    /**
     * 读取分享的文件并把文件导入到私有目录
     *
     * @param uri
     * @param fileName
     */
    private void readFileFromShare2(Uri uri, String fileName) {
        if (uri != null) {
            File outFile = new File(utils.getShareFileDirPath() + File.separator + fileName);
            //防止分享文件反复缓存
            if (outFile.exists() && outFile.length() > 0) {
                mCacheSuccessPaths.add(outFile.getPath());
            } else {
                try {
                    InputStream inputStream = mContext.getContentResolver().openInputStream(uri);
                    FileOutputStream fos = new FileOutputStream(outFile);
                    byte[] buf = new byte[1024 * 8];
                    int readCount = 0;
                    while ((readCount = inputStream.read(buf)) != -1) {
                        fos.write(buf, 0, readCount);
                    }
                    fos.flush();
                    inputStream.close();
                    fos.close();
                    mCacheSuccessPaths.add(outFile.getPath());
                } catch (IOException e) {
                    e.printStackTrace();
                    outFile.delete();
                    mCacheFailFiles.put(uri, fileName);
                }
            }
        }
    }

    private void readFileFromShare(Uri uri, String fileName) {
        if (uri != null) {
            File outFile = new File(utils.getShareFileDirPath() + File.separator + fileName);
            //防止分享文件反复缓存
            if (outFile.exists() && outFile.length() > 0) {
                StringBuilder stringBuilder=new StringBuilder(fileName);
                stringBuilder.insert(fileName.lastIndexOf("."),"("+utils.getStringToday(System.currentTimeMillis())+")");
                outFile = new File(utils.getShareFileDirPath() + File.separator + stringBuilder);
            }
            try {
                InputStream inputStream = mContext.getContentResolver().openInputStream(uri);
                FileOutputStream fos = new FileOutputStream(outFile);
                byte[] buf = new byte[1024 * 8];
                int readCount = 0;
                while ((readCount = inputStream.read(buf)) != -1) {
                    fos.write(buf, 0, readCount);
                }
                fos.flush();
                inputStream.close();
                fos.close();
                mCacheSuccessPaths.add(outFile.getPath());
            } catch (IOException e) {
                e.printStackTrace();
                outFile.delete();
                mCacheFailFiles.put(uri, fileName);
            }

        }
    }


    private void callbackListener() {
        if (mListener != null) {
            if (mCacheSuccessPaths.size() != 0)
                mListener.cacheSuccess(mCacheSuccessPaths, mTotalSize);
            if (mCacheFailFiles.size() != 0) {
                error.setErrorInfo(CACHE_FILE_ERROR, mCacheFailFiles);
            }
            if (error.getErrorCode() != -1) {
                mListener.cacheFail(error);
            }
        }
    }


    public void deleteForFilePath(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    public boolean deleteForFileName(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return false;
        }
        File file = new File(utils.getShareFileDirPath() + File.separator + fileName);
        if (!file.exists()) {
            return false;
        }
        return file.delete();
    }

}
