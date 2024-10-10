package com.xxh.dev.lifecyclelib.test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;


public class MyViewModel extends ViewModel {
    private MediatorLiveData<String> data;
    private final MutableLiveData<String> liveData1 = new MutableLiveData<>();
    private final MutableLiveData<String> liveData2 = new MutableLiveData<>();

    public LiveData<String> getData() {
        if (data == null) {
            data = new MediatorLiveData<>();
            loadData();
        }
        return data;
    }

    private void loadData() {
        data.addSource(liveData1, s -> data.setValue(s));
        data.addSource(liveData2, s -> data.setValue(s));
    }

    public MutableLiveData<String> getLiveData1(){
        return liveData1;
    }

    public MutableLiveData<String> getLiveData2(){
        return liveData2;
    }




    private LiveData<User> getUser(String id) {
            return new MutableLiveData<>(new User(id));
    }

    LiveData<String> userId = new MutableLiveData<>();
    LiveData<User> user = Transformations.switchMap(userId, id -> getUser(id));

}