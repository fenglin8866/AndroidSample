package com.xxh.learn.fragment.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.xxh.basic.BaseFragment
import com.xxh.learn.fragment.R
import com.xxh.learn.fragment.databinding.FragmentNavigationBinding

class NavigationFragment : BaseFragment<FragmentNavigationBinding>() {
    override fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNavigationBinding {
        return FragmentNavigationBinding.inflate(inflater, container, false)
    }

    override fun setupViews() {
        super.setupViews()
        mBinding.button.setOnClickListener{
            findNavController().navigate(R.id.to_profile_fragment)
        }
    }


}