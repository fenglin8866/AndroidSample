package com.xxh.summary.sp.sp2;

import android.content.Context;

public class UserPreferences extends DefaultPreferences implements IUserPreferences {
    private static final String USER_NAME = "user_name";

    public UserPreferences(Context context) {
        super(context);
    }

    @Override
    public String getUserName() {
        return getPreferences().getString(USER_NAME, null);
    }

    @Override
    public void saveUserName(String value) {
        getPreferences().putString(USER_NAME, value);
    }
}
