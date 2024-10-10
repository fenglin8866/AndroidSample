@file:JvmName("ViewTreeViewModelStoreOwner")

package com.xxh.summary.lifecycle.source.viewmodel

import android.view.View
import com.xxh.summary.R

/**
 * Set the [ViewModelStoreOwner] associated with the given [View].
 * Calls to [get] from this view or descendants will return
 * `viewModelStoreOwner`.
 *
 * This should only be called by constructs such as activities or fragments that manage
 * a view tree and retain state through a [ViewModelStoreOwner]. Callers
 * should only set a [ViewModelStoreOwner] that will be *stable.* The associated
 * [ViewModelStore] should be cleared if the view tree is removed and is not
 * guaranteed to later become reattached to a window.
 *
 * @param viewModelStoreOwner ViewModelStoreOwner associated with the given view
 */
@JvmName("set")
fun View.setViewTreeViewModelStoreOwner(viewModelStoreOwner: ViewModelStoreOwner?) {
    setTag(R.id.view_tree_view_model_store_owner, viewModelStoreOwner)
}

/**
 * Retrieve the [ViewModelStoreOwner] associated with the given [View].
 * This may be used to retain state associated with this view across configuration changes.
 *
 * @return The [ViewModelStoreOwner] associated with this view and/or some subset
 * of its ancestors
 */
@JvmName("get")
fun View.findViewTreeViewModelStoreOwner(): ViewModelStoreOwner? {
    return generateSequence(this) { view ->
        view.parent as? View
    }.mapNotNull { view ->
        view.getTag(R.id.view_tree_view_model_store_owner) as? ViewModelStoreOwner
    }.firstOrNull()
}