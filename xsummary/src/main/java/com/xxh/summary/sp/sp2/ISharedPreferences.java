package com.xxh.summary.sp.sp2;


import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;

public interface ISharedPreferences {
    void putString(String key, String value);

    void putBoolean(String key, boolean value);

    void putInt(String key, int value);

    void putLong(String key, long value);

    void putFloat(String key, float value);

    void putStringSet(String key, Set<String> values);


    Map<String, ?> getAll();

    @Nullable
    String getString(String key, @Nullable String defValue);

    @Nullable
    Set<String> getStringSet(String key, @Nullable Set<String> defValues);

    int getInt(String key, int defValue);


    long getLong(String key, long defValue);


    float getFloat(String key, float defValue);

    boolean getBoolean(String key, boolean defValue);

    boolean contains(String key);

    void remove(String key);

    void clear();


}
