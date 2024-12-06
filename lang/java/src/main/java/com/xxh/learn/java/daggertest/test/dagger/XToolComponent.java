package com.xxh.learn.java.daggertest.test.dagger;

import com.xxh.learn.java.daggertest.test.Book;
import com.xxh.learn.java.daggertest.test.Car;
import com.xxh.learn.java.daggertest.test.Phone;
import com.xxh.learn.java.daggertest.test.Tool;
import com.xxh.learn.java.daggertest.test.ToolComponent;
import com.xxh.learn.java.daggertest.test.ToolModel;

/**
 * 不允许外部构建，通过静态方法使用
 * 提供ToolComponent对象，不暴露ToolComponent的接口方法和实现。
 */
public class XToolComponent {

    //不允许外部构建
    private XToolComponent(){

    }

    /**
     * 用于设置Model相关类，一般是用于构建有参构造方法
     * @return
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * 定义为静态方法，直接获取，不用去构建对象再获取
     * 获取依赖容器对象
     */
    public static ToolComponent create() {
        return new Builder().build();
    }

    //建造者模式，通过Builder构建ToolComponent。
    private static final class Builder {
        private ToolModel model;

        //不允许外部构建该类，通过外部builder()方法获取
        private Builder() {
        }

        /*public void toolModel(ToolModel model) {
            this.model = model;
        }*/

        //返回类型使用Builder，由于链式调用
        public Builder toolModel(ToolModel model) {
            this.model = model;
            return this;
        }

        public ToolComponent build() {
            if (model == null) {
                model = new ToolModel();
            }
            return new ToolComponentImp(model);
        }

    }


    /**
     * 什么定义内部类实现ToolComponent，而不是直接定义实现类
     *
     * 没有定义获取对象静态方法，该对象只在本类中使用，不对外暴露
     */
    private static final class ToolComponentImp implements ToolComponent {

        //final修饰，必须构造方法赋值
        private final ToolModel model;

        //不允许外部构建该类
        private ToolComponentImp(ToolModel model) {
            this.model = model;
        }


        @Override
        public void inject(Tool tool) {
            injectTool2(tool);
        }

        @Override
        public Car car() {
            return ToolModelCarFactory.providerCar(model,ToolModelEngineFactory.providerEngine(model));
        }


        /*private void injectTool(Tool tool) {
            Tool_MembersInjector.create(
                    new Book_Factory(),
                    new ToolModelCarFactory(model),
                    new ToolModelHouseFactory(model),
                    new Phone_Factory1()
            ).injectMembers(tool);
        }*/

        //返回类型定义为Tool，方便使用
        private Tool injectTool(Tool tool) {
            ToolMembersInjector.create(
                    new BookFactory(),
                    new ToolModelCarFactory(model,new ToolModelEngineFactory(model)),
                    new ToolModelHouseFactory(model),
                    new PhoneFactory()
            ).injectMembers(tool);
            return tool;
        }

        //逻辑简单，直接使用静态方法
        private Tool injectTool2(Tool instance) {
            ToolMembersInjector.injectHouse(instance, ToolModelHouseFactory.providerHouse(model));
            ToolMembersInjector.injectPhone(instance, new Phone());
            ToolMembersInjector.injectCar(instance, car());
            ToolMembersInjector.injectBook(instance, new Book());
            return instance;
        }
    }


}
