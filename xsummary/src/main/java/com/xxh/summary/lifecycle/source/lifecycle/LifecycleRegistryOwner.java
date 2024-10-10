package com.xxh.summary.lifecycle.source.lifecycle;

import androidx.annotation.NonNull;

/**
 * @deprecated Use {@code androidx.appcompat.app.AppCompatActivity}
 * which extends {@link androidx.lifecycle.LifecycleOwner}, so there are no use cases for this class.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@Deprecated
public interface LifecycleRegistryOwner extends LifecycleOwner {
    @NonNull
    @Override
    LifecycleRegistry getLifecycle();
}
