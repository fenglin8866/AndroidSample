package com.xxh.learn.java.base.base3.dagger6;/*
package org.example.base.base3.dagger6;

import dagger.Component;
import dagger.Subcomponent;

import javax.inject.Scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public interface ComponentDependency {

    @PhoneScope
    @Component(modules = {PhoneModule.class, PhoneModule2.class})
    interface PhoneComponent {
        void inject(Phone phone);

        Screen getScreen();

        Battery getBattery();

        Ram getRam();

        CPU getCPU();

        PadComponent2 padComponent2();

        PadComponent3.Builder padComponent3Builder();

        PadComponent4.Builder padComponent4Builder();

    }

    @PadScope
    @Component(dependencies = PhoneComponent.class, modules = PadModule.class)
    interface PadComponent {
        void injectPad(Pad pad);
    }


    @Subcomponent(modules = PadModule.class)
    interface PadComponent2 {
        void injectPad(Pad pad);

    }


    @Subcomponent(modules = PadModule.class)
    interface PadComponent3 {
        void injectPad(Pad pad);

        @Subcomponent.Builder
        interface Builder {

            Builder padModule(PadModule module);

            PadComponent3 build();
        }
    }

    @Subcomponent(modules = PadModule.class)
    interface PadComponent4 {
        void injectPad(Pad pad);

        MaxCPU maxCPU();

        @Subcomponent.Builder
        interface Builder {

            PadComponent4.Builder padModule(PadModule module);

            PadComponent4 build();
        }
    }


    @Scope
    @Documented
    @Retention(RUNTIME)
    @interface PadScope {
    }

    @Scope
    @Documented
    @Retention(RUNTIME)
    @interface PhoneScope {
    }

}
*/
