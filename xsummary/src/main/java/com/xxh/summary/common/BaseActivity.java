package com.xxh.summary.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;


public abstract class BaseActivity<T extends ViewBinding> extends AppCompatActivity {
    protected T mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        setContentView(mBinding.getRoot());
        initData();
        initView();
    }

    protected abstract void initBinding();

    protected void initData() {

    }

    protected void initView() {

    }

}
