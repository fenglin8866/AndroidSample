package com.xxh.summary.lifecycle.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xxh.summary.lifecycle.test.viewmodel.User

class UserModel : ViewModel() {
    val userLiveData: LiveData<User> = MutableLiveData()

    fun doAction() {

    }
}