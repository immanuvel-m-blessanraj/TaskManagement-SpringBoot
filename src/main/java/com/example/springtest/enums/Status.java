package com.example.springtest.enums;

public enum Status {
    PENDING("P"), IN_PROGRESS("I"), DONE("D");

    private String code;

    private Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
