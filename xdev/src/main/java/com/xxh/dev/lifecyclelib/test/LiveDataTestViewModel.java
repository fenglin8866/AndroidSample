package com.xxh.dev.lifecyclelib.test;

import android.annotation.SuppressLint;

import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


public class LiveDataTestViewModel extends ViewModel {
    private LiveData<String> mResult;
    @SuppressLint("RestrictedApi")
    public LiveData<String> getResult(){
        if(mResult==null){
            mResult=new ComputableDate().getLiveData();
        }
        return mResult;
    }

}

@SuppressLint("RestrictedApi")
class ComputableDate extends ComputableLiveData<String>{

    @Override
    protected String compute() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "2000";
    }
}
