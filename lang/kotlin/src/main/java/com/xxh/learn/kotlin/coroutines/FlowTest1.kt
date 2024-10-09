package com.xxh.learn.kotlin.coroutines

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking





fun main() = runBlocking{
   /* val sf= MutableStateFlow(3)
    sf.subscriptionCount
        .map { count -> count > 0 } // map count into active/inactive flag
        .distinctUntilChanged() // only react to true<->false changes
        .onEach { isActive -> // configure an action
            if (isActive) onActive() else onInactive()
        }
        .launchIn(scope) // launch it*/

}

