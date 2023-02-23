package com.resellerapp.model.enums;

public enum ConditionEnums {

    EXCELLENT("Excellent"),
    GOOD("Good"),
    ACCEPTABLE("Acceptable");

    private final String value;

    ConditionEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
