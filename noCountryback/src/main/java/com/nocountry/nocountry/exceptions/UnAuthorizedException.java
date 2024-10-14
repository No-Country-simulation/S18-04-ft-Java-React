package com.nocountry.nocountry.exceptions;

public class UnAuthorizedException extends RuntimeException {
    private final Integer statusCode = 401;

    public UnAuthorizedException(String message) {
        super(message);
    }
}
