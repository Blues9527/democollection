package com.example.hyfdemo;

/**
 * User : Blues
 * Date : 2019/5/24
 * Time : 09:54
 */

public class Test {

    private String arg1, arg2;

    private Test(Builder builder) {
        this.arg1 = builder.arg1;
        this.arg2 = builder.arg2;
    }

    public String arg1() {
        return arg1;
    }

    public String arg2() {
        return arg2;
    }

    public static class Builder {
        String arg1, arg2;

        public Builder params1(String arg1) {
            this.arg1 = arg1;
            return this;
        }

        public Builder params2(String arg2) {
            this.arg2 = arg2;
            return this;
        }

        public Test build() {
            return new Test(this);
        }

    }

    @Override
    public String toString() {
        return "args1: " + this.arg1 + " arg2: " + this.arg2;
    }
}
