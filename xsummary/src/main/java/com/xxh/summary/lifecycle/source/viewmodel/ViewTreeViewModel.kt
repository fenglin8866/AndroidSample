package com.xxh.summary.lifecycle.source.viewmodel

import android.view.View
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner

/**
 * Locates the [ViewModelStoreOwner] associated with this [View], if present.
 * This may be used to retain state associated with this view across configuration changes.
 */
@Deprecated(
    message = "Replaced by View.findViewTreeViewModelStoreOwner in ViewTreeViewModelStoreOwner",
    replaceWith = ReplaceWith(
        "View.findViewTreeViewModelStoreOwner",
        "androidx.lifecycle.ViewTreeViewModelStoreOwner"
    ),
    level = DeprecationLevel.HIDDEN
)
public fun findViewTreeViewModelStoreOwner(view: View): ViewModelStoreOwner? =
    view.findViewTreeViewModelStoreOwner()