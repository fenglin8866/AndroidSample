package com.example.dagger3;

import com.example.dagger3.data.CarResource;

public class HomePresenter implements HomeContract.IHomePresenter {

    private HomeContract.IHomeView mView;

    private CarResource mCarResource;

    public HomePresenter(CarResource carResource) {
        mCarResource = carResource;
    }

    @Override
    public void takeView(IView iView) {
        mView = (HomeContract.IHomeView) iView;
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public void start() {
        nextRandomCar();
    }

    @Override
    public void nextRandomCar() {
        mView.showCar(mCarResource.getRandomCar());
    }
}
