package com.cloudap1delivery.cloudap1delivery.ErrorHandler;


public class Validation {

    private String field;

    public String message;

    public Validation(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }

}
