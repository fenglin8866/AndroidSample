package com.xxh.learn.demo

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryOwner

class SavedTestDataManager(registryOwner: SavedStateRegistryOwner) : SavedStateRegistry.SavedStateProvider {
    private var query: String? = null

    init {
        registryOwner.lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == Lifecycle.Event.ON_CREATE) {
                    val registry=registryOwner.savedStateRegistry
                    //注册跟消费没有顺序关系。
                    registry.registerSavedStateProvider(
                        PROVIDER,
                        this@SavedTestDataManager
                    )
                    //只执行一次，第二次执行返回null
                    val state=registry.consumeRestoredStateForKey(PROVIDER)
                    query=state?.getString(QUERY)
                }
            }
        })

       /*registryOwner.lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_CREATE) {
                val registry = registryOwner.savedStateRegistry

                // Register this object for future calls to saveState()
                registry.registerSavedStateProvider(PROVIDER, this)

                // Get the previously saved state and restore it
                val state = registry.consumeRestoredStateForKey(PROVIDER)

                // Apply the previously saved state
                query = state?.getString(QUERY)
            }
        })*/

    }

    fun getTextData():String{
        return query?:"aaa"
    }

    fun setTextData(text:String){
        query=text
    }

    override fun saveState(): Bundle {
        return bundleOf(QUERY to query)
    }

    companion object {
        private const val PROVIDER = "SavedTestDataManager"
        private const val QUERY = "query"
    }
}