package com.test.corebanking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception{

    public CustomerNotFoundException(String errorMessage){
        super(errorMessage);
    }

}
