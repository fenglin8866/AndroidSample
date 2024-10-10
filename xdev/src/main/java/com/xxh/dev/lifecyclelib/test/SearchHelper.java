package com.xxh.dev.lifecyclelib.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public class SearchHelper implements SavedStateRegistry.SavedStateProvider {
    private static final String qure="a";
    private static final String b="a";

    public SearchHelper(SavedStateRegistryOwner owner) {
        owner.getLifecycle().addObserver((LifecycleEventObserver) (source, event) -> {
            if (event == Lifecycle.Event.ON_CREATE) {
                SavedStateRegistry registry = owner.getSavedStateRegistry();
                registry.registerSavedStateProvider(qure, this);
                Bundle state = registry.consumeRestoredStateForKey(qure);
                if (state != null) {

                }
            }
        });

    }


    @NonNull
    @Override
    public Bundle saveState() {
        Bundle bundle=new Bundle();
        bundle.putString(b,"dd");
        return bundle;
    }
}
