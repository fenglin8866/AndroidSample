package com.xxh.dev.lifecyclelib.test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BlankViewModel extends ViewModel {
    private MutableLiveData<String> data;

    public LiveData<String> getData() {
        if(data==null){
            data = new MutableLiveData<>();
            loadData();
        }
        return data;
    }

    private void loadData() {

    }
}