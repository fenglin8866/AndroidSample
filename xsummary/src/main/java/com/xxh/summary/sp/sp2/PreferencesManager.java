package com.xxh.summary.sp.sp2;

import android.content.Context;

public class PreferencesManager {
    private static volatile PreferencesManager instance;
    private IUserPreferences userPreferences;

    public static PreferencesManager getInstance() {
        if (instance == null) {
            synchronized (PreferencesManager.class) {
                if (instance == null) {
                    instance = new PreferencesManager();
                }
            }
        }
        return instance;
    }

    public IUserPreferences getUserPreferences() {
        return userPreferences;
    }

    private void setUserPreferences(IUserPreferences userPreferences) {
        this.userPreferences = userPreferences;
    }

    private void setConfigsPreferences(IUserPreferences userPreferences) {
        this.userPreferences = userPreferences;
    }

    /**
     * application初始化
     * 疑问点：同时构建多个SharedPreferences对象是不是相互影响？
     * 系统内部是不是单例的形式
     */
    public void initPreferences(Context context) {
        setUserPreferences(new UserPreferences(context));
        //setConfigsPreferences();
    }
}
