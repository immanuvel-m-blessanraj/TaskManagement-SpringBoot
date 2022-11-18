package com.example.springtest.exceptions;

public class StatusDoesNotExist extends RuntimeException{

    public StatusDoesNotExist(String message) {
        super(message);
    }
}
