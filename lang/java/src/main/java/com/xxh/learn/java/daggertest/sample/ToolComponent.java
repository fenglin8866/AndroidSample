package com.xxh.learn.java.daggertest.sample;

import com.xxh.learn.java.daggertest.sample.sub.PeopleComponent;
import com.xxh.learn.java.daggertest.sample.sub2.ManComponent;
import com.xxh.learn.java.daggertest.sample.sub3.WomanComponent;
import com.xxh.learn.java.daggertest.sample.sub4.HumanComponent;

import dagger.Component;

/**
 * 1.只能是接口或抽象类
 * 2.inject(XXX)会自动注入所有的依赖对象
 */

@Component(dependencies = SoftwareComponent.class, modules = {ToolModel.class})
public interface ToolComponent {

    void inject(Tool tool);

    Car car();

    PeopleComponent peopleComponent();

    ManComponent.Builder manComponentBuilder();

    WomanComponent.Factory womanComponentFactory();

    HumanComponent.Builder HumanComponentBuilder();
}
