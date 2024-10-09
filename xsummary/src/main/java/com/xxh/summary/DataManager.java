package com.xxh.summary;

import androidx.lifecycle.MutableLiveData;

/**
 * 单例模式，存储全局的数据信息
 */
public class DataManager {

    private MutableLiveData<String> data;

    private DataManager() {
    }

    public static DataManager getInstance() {
        return Holder.INSTANCE;
    }

    final static class Holder {
        private static final DataManager INSTANCE = new DataManager();
    }

    public MutableLiveData<String> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
        }
        return data;
    }
}
