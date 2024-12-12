package com.xxh.learn.java.daggertest.test2.auto;


import com.xxh.learn.java.daggertest.test2.Software;
import com.xxh.learn.java.daggertest.test2.SoftwareComponent;
import com.xxh.learn.java.daggertest.test2.SoftwareModel;

public class DSoftwareComponent {

    private DSoftwareComponent() {
    }

    public static Builder builder(){
        return  new Builder();
    }

    public static SoftwareComponent create(){
        return new Builder().build();
    }


    private static final class Builder {

        private SoftwareModel softwareModel;

        private Builder() {
        }

        private void softwareModel(SoftwareModel softwareModel) {
            this.softwareModel = softwareModel;
        }

        private SoftwareComponent build() {
            if (softwareModel != null) {
                softwareModel = new SoftwareModel();
            }
            return new SoftwareComponentImp(softwareModel);
        }


    }

    private static final class SoftwareComponentImp implements SoftwareComponent {

        private final SoftwareModel softwareModel;

        private SoftwareComponentImp(SoftwareModel softwareModel) {
            this.softwareModel = softwareModel;
        }

        private static Software getSoftware(SoftwareModel softwareModel) {
            return softwareModel.provideSoftware();
        }

        @Override
        public Software software() {
            return getSoftware(softwareModel);
        }
    }
}
