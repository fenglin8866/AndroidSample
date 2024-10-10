package com.xxh.summary.lifecycle.source.lifecycle;

import androidx.annotation.NonNull;


/**
 * An internal implementation of {@link LifecycleObserver} that relies on reflection.
 *
 * @deprecated internal infra to support deprecated {@link OnLifecycleEvent}
 */
@Deprecated
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    private final Object mWrapped;
    private final ClassesInfoCache.CallbackInfo mInfo;

    @SuppressWarnings("deprecation")
    ReflectiveGenericLifecycleObserver(Object wrapped) {
        mWrapped = wrapped;
        mInfo =ClassesInfoCache.sInstance.getInfo(mWrapped.getClass());
    }

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        mInfo.invokeCallbacks(source, event, mWrapped);
    }
}
