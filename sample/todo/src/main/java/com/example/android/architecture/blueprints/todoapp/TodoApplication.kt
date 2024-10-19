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

package com.example.android.architecture.blueprints.todoapp

import android.app.Application
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import com.xxh.basic.IComponentApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import timber.log.Timber
import timber.log.Timber.DebugTree


class TodoApplication : IComponentApplication {
    // No need to cancel this scope as it'll be torn down with the process

    override fun init(application: Application) {
        TodoApp.init(application)
    }
}

object TodoApp {
    lateinit var taskRepository: TasksRepository
    fun init(application: Application) {
        taskRepository = ServiceLocator.provideTasksRepository(application)
    }
}
