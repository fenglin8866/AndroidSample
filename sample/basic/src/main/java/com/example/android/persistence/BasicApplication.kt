package com.example.android.persistence

import android.app.Application
import com.example.android.persistence.db.AppDatabase
import com.xxh.basic.IComponentApplication


class BasicApplication : IComponentApplication {

    override fun init(application: Application) {
        BasicApp.init(application)
    }
}

object BasicApp {
    private var mAppExecutors: AppExecutors? = null

    lateinit var dataRepository:DataRepository

    fun init(application: Application) {
        mAppExecutors = AppExecutors()
        val appDatabase=AppDatabase.getInstance(application, mAppExecutors)
        dataRepository=DataRepository.getInstance(appDatabase)
    }
}