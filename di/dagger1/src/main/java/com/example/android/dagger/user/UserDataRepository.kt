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
import kotlin.random.Random

/**
 * UserDataRepository contains user-specific data such as username and unread notifications.
 *
 *  UserDataRepository
 *  作用：包含特定于用户的数据，例如用户名和未读通知
 *  操作：用户数据读取更新
 *  作用域：全局访问
 *
 * 疑问点：感觉别扭，UserDataRepository与UserManager相互关联。
 * 优化解耦
 * 方案一：传入username，不行，注册时传入的username没有变化。解决：传入的username是可观察的，并且是同步的。
 * 方案二：存在Storage，通过Storage获取username，是否存在内存泄漏，不存在。Storage的生命周期比UserDataRepository生命周期长
 * 方案三：参考官网架构优化 。数据层，UI层，领域层
 *
 */
class UserDataRepository(private val storage: Storage) {

    val username: String
        get() = storage.getString(REGISTERED_USER)

    var unreadNotifications: Int

    init {
        unreadNotifications = randomInt()
    }

    fun refreshUnreadNotifications() {
        unreadNotifications = randomInt()
    }
}

fun randomInt(): Int {
    return Random.nextInt(until = 100)
}
