package com.xxh.learn.java.base.base3.wirte;

import com.xxh.learn.java.base.base3.dagger1.*;
import dagger.internal.Factory;
/*import org.example.base.base3.dagger1.Brake;
import org.example.base.base3.dagger1.Engine;*/

public class Engine_Factory1 implements Factory<Engine> {
    private Engine_Factory1() {
    }

    public static Engine_Factory1 create(){
        return InstanceHolder.INSTANCE;
    }

    @Override
    public Engine get() {
        return newInstance();
    }

    private Engine newInstance(){
        return new Engine(new Brake());
    }

    private static final class InstanceHolder{
        private static final Engine_Factory1 INSTANCE=new Engine_Factory1();
    }
}
