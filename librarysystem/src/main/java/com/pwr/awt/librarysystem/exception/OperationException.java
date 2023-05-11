package com.pwr.awt.librarysystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OperationException extends ErrorResponse{
    public OperationException() {
        super("Operation failed");
    }

    public OperationException(String message) {
        super(message);
    }
}
