package com.xxh.summary.share.cache;

import android.content.Context;

/**
 * 过期文件的处理
 */
class ShareFileExpiredHandler {
    public static final double DEFAULT_EXPIRED_TIME = 1;
    private static final int MILLS_DAY = 24 * 60 * 60 * 1000;
    private double mExpiredTime = DEFAULT_EXPIRED_TIME;


    public void setExpiredTime(double expiredTime) {
        mExpiredTime = expiredTime;
    }

    /**
     * 判断当前文件是否过期
     * 过期 1.是否存在过期文件夹，存在删除
     * 2.标识当前文件夹为过期文件夹并创建当前文件夹
     *
     * @param context
     */
    public void shareFileExpiredHandle(Context context) {
        CommonUtils utils = new CommonUtils(context);
        long curDir = utils.getDirName(CommonUtils.CUR_DIR);
        if (isExpired(curDir)) {
            long expired = utils.getDirName(CommonUtils.EXPIRED_DIR);
            if (expired != 0) {
                utils.deleteFile(expired + "");
            }
            utils.saveDirName(CommonUtils.CUR_DIR, System.currentTimeMillis());
            utils.saveDirName(CommonUtils.EXPIRED_DIR, curDir);
        }
    }

    private boolean isExpired(long curDir) {
        long curTime = System.currentTimeMillis();
        return curDir == 0 || Math.abs(curTime - curDir) > MILLS_DAY * mExpiredTime;
    }
// Tried to access visual service WindowManager from a non-visual Context:cn.nubia.improve.xcloud.NubiaCloudTaskService@36ad034 WindowManager should be accessed from Activity or other visual Context. Use an Activity or a Context created with Context#createWindowContext(int, Bundle), which are adjusted to the configuration and visual bounds of an area on screen.
//    java.lang.IllegalAccessException: Tried to access visual service WindowManager from a non-visual Context:cn.nubia.improve.xcloud.NubiaCloudTaskService@36ad034

    //onStatus:fileName:0_20170516eJtQ_1648804323958.jpg totalSize:0 currentSize:0 bytesPerSecond:0 type:1 statusTaskCode:112 uploadSameFilePolicy:RENAME taskTimeSecond:0 source:/storage/emulated/0/Android/data/cn.nubia.gallery3d/files/1656743448463/0_20170516eJtQ_1648804323958.jpg target:/apps/nubia_cloud/照片/云相册/test/0_20170516eJtQ_1648804323958.jpg requestId:f206b1c5-393f-408a-b10b-7df6988d0fb7 taskId:3 errorCode:0 errorMessage:null Bundle[EMPTY_PARCEL]

    //java.lang.IllegalArgumentException: Duplicate key in ArrayMap: com.android.browser.util.BrowserGlideModule


}
