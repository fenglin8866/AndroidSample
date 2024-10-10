package com.xxh.dev.lifecyclelib.lifecycle;

import androidx.annotation.NonNull;

public class Lifecycling {

    @NonNull
    static LifecycleEventObserver lifecycleEventObserver(Object object) {
        boolean isLifecycleEventObserver = object instanceof LifecycleEventObserver;
        boolean isFullLifecycleObserver = object instanceof FullLifecycleObserver;
        if (isLifecycleEventObserver && isFullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) object,
                    (LifecycleEventObserver) object);
        }
        if (isFullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) object, null);
        }

        if (isLifecycleEventObserver) {
            return (LifecycleEventObserver) object;
        }

        return null;
    }


    private Lifecycling() {
    }
}
//1652861076840
//https://www.eSurveyspro.com/Survey.aspx?id=5b0ff3b8-185d-4d5f-8421-162838486890
//https://www.eSurveysPro.com/Survey.aspx?id=5b0ff3b8-185d-4d5f-8421-162838486890