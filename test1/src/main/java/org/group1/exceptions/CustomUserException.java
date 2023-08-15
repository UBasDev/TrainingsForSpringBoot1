package org.group1.exceptions;

import org.springframework.http.HttpStatus;

public class CustomUserException extends RuntimeException {
    private final String errorText;
    private final HttpStatus httpStatus;

    public CustomUserException(String errorText, HttpStatus httpStatus) {
        super(errorText);
        this.errorText = errorText;
        this.httpStatus = httpStatus;
    }

    public String getErrorText() {
        return this.errorText;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}

