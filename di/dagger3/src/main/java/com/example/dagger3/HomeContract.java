package com.example.dagger3;

import com.example.dagger3.data.Car;

public interface HomeContract {
    interface IHomeView extends IView{
        void showCar(Car car);
    }

    interface IHomePresenter extends IPresenter{
        void start();
        void nextRandomCar();
    }
}
