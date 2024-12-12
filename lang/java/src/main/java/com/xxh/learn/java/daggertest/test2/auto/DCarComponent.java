package com.xxh.learn.java.daggertest.test2.auto;

import com.xxh.learn.java.daggertest.test2.Car;
import com.xxh.learn.java.daggertest.test2.CarComponent;
import com.xxh.learn.java.daggertest.test2.CarModel;
import com.xxh.learn.java.daggertest.test2.Engine;
import com.xxh.learn.java.daggertest.test2.FuelTank;
import com.xxh.learn.java.daggertest.test2.NewEnergyCar;
import com.xxh.learn.java.daggertest.test2.NewEnergyCarComponent;
import com.xxh.learn.java.daggertest.test2.NewEnergyCarModel;
import com.xxh.learn.java.daggertest.test2.SoftwareComponent;
import com.xxh.learn.java.daggertest.test2.Wheel;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SingleCheck;

public class DCarComponent {
    private DCarComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static CarComponent create() {
        return new Builder().build();
    }


    private static class Builder {
        private CarModel carModel;
        private SoftwareComponent softwareComponent;

        private Builder() {

        }

        private Builder carModel(CarModel carModel) {
            this.carModel = carModel;
            return this;
        }

        private Builder softwareComponent(SoftwareComponent softwareComponent) {
            this.softwareComponent = Preconditions.checkNotNull(softwareComponent);
            return this;
        }

        private CarComponent build() {
            if (carModel == null) {
                carModel = new CarModel();
            }
            Preconditions.checkBuilderRequirement(softwareComponent, SoftwareComponent.class);
            return new CarComponentImp(carModel, softwareComponent);
        }

    }

    private static final class NewEnergyCarComponentImp implements NewEnergyCarComponent {
        private final CarComponentImp carComponentImp;
        private NewEnergyCarModel newEnergyCarModel;

        private NewEnergyCarComponentImp(CarComponentImp carComponentImp) {
            this.carComponentImp = carComponentImp;
            newEnergyCarModel = new NewEnergyCarModel();
        }


        @Override
        public void inject(NewEnergyCar car) {

        }

    }


    private static final class CarComponentImp implements CarComponent {
        private final CarModel carModel;
        private final SoftwareComponent softwareComponent;

        private Provider<Wheel> provideWheelProvider;
        private Provider<FuelTank> provideFuelTankProvider;

        private CarComponentImp(CarModel carModel, SoftwareComponent softwareComponent) {
            this.carModel = carModel;
            this.softwareComponent = softwareComponent;
            initialize();
        }

        private void initialize() {
            provideWheelProvider = SingleCheck.provider(CarModelProvideWheelFactory.create(carModel));
            provideFuelTankProvider = DoubleCheck.provider(CarModelProvideFuelTankFactory.create(carModel));
        }

        @Override
        public void inject(Car car) {
            injectCar(car);
        }

        @Override
        public NewEnergyCarComponent newEnergyCarComponent() {
            return new NewEnergyCarComponentImp(this);
        }

        private void injectCar(Car car) {
            CarMembersInjector.injectEngine(car, new Engine());
            CarMembersInjector.injectBrake(car, carModel.provideBrake());
            CarMembersInjector.injectWheel(car, provideWheelProvider.get());
            CarMembersInjector.injectFueTank(car, provideFuelTankProvider.get());
            CarMembersInjector.injectSoftware(car, softwareComponent.software());
        }
    }
}
