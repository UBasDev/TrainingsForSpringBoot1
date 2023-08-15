package org.group1.exceptionHandlers;

import org.group1.exceptions.CustomUserException;
import org.group1.models.CustomErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomUserException.class)
    public ResponseEntity<CustomErrorResponse> handleCommonUserException(CustomUserException ex) {
        var errorResponse = new CustomErrorResponse(
                ex.getHttpStatus().value(),
                ex.getHttpStatus().getReasonPhrase(),
                ex.getMessage(),
                Instant.now()
        );

        return ResponseEntity.status(ex.getHttpStatus()).body(errorResponse);
    }
}
