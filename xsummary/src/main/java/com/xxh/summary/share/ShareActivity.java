package com.xxh.summary.share;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import androidx.core.content.FileProvider;

import com.xxh.summary.common.BaseActivity;
import com.xxh.summary.databinding.ActivityShareBinding;
import com.xxh.summary.share.cache.CacheError;
import com.xxh.summary.share.cache.IShareFileCacheListener;
import com.xxh.summary.share.cache.ShareFileManager;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class ShareActivity extends BaseActivity<ActivityShareBinding> {

    private ShareFileManager shareFileManager;

    @Override
    protected void initBinding() {
        mBinding = ActivityShareBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {
        super.initData();
        Context mContext = this;
        shareFileManager = ShareFileManager.getInstance(mContext, 1);
        if (getIntent() == null) {
            //查询分享文件个数
            int count = shareFileManager.getShareFileCount(getIntent());
            //查询分享文件占空间的总大小
            long totalSize = shareFileManager.getShareFileTotalSize(getIntent());

            mBinding.shareLocalPath.setText("分享文件的个数 count=" + count);

            shareFileManager.getFilePathFromContentUriOnMain(getIntent(), new IShareFileCacheListener() {
                //filePaths:返回缓存文件的路径，totalSize:分享文件的总大小
                @Override
                public void cacheSuccess(List<String> filePaths, long totalSize) {
                    Log.d("xxh", "cacheSuccess=" + Thread.currentThread().getName());
                    StringBuilder buffer = new StringBuilder();
                    for (String filePath : filePaths) {
                        Log.d("xxh", "cacheSuccess1=" + filePath);
                        buffer.append(filePath).append(",");
                    }
                    mBinding.shareLocalPath.setText(buffer.toString());
                }

                //error:错误异常
                @Override
                public void cacheFail(CacheError error) {
                    //错误异常说明
                    String eMsg = error.getErrorMessage();
                    //Uri:失败的分享uri，String:失败的文件名
                    Map<Uri, String> files = error.getCacheFailFiles();
                    // Snackbar.make(mContext,mBinding.getRoot(),eMsg,LENGTH_SHORT).show();
                }
            });

            mBinding.shareLocalShow.setOnClickListener(v -> {

                String name = "0_Screenshot_2022-03-25-16-42-28-679.jpg";

                // ShareFileManager.deleteForFileName(mContext, name);

                shareFileManager.deleteForFileName(name);

            });
        }
    }

    @Override
    protected void initView() {
        super.initView();

    }


    //不可靠，获取不到分享路径
    private String getFilePath(Uri uri) {
        String filename = uri.getPath();
        if (String.valueOf(uri) != null && String.valueOf(uri).contains("content")) {
            boolean kkk = false;
            try {
                filename = getFilePathFromContentUri(uri, this.getContentResolver());
                if (TextUtils.isEmpty(filename)) {
                    kkk = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                kkk = true;
            }
            if (kkk) {
                filename = getFPUriToPath(this, uri);
            }
        }
        return filename;

    }

    /**
     * 将uri转换成真实路径
     *
     * @param selectedVideoUri
     * @param contentResolver
     * @return
     */
    public static String getFilePathFromContentUri(Uri selectedVideoUri,
                                                   ContentResolver contentResolver) {
        String filePath = "";
        String[] filePathColumn = {MediaStore.MediaColumns.DATA};

        Cursor cursor = contentResolver.query(selectedVideoUri, filePathColumn,
                null, null, null);
        // 也可用下面的方法拿到cursor
        // Cursor cursor = this.context.managedQuery(selectedVideoUri,
        // filePathColumn, null, null, null);

//        cursor.moveToFirst();
//
//        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//        filePath = cursor.getString(columnIndex);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int id = cursor.getColumnIndex(filePathColumn[0]);
                if (id > -1)
                    filePath = cursor.getString(id);
            }
            cursor.close();
        }

        return filePath;
    }


    public static String getFPUriToPath(Context context, Uri uri) {
        try {
            List<PackageInfo> packs = context.getPackageManager().getInstalledPackages(PackageManager.GET_PROVIDERS);
            if (packs != null) {
                String fileProviderClassName = FileProvider.class.getName();
                for (PackageInfo pack : packs) {
                    ProviderInfo[] providers = pack.providers;
                    if (providers != null) {
                        for (ProviderInfo provider : providers) {
                            if (uri.getAuthority().equals(provider.authority)) {
                                if (provider.name.equalsIgnoreCase(fileProviderClassName)) {
                                    Class<FileProvider> fileProviderClass = FileProvider.class;
                                    try {
                                        Method getPathStrategy = fileProviderClass.getDeclaredMethod("getPathStrategy", Context.class, String.class);
                                        getPathStrategy.setAccessible(true);
                                        Object invoke = getPathStrategy.invoke(null, context, uri.getAuthority());
                                        if (invoke != null) {
                                            String PathStrategyStringClass = FileProvider.class.getName() + "$PathStrategy";
                                            Class<?> PathStrategy = Class.forName(PathStrategyStringClass);
                                            Method getFileForUri = PathStrategy.getDeclaredMethod("getFileForUri", Uri.class);
                                            getFileForUri.setAccessible(true);
                                            Object invoke1 = getFileForUri.invoke(invoke, uri);
                                            if (invoke1 instanceof File) {
                                                String filePath = ((File) invoke1).getAbsolutePath();
                                                return filePath;
                                            }
                                        }
                                    } catch (NoSuchMethodException e) {
                                        e.printStackTrace();
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}