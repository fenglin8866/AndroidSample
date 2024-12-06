package com.xxh.learn.java.daggertest.test.dagger;

import com.xxh.learn.java.daggertest.test.Book;
import com.xxh.learn.java.daggertest.test.Car;
import com.xxh.learn.java.daggertest.test.House;
import com.xxh.learn.java.daggertest.test.Phone;
import com.xxh.learn.java.daggertest.test.Tool;

import dagger.MembersInjector;
import dagger.internal.Provider;

/**
 * 依赖注入器，定义依赖关联
 */
public final class ToolMembersInjector implements MembersInjector<Tool> {

    private final Provider<Book> bookProvider;
    private final Provider<Car> carProvider;
    private final Provider<House> houseProvider;
    private final Provider<Phone> phoneProvider;

    //传入依赖工厂对象
    public ToolMembersInjector(Provider<Book> bookProvider, Provider<Car> carProvider, Provider<House> houseProvider, Provider<Phone> phoneProvider) {
        this.bookProvider = bookProvider;
        this.carProvider = carProvider;
        this.houseProvider = houseProvider;
        this.phoneProvider = phoneProvider;
    }

    //静态方法定义获取对象，用于外部调用
    public static ToolMembersInjector create(Provider<Book> bookProvider, Provider<Car> carProvider, Provider<House> houseProvider, Provider<Phone> phoneProvider) {
        return new ToolMembersInjector(bookProvider, carProvider, houseProvider, phoneProvider);
    }

    /*
     * 定义依赖关联
     */
    @Override
    public void injectMembers(Tool instance) {
        injectBook(instance, bookProvider.get());
        injectCar(instance, carProvider.get());
        injectPhone(instance, phoneProvider.get());
        injectHouse(instance, houseProvider.get());
    }

  /*  private void injectHouse(Tool instance) {
        instance.house = houseProvider.get();
    }

    private void injectPhone(Tool instance) {
        instance.phone = phoneProvider.get();
    }

    private void injectCar(Tool instance) {
        instance.car = carProvider.get();
    }

    private void injectBook(Tool instance) {
        instance.book = bookProvider.get();
    }*/

    //外部可直接调用,提供不同的调用方式
    public static void injectHouse(Tool instance, House house) {
        instance.house = house;
    }

    public static void injectPhone(Tool instance, Phone phone) {
        instance.phone = phone;
    }

    public static void injectCar(Tool instance, Car car) {
        instance.car = car;
    }

    public static void injectBook(Tool instance, Book book) {
        instance.book = book;
    }

}
