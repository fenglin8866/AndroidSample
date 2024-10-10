package com.xxh.dev.lifecyclelib.test;


import android.util.Log;
import android.view.View;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;

import com.xxh.dev.BaseActivity;
import com.xxh.dev.databinding.ActivityTestLiveDataBinding;


public class TestLiveDataActivity extends BaseActivity<ActivityTestLiveDataBinding> {

    private MyViewModel viewModel;
    private MutableLiveData<User> liveData;
    private LiveData<String> i;
    private LiveData<String> data;

    @Override
    protected void initBinding() {
        mBinding = ActivityTestLiveDataBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        super.initView();
        liveData = new MutableLiveData<>();
        User user =new User("xxh",32);
        /*liveData.observeForever(new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Log.i("xxh11",user.toString());
            }
        });*/
      /*  i = Transformations.map(liveData, new Function<User, String>() {
            @Override
            public String apply(User user) {
                //Log.e("xxh",i.getValue());
                Log.i("xxh11",user.toString());
                return user.name+user.age;
            }
        });*/
        i.observeForever(new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.i("xxh11",s);
            }
        });

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
       // data=viewModel.getData();
       /* viewModel.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mBinding.textView.setText(s);
            }
        });*/
        mBinding.ld1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String t1 = mBinding.ed1.getText().toString();
                viewModel.getLiveData1().setValue(t1);*/
                liveData.setValue(user);

            }
        });
        mBinding.ld2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String t2 = mBinding.ed2.getText().toString();
                viewModel.getLiveData2().setValue(t2);*/
                //Log.i("xxh11 onClick",liveData.getValue().toString());
                Log.i("xxh11 onClick",data.getValue());

            }
        });


    }
}