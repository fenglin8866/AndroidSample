package com.xxh.summary.lifecycle.source.lifecycle

import androidx.annotation.RestrictTo


/**
 * @hide
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP_PREFIX)
public interface GeneratedAdapter {
    /**
     * Called when a state transition event happens.
     *
     * @param source The source of the event
     * @param event The event
     * @param onAny approveCall onAny handlers
     * @param logger if passed, used to track called methods and prevent calling the same method
     *                  twice
     */
    public fun callMethods(
        source: LifecycleOwner,
        event: Lifecycle.Event,
        onAny: Boolean,
        logger: MethodCallsLogger?
    )
}