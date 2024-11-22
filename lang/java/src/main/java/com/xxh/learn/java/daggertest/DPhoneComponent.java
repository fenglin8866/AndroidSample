package com.xxh.learn.java.daggertest;

public class DPhoneComponent {
    private DPhoneComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static PhoneComponent create() {
        return new Builder().build();
    }

    private static final class Builder {
        //private final Builder builder = this;

        private Builder() {

        }

        public PhoneComponentImp build() {
            return new PhoneComponentImp();
        }

    }

    private static final class PhoneComponentImp implements PhoneComponent {
        private final PhoneComponentImp imp = this;

        private PhoneComponentImp() {

        }

        @Override
        public void inject(Phone phone) {
            injectPhone(phone);
        }

        private Phone injectPhone(Phone instance) {
            Phone_MembersInjector.phoneInjectMembers(instance, new Cpu());
            return instance;
        }

    }

}
