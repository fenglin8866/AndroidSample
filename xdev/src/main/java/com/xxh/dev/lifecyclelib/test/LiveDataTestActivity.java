package com.xxh.dev.lifecyclelib.test;


import androidx.lifecycle.ViewModelProvider;

import com.xxh.dev.BaseActivity;
import com.xxh.dev.databinding.ActivityLiveDataTestBinding;


public class LiveDataTestActivity extends BaseActivity<ActivityLiveDataTestBinding> {

    private LiveDataTestViewModel mViewModel;

    @Override
    protected void initBinding() {
        mBinding=ActivityLiveDataTestBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {
        super.initData();
        mViewModel=new ViewModelProvider(this).get(LiveDataTestViewModel.class);
    }

    @Override
    protected void initView() {
        super.initView();
        mBinding.comput.setOnClickListener(v -> {
            mViewModel.getResult().observe(this, s -> mBinding.computResult.setText(s));
        });
    }
}