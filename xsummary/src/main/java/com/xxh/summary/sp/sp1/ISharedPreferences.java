package com.xxh.summary.sp.sp1;

import java.util.Set;

public interface ISharedPreferences {
    void putString(String key, String value);

    void putBoolean(String key, boolean value);

    void putInt(String key, int value);

    void putLong(String key, long value);

    void putFloat(String key, float value);

    void putStringSet(String key, Set<String> values);

}
