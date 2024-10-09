package com.xxh.summary.sp.sp1;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;


public class BaseSharedPreferences implements ISharedPreferences {

    //public static final int Data

    private SharedPreferences sharedReadable;

    private SharedPreferences.Editor sharedWritable;

    public BaseSharedPreferences(Context context, String name) {
        sharedReadable = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        sharedWritable = sharedReadable.edit();
    }

    @Override
    public void putString(String key, String value) {
        sharedWritable.putString(key, value);
        sharedWritable.apply();
    }

    @Override
    public void putStringSet(String key, Set<String> values) {

    }

    @Override
    public void putInt(String key, int value) {
        sharedWritable.putInt(key, value);
        sharedWritable.apply();
    }

    @Override
    public void putLong(String key, long value) {

    }

    @Override
    public void putFloat(String key, float value) {

    }

    @Override
    public void putBoolean(String key, boolean value) {
        sharedWritable.putBoolean(key, value);
        sharedWritable.apply();
    }

    public int getInt(String key, int def) {
        return sharedReadable.getInt(key, def);
    }

    public boolean getBoolean(String key, boolean def) {
        return sharedReadable.getBoolean(key, def);
    }

    public String getString(String key) {
        return sharedReadable.getString(key, "");
    }

}
