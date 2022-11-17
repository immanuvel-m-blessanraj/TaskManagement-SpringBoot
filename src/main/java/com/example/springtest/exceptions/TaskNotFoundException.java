package com.example.springtest.exceptions;

public class TaskNotFoundException extends RuntimeException{


    public TaskNotFoundException(String message) {
        super(message);
    }
}
