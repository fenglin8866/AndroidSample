package com.xxh.summary.lifecycle.test.viewmodel

import com.xxh.summary.lifecycle.source.viewmodel.ViewModel
import com.xxh.summary.lifecycle.test.CloseableCoroutineScope

class MyViewModel2(
    private val coroutineScope: CloseableCoroutineScope = CloseableCoroutineScope()
) : ViewModel(coroutineScope) {
    // Other ViewModel logic ...
}