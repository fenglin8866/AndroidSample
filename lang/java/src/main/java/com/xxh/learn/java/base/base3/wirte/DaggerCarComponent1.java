package com.xxh.learn.java.base.base3.wirte;

/*import org.example.base.base3.dagger1.Car;
import org.example.base.base3.dagger1.CarComponent;
import org.example.base.base3.dagger1.Wheel;*/

import com.xxh.learn.java.base.base3.dagger1.*;

public class DaggerCarComponent1 {

    private DaggerCarComponent1() {
    }

    public static CarComponent create(){
        return new Builder().build();
    }

    public static Builder builder(){
        return new Builder();
    }

    private static final class Builder{
        private Builder() {
        }
        public CarComponentImpl build(){
            return new CarComponentImpl();
        }
    }


    private static final class CarComponentImpl implements CarComponent{

        private CarComponentImpl() {
        }

        @Override
        public void injectCar(Car car) {
            injectCar2(car);
        }

        @Override
        public Wheel generateEngine() {
            return Wheel_Factory1.create().get();
        }

        private Car injectCar2(Car car) {
            Car_MembersInjector1.create(Engine_Factory1.create(), Wheel_Factory1.create()).injectMembers(car);
            return car;
        }
    }
}
