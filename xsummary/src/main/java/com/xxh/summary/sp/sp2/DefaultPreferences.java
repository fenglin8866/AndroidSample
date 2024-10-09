package com.xxh.summary.sp.sp2;

import android.content.Context;

/**
 * 使用组合代替继承
 */
public class DefaultPreferences implements IPreferences {
    private static final String SP_NAME="default_preference";
    private ISharedPreferences sharedPreferences;

    public DefaultPreferences(Context context) {
        sharedPreferences = new BaseSharedPreferences(context, getPreferenceName());
    }

    public String getPreferenceName(){
        return SP_NAME;
    }

    @Override
    public ISharedPreferences getPreferences() {
        return sharedPreferences;
    }
}
