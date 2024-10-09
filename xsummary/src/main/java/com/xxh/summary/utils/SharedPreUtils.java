package com.xxh.summary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.xxh.summary.XApplication;

/**
 * https://www.jianshu.com/p/ed7c7d918497
 * SharedPreferences封装工具
 * 1.所有的SP存储都调用该类
 * 2.存储的字段名全部定义在该类内部，方便查看
 *
 */
public class SharedPreUtils {
    private static SharedPreUtils sInstance;
    private SharedPreferences sharedReadable;
    private SharedPreferences.Editor sharedWritable;
    private static final String SHARED_NAME = "outerId_pref";

    public static final String OUTER_ID = "outerId";

    public static SharedPreUtils getInstance(){
        if(sInstance == null){
            synchronized (SharedPreUtils.class){
                if (sInstance == null){
                    sInstance = new SharedPreUtils();
                }
            }
        }
        return sInstance;
    }


    private SharedPreUtils(){
        sharedReadable =  XApplication.getContext()
                .getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        sharedWritable = sharedReadable.edit();
    }

    public String getString(String key){
        return sharedReadable.getString(key,"");
    }

    public void putString(String key, String value){
        sharedWritable.putString(key,value);
        sharedWritable.apply();
    }

    public void putInt(String key, int value){
        sharedWritable.putInt(key, value);
        sharedWritable.apply();
    }

    public void putBoolean(String key, boolean value){
        sharedWritable.putBoolean(key, value);
        sharedWritable.apply();
    }

    public int getInt(String key, int def){
        return sharedReadable.getInt(key, def);
    }

    public boolean getBoolean(String key, boolean def){
        return sharedReadable.getBoolean(key, def);
    }

}
