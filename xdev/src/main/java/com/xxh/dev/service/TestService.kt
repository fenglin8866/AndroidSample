package com.xxh.dev.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log

class TestService : Service() {
    private lateinit var runnable: Runnable
    private val handler =Handler()
    override fun onCreate() {
        super.onCreate()
        runnable=object : Runnable{
            override fun run() {
                Log.d("xxh","Service is onCreate  running....")
                handler.postDelayed(this,1000)
            }
        }

    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Log.d("xxh","Service is onStart....")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("xxh","Service is onDestroy....")
        handler.removeCallbacks(runnable)
    }

    override fun onBind(intent: Intent): IBinder? {
       // TODO("Return the communication channel to the service.")
        return null
    }
}