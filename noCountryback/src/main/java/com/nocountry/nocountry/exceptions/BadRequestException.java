package com.nocountry.nocountry.exceptions;

public class BadRequestException extends RuntimeException{
    private final Integer statusCode = 400;

    public BadRequestException(String message) {
        super(message);
    }
}
