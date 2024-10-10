package com.xxh.dev.lifecyclelib.savedstate;

import android.os.Bundle;

import androidx.annotation.NonNull;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.xxh.dev.lifecyclelib.lifecycle.Lifecycle;
import com.xxh.dev.lifecyclelib.lifecycle.LifecycleEventObserver;
import com.xxh.dev.lifecyclelib.lifecycle.LifecycleOwner;

final class Recreator implements LifecycleEventObserver {

    static final String CLASSES_KEY = "classes_to_restore";
    static final String COMPONENT_KEY = "androidx.savedstate.Restarter";

    private final SavedStateRegistryOwner mOwner;

    Recreator(SavedStateRegistryOwner owner) {
        mOwner = owner;
    }

    @Override
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.getLifecycle().removeObserver(this);
        Bundle bundle = mOwner.getSavedStateRegistry()
                .consumeRestoredStateForKey(COMPONENT_KEY);
        if (bundle == null) {
            return;
        }
        ArrayList<String> classes = bundle.getStringArrayList(CLASSES_KEY);
        if (classes == null) {
            throw new IllegalStateException("Bundle with restored state for the component \""
                    + COMPONENT_KEY + "\" must contain list of strings by the key \""
                    + CLASSES_KEY + "\"");
        }
        for (String className : classes) {
            reflectiveNew(className);
        }
    }

    private void reflectiveNew(String className) {
        Class<? extends SavedStateRegistry.AutoRecreated> clazz;
        try {
            clazz = Class.forName(className, false,
                    Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class " + className + " wasn't found", e);
        }

        Constructor<? extends SavedStateRegistry.AutoRecreated> constructor;
        try {
            constructor = clazz.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Class" + clazz.getSimpleName() + " must have "
                    + "default constructor in order to be automatically recreated", e);
        }
        constructor.setAccessible(true);

        SavedStateRegistry.AutoRecreated newInstance;
        try {
            newInstance = constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate " + className, e);
        }
        newInstance.onRecreated(mOwner);
    }

    static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        @SuppressWarnings("WeakerAccess") // synthetic access
        final Set<String> mClasses = new HashSet<>();

        SavedStateProvider(final SavedStateRegistry registry) {
            registry.registerSavedStateProvider(COMPONENT_KEY, this);
        }

        @NonNull
        @Override
        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(CLASSES_KEY, new ArrayList<>(mClasses));
            return bundle;
        }

        void add(String className) {
            mClasses.add(className);
        }
    }
}
