package com.xxh.summary.share.cache;

import java.util.List;

public interface IShareFileCacheListener {
    /**
     * 多分享部分失败也回调
     *
     * @param filePaths 缓存成功的路径列表
     * @param totalSize 分享文件的总大小
     */
    void cacheSuccess(List<String> filePaths, long totalSize);


    void cacheFail(CacheError error);
}
