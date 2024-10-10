package com.xxh.summary.lifecycle.test.lifecycle

import android.content.Context
import android.location.Location
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

internal class MyLocationListener(
    private val context: Context,
    private val lifecycle: Lifecycle,
    private val callback: (Location) -> Unit
): DefaultLifecycleObserver {

    private var enabled = false

    override fun onStart(owner: LifecycleOwner) {
        if (enable()) {
            // connect
        }
    }

    /*fun enable() {
        enabled = true
        //使用State而不是Event
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected

        }
    }*/

    private fun enable() = lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)

    override fun onStop(owner: LifecycleOwner) {
        // disconnect if connected
    }
}