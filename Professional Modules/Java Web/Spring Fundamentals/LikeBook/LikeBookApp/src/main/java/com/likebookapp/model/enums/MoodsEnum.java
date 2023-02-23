package com.likebookapp.model.enums;

public enum MoodsEnum {

    HAPPY("Happy"),
    SAD("Sad"),
    INSPIRED("Inspired");

    private final String value;

    MoodsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
