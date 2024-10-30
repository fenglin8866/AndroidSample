package com.xxh.learn.fragment.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UserViewModel : ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    private val _loginResult = MutableLiveData<UserLoginResult>()
    private val loginResult: LiveData<UserLoginResult> = _loginResult

    fun login(username: String, password: String): LiveData<UserLoginResult> {
        if (username == "xxh" && password == "11") {
            _loginResult.value = UserLoginResult(true, 1)
            _user.value = User(username, password)
        } else {
            _loginResult.value = UserLoginResult(false, 1)
            //fixme 登录失败，不能构建User，此处是为了处理返回异常，添加的特殊逻辑
            _user.value = User(username, password)
        }
        return loginResult
    }
}