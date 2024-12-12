/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.dagger.user

import com.example.android.dagger.storage.Storage

const val REGISTERED_USER = "registered_user"
private const val PASSWORD_SUFFIX = "password"

/**
 * Handles User lifecycle. Manages registrations, logs in and logs out.
 * Knows when the user is logged in.
 * 处理用户生命周期。管理注册、登录和注销。知道用户何时登录。
 *
 * UserDataRepository对象有无判断是否登录。不能直接使用依赖注入。
 * 这也是合理的，UserManager不仅处理用户生命周期，而且管理用户数据。
 *
 */
class UserManager(private val storage: Storage) {

    /**
     *  UserDataRepository is specific to a logged in user. This determines if the user
     *  is logged in or not, when the user logs in, a new instance will be created.
     *  When the user logs out, this will be null.
     *  UserDataRepository 特定于已登录的用户。这决定了用户是否已登录，当用户登录时，将创建一个新实例。当用户注销时，这将为 null。
     *
     *
     */
    var userDataRepository: UserDataRepository? = null

    val username: String
        get() = storage.getString(REGISTERED_USER)

    /**
     * 通过用户数据库对象有无判断是否登录
     */
    fun isUserLoggedIn() = userDataRepository != null

    /**
     * 通过SP中用户名有无判断是否注册
     */
    fun isUserRegistered() = storage.getString(REGISTERED_USER).isNotEmpty()

    /**
     * 注册操作
     * 存储 + 登录成功操作
     */
    fun registerUser(username: String, password: String) {
        storage.setString(REGISTERED_USER, username)
        storage.setString("$username$PASSWORD_SUFFIX", password)
        userJustLoggedIn()
    }

    /**
     * 登录操作
     * 校验 + 成功操作
     */
    fun loginUser(username: String, password: String): Boolean {
        val registeredUser = this.username
        if (registeredUser != username) return false

        val registeredPassword = storage.getString("$username$PASSWORD_SUFFIX")
        if (registeredPassword != password) return false

        userJustLoggedIn()
        return true
    }

    /**
     * 退出
     */
    fun logout() {
        userDataRepository = null
    }

    /**
     * 注销（清理数据+退出）
     */
    fun unregister() {
        val username = storage.getString(REGISTERED_USER)
        storage.setString(REGISTERED_USER, "")
        storage.setString("$username$PASSWORD_SUFFIX", "")
        logout()
    }

    /**
     * 登录成功操作
     */
    private fun userJustLoggedIn() {
        //todo改造点
        userDataRepository = UserDataRepository(storage)
    }
}
