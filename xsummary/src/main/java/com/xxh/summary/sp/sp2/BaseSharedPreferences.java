package com.xxh.summary.sp.sp2;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;


public class BaseSharedPreferences implements ISharedPreferences {

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
        sharedWritable.putStringSet(key, values);
        sharedWritable.apply();
    }

    @Override
    public void putInt(String key, int value) {
        sharedWritable.putInt(key, value);
        sharedWritable.apply();
    }

    @Override
    public void putLong(String key, long value) {
        sharedWritable.putLong(key, value);
        sharedWritable.apply();
    }

    @Override
    public void putFloat(String key, float value) {
        sharedWritable.putFloat(key, value);
        sharedWritable.apply();
    }

    @Override
    public void putBoolean(String key, boolean value) {
        sharedWritable.putBoolean(key, value);
        sharedWritable.apply();
    }

    @Override
    public Map<String, ?> getAll() {
        return sharedReadable.getAll();
    }

    @Nullable
    @Override
    public String getString(String key, @Nullable String defValue) {
        return sharedReadable.getString(key, defValue);
    }

    @Nullable
    @Override
    public Set<String> getStringSet(String key, @Nullable Set<String> defValues) {
        return sharedReadable.getStringSet(key, defValues);
    }

    public int getInt(String key, int def) {
        return sharedReadable.getInt(key, def);
    }

    @Override
    public long getLong(String key, long defValue) {
        return sharedReadable.getLong(key, defValue);
    }

    @Override
    public float getFloat(String key, float defValue) {
        return sharedReadable.getFloat(key, defValue);
    }

    public boolean getBoolean(String key, boolean def) {
        return sharedReadable.getBoolean(key, def);
    }

    @Override
    public boolean contains(String key) {
        return sharedReadable.contains(key);
    }

    @Override
    public void remove(String key) {
        sharedWritable.remove(key).commit();
    }

    @Override
    public void clear() {
        sharedWritable.clear().commit();
    }

}
