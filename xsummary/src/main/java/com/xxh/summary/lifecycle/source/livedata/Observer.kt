package com.xxh.summary.lifecycle.source.livedata

import androidx.lifecycle.LiveData

/**
 * A simple callback that can receive from [LiveData].
 *
 * @see LiveData LiveData - for a usage description.
 */
fun interface Observer<T> {

    /**
     * Called when the data is changed is changed to [value].
     */
    fun onChanged(value: T)
}