package com.restaurante.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public ApiException(String message, Throwable throwable, HttpStatus httpStatus){
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;

        System.out.println("foi");
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

}