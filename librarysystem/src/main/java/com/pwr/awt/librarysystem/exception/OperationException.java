package com.pwr.awt.librarysystem.exception;

public class OperationException extends ErrorResponse{
    public OperationException() {
        super("Operation failed");
    }

    public OperationException(String message) {
        super(message);
    }
}
