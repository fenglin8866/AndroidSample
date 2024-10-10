package com.xxh.dev.lifecyclelib.test;

import static androidx.lifecycle.Lifecycle.Event.ON_CREATE;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public class SearchManager implements SavedStateRegistry.SavedStateProvider {

    private static String PROVIDER = "search_manager";
    private static String QUERY = "query";
    private String query = null;

    public SearchManager(SavedStateRegistryOwner owner) {
        owner.getLifecycle().addObserver((LifecycleEventObserver) (source, event) -> {
            if (event == ON_CREATE) {
                SavedStateRegistry registry=owner.getSavedStateRegistry();

                registry.registerSavedStateProvider(PROVIDER, this);

                Bundle bundle = registry.consumeRestoredStateForKey(PROVIDER);

                if (bundle != null) {
                    query = bundle.getString(QUERY);
                }

            }
        });


    }

    @NonNull
    @Override
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putString(QUERY, query);
        return bundle;
    }
}
