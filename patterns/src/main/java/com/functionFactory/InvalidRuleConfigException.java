package com.functionFactory;

public class InvalidRuleConfigException extends Throwable {
    private String string;

    public InvalidRuleConfigException(String string) {
        this.string = string;
    }
}
