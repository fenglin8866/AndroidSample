package com.example.dagger3;

public interface IPresenter {
    void takeView(IView baseView);
    void dropView();
}
