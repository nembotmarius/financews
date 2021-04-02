package com.nembotmarius.financeweb.frontoffice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class SoldeNotAvailable extends RuntimeException{
    public SoldeNotAvailable(String message){
        super(message);
    }
}
