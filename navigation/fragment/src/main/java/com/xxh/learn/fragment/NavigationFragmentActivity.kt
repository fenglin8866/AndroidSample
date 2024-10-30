package com.xxh.learn.fragment

import android.view.LayoutInflater
import com.xxh.basic.BaseActivity
import com.xxh.learn.fragment.databinding.ActivityNavigationFragmentBinding

class NavigationFragmentActivity : BaseActivity<ActivityNavigationFragmentBinding>() {

    override fun bindView(inflater: LayoutInflater): ActivityNavigationFragmentBinding {
        return ActivityNavigationFragmentBinding.inflate(inflater)
    }

    override fun setupViews() {
        super.setupViews()
    }
}