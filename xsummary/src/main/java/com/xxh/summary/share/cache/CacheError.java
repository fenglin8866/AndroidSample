package com.xxh.summary.share.cache;

import android.net.Uri;

import java.util.Map;

public class CacheError {
    public static final int CACHE_FILE_ERROR = 1000;
    public static final int INTENT_NULL_ERROR = 1001;
    public static final int URI_NULL_ERROR = 1002;
    public static final int QUERY_FILE_ERROR = 1003;
    public static final String CACHE_FILE_ERROR_MSG = "缓存分享文件失败";
    public static final String INTENT_NULL_ERROR_MSG = "intent为空";
    public static final String URI_NULL_ERROR_MSG = "uri为空";
    public static final String QUERY_FILE_ERROR_MSG = "检索分享文件信息错误";
    public static final String OTHER_ERROR_MSG = "未知错误";

    private int errorCode = -1;
    //Uri为失败的分享uri，String为失败的文件名
    private Map<Uri, String> cacheFailFiles;

    public CacheError() {
    }

    public CacheError(int errorCode) {
        this.errorCode = errorCode;
    }

    public CacheError(int errorCode, Map<Uri, String> cacheFailFiles) {
        this.errorCode = errorCode;
        this.cacheFailFiles = cacheFailFiles;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorInfo(int errorCode, Map<Uri, String> cacheFailFiles) {
        this.errorCode = errorCode;
        this.cacheFailFiles = cacheFailFiles;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        String message = OTHER_ERROR_MSG;
        switch (errorCode) {
            case CACHE_FILE_ERROR:
                message = CACHE_FILE_ERROR_MSG;
                break;
            case INTENT_NULL_ERROR:
                message = INTENT_NULL_ERROR_MSG;
                break;
            case URI_NULL_ERROR:
                message = URI_NULL_ERROR_MSG;
                break;
            case QUERY_FILE_ERROR:
                message = QUERY_FILE_ERROR_MSG;
                break;

        }
        return message;
    }

    public Map<Uri, String> getCacheFailFiles() {
        return cacheFailFiles;
    }
}
