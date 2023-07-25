package com.test.corebanking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NegativeInitialCreditException extends Exception{

    public NegativeInitialCreditException(String message){
        super(message);
    }
}
