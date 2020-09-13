package com.builder;

// 在下面的 ConstructorArg 类中，
// 当 isRef 为 true 的时候，arg 表示 String 类型的 refBeanId，type 不需要设置；
// 当 isRef 为 false 的时候，arg、type 都需要设置。
// 请根据这个需求，完善 ConstructorArg 类。
public class ConstructorArg {
    private boolean isRef;
    private Class type;
    private Object arg;

    private ConstructorArg(Builder builder) {
        this.isRef = builder.isRef;
        this.type = builder.type;
        this.arg = builder.arg;

    }

    public static class Builder{
        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArg builder(){
            // 在这里做一些参数的限制
            // 当 isRef 为 true 的时候，arg 表示 String 类型的 refBeanId，type 不需要设置；
            // 当 isRef 为 false 的时候，arg、type 都需要设置。
            if (isRef) {
                if (arg == null || !(arg instanceof String)) {
                    throw new IllegalArgumentException("arg 必须设置，且为String");
                }
            } else {
                if (arg == null || type == null) {
                    throw new IllegalArgumentException("arg、type 都需要设置");
                }
            }
            return new ConstructorArg(this);
        }

        public Builder setRef(boolean isRef) {
            this.isRef = isRef;
            return this;
        }

        public Builder setType(Class type) {
            this.type = type;
            return this;
        }

        public Builder setArg(Object arg) {
            this.arg = arg;
            return this;
        }
    }
}
