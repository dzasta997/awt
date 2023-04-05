package com.pwr.awt.librarysystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends ErrorResponse{
    public NotFoundException(){
        super("Requested value does not exist");
    }
    public NotFoundException(String message){
        super(message);
    }
}
