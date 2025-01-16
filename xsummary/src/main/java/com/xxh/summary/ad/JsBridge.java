package com.xxh.summary.ad;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.webkit.JavascriptInterface;

import java.util.ArrayList;
import java.util.List;

public class JsBridge {

    public static final String JS_NAME = "interactive_ads_js_com_zte_nubrowser";

    private Context mContext;

    public JsBridge(Context mContext) {
        this.mContext = mContext;
    }

    @JavascriptInterface
    public void openBrowser(String url) {
        try {
            Intent intent = null;
            if (url.startsWith("intent")) {
                intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
            } else {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            }
            if (intent != null) {
                if (isHw()) {
                    intent.setPackage(getDefaultBrowser());
                }
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setComponent(null);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
            }
            //TODO:get context do startActivity
            mContext.startActivity(intent);
        } catch (Exception e) {
        }
    }

    //点击互动广告关闭按钮时调用该方法。
    @JavascriptInterface
    public void close() {
        //TODO  close the ad page or activity.
    }

    //接入Gspace-Fully广告时需实现此方法。该方法用于打开新的Webview页面。
    @JavascriptInterface
    public void openWebview(String url) {
        //TODO  open a new page to display landingpage.
        //TODO 使用展示GSpace的Activity新实例打开当前url.
    }

    public static boolean isHw() {
        return "huawei".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public String getDefaultBrowser() {
        String packageName = null, systemApp = null, userApp = null;
        List<String> userAppList = new ArrayList<>();
        Context context = mContext.getApplicationContext();
        Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://"));
        ResolveInfo resolveInfo = context.getPackageManager().resolveActivity(browserIntent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfo != null && resolveInfo.activityInfo != null) {
            packageName = resolveInfo.activityInfo.packageName;
        }
        if (packageName == null || packageName.equals("android")) {
            List<ResolveInfo> lists = context.getPackageManager().queryIntentActivities(browserIntent, 0);
            for (ResolveInfo app : lists) {
                if ((app.activityInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                    systemApp = app.activityInfo.packageName;
                } else {
                    userApp = app.activityInfo.packageName;
                    userAppList.add(userApp);
                }
            }
            if (userAppList.contains("com.android.chrome")) {
                packageName = "com.android.chrome";
            } else {
                if (systemApp != null) {
                    packageName = systemApp;
                }
                if (userApp != null) {
                    packageName = userApp;
                }
            }
        }
        return packageName;
    }
}
