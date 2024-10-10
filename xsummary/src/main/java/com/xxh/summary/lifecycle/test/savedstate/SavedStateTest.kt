package com.xxh.summary.lifecycle.test.savedstate

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryOwner

class SavedStateTest(registryOwner: SavedStateRegistryOwner) :
    SavedStateRegistry.SavedStateProvider {
    companion object {
        private const val PROVIDER = "test_saved_state"
        private const val QUERY = "query"
    }

    var content: String? = null

    init {
        registryOwner.lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_CREATE) {
                // owner.savedStateRegistry.registerSavedStateProvider(,this)
                val registry = registryOwner.savedStateRegistry
                // Register this object for future calls to saveState()
                registry.registerSavedStateProvider(PROVIDER, this)
                // Get the previously saved state and restore it
                val state = registry.consumeRestoredStateForKey(PROVIDER)
                // Apply the previously saved state
                content = state?.getString(QUERY)
            }
        })

    }

    override fun saveState(): Bundle {
        return bundleOf(QUERY to content)
    }
}