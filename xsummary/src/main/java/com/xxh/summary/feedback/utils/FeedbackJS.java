package com.xxh.summary.feedback.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.webkit.JavascriptInterface;

import com.xxh.summary.feedback.FeedbackConfig;
import com.xxh.summary.feedback.log.LogService;

public class FeedbackJS {
    private Context mContext;
    public static final String JS_NAME = "feedback_javascript_obj";

    public FeedbackJS(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * appId，用于标识应用。服务端生成，初始化必须配置。考虑是否可在Manifest配置
     * 使用包名代替
     * @return
     */
    @Deprecated
    @JavascriptInterface
    public String getAppId() {
        return "1";
    }

    /**
     * 获取包名，用于标识应用。服务端校验映射
     *
     * @return
     */
    @JavascriptInterface
    public String getPackageName() {
        return mContext.getPackageName();
    }

    /**
     * 设置设备id，作用 1.唯一标识设备 2.回复消息推送
     * 使用：VAID或OAID
     *
     * @return
     */
    @JavascriptInterface
    public String getDeviceId() {
        return FeedbackConfig.FbConfig.INSTANCE.getDeviceId();
    }

    /**
     * 获取来源：目前为nubia，zte，默认是nubia
     *
     * @return
     */
    @JavascriptInterface
    public String getOrigin() {
        return FeedbackConfig.FbConfig.INSTANCE.getOrigin();
    }

    /**
     * 获取用户昵称，没有账号或没登录传空
     *
     * @return
     */
    @JavascriptInterface
    public String getNickName() {
        return FeedbackConfig.FbConfig.INSTANCE.getNickName();
    }

    /**
     * 选中上传日志回调
     */
    @JavascriptInterface
    public void setCheckStatus() {
        FbLog.INSTANCE.d("FeedbackJS","FeedbackJS setCheckStatus");
        LogService.startLogService(mContext);
    }


    /**
     * 取消上传日志回调
     */
    @JavascriptInterface
    public void setNoCheckStatus() {
        FbLog.INSTANCE.d("FeedbackJS","FeedbackJS setNoCheckStatus");
        LogService.stopLogService(mContext);
    }

    /**
     * 获取手机系统安卓版本
     *
     * @return
     */
    @JavascriptInterface
    public String getAndroidVersion() {
        return Build.VERSION.SDK_INT + "";
    }

    /**
     * 获取机型
     *
     * @return
     */
    @JavascriptInterface
    public String getPhoneModel() {
        return Build.MODEL;
    }


    @JavascriptInterface
    public String getAppVersionName() {
        return getVersionName();
    }

    public String getVersionName() {
        String versionName = "";
        try {
            PackageInfo packageInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (Exception e) {
            FbLog.INSTANCE.e("getVersionName", "err="+e.getMessage());
        }
        return versionName;
    }


}

