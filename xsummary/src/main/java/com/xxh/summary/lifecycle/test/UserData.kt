package com.xxh.summary.lifecycle.test

import androidx.savedstate.SavedStateRegistry.AutoRecreated
import androidx.savedstate.SavedStateRegistryOwner


class UserData: AutoRecreated {
    override fun onRecreated(owner: SavedStateRegistryOwner) {
        TODO("Not yet implemented")

    }
}