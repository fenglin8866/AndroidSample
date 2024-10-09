package com.xxh.dev.ali;


import android.view.View;

import com.xxh.dev.BaseActivity;
import com.xxh.dev.databinding.ActivityAliBinding;


public class ALiYunActivity extends BaseActivity<ActivityAliBinding> {

    private FileObject fileObject=new FileObject();

    @Override
    protected void initBinding() {
        mBinding=ActivityAliBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {
        super.initData();
        try {
            fileObject.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initView() {
        super.initView();

        mBinding.deeplinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //deeplink();
                    //mBinding.deeplinkUrl.setText(linkUrl);
                    fileObject.getCloudSpace();
                }catch (Exception e){
                   // LogUtil.d("DeeplinkActivity",e.getMessage());
                }

            }
        });
    }
}