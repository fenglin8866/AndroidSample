package com.xxh.learn.fragment.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.findNavController
import com.xxh.basic.BaseFragment
import com.xxh.learn.fragment.databinding.FragmentLoginBinding

class UserLoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var savedStateHandle: SavedStateHandle

    companion object {
        const val LOGIN_SUCCESSFUL: String = "LOGIN_SUCCESSFUL"
    }

    override fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }


    override fun setupViews() {
        super.setupViews()
        savedStateHandle = findNavController().previousBackStackEntry!!.savedStateHandle
        savedStateHandle.set(LOGIN_SUCCESSFUL, false)

        mBinding.login.setOnClickListener {
            val username = mBinding.username.text.toString()
            val password = mBinding.password.text.toString()
            login(username, password)
        }
    }


    fun login(username: String, password: String) {
        userViewModel.login(username, password).observe(viewLifecycleOwner) { result ->
            if (result.success) {
                savedStateHandle.set(LOGIN_SUCCESSFUL, true)
                findNavController().popBackStack()
            } else {
                showErrorMessage()
            }
        }
    }

    fun showErrorMessage() {
        // Display a snackbar error message
    }

}