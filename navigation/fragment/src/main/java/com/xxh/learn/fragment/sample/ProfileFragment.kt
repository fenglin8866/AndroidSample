package com.xxh.learn.fragment.sample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.xxh.basic.BaseFragment
import com.xxh.learn.fragment.R
import com.xxh.learn.fragment.databinding.FragmentProfileBinding

/**
 * 知识点：
 * 0.LiveData的注册建议放在onCreate的方法。减少反复注册。
 *   但viewLifecycleOwner必须在onCreateView()中或之后 ，因为when getView() is null i.e., before onCreateView() or after onDestroyView()
 * 1、LiveData活跃状态才执行
 * 2、LiveData的执行过程
 *   添加observer，没有设置值，该观察者不执行
 * 3、Fragment的生命周期，特别是从返回堆栈回退的时候
 * 导航返回时onCreateView，onCreateView都会执行。
 */

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("xxh99", "onCreate")
        val navController = findNavController()

        val currentBackStackEntry = navController.currentBackStackEntry!!
        val savedStateHandle = currentBackStackEntry.savedStateHandle
        savedStateHandle.getLiveData<Boolean>(UserLoginFragment.LOGIN_SUCCESSFUL)
            .observe(currentBackStackEntry) { success ->
                Log.d("xxh99", "success=$success")
                if (!success) {
                    //LiveData活跃状态才执行
                    val startDestination = navController.graph.startDestinationId
                    val navOptions = NavOptions.Builder()
                        .setPopUpTo(startDestination, true)
                        .build()
                    navController.navigate(startDestination, null, navOptions)
                }
            }
    }


    override fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater, container, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("xxh99", "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun setupViews() {
        super.setupViews()
        Log.d("xxh99", "onViewCreated")
        /**
         *  fixme  LiveData在此处绑定，返回时会导致重复绑定。
         * 但不能在onCreate中初始化，因为when getView() is null i.e., before onCreateView() or after onDestroyView()
         *
         */
        userViewModel.user.observe(viewLifecycleOwner) { user ->
            Log.d("xxh", "xx")
            if (user != null) {
                showWelcomeMessage()
            } else {
                //fixme,没有登录返回，导致异常
                //findNavController().navigate(R.id.login_fragment)
            }
        }
        //fixme,没有登录返回，导致异常
         if (userViewModel.user.value == null) {
             findNavController().navigate(R.id.login_fragment)
         }

    }


    private fun showWelcomeMessage() {

    }


}