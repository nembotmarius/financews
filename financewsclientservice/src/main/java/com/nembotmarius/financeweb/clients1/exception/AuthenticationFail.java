package com.nembotmarius.financeweb.clients1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthenticationFail extends RuntimeException{
    public AuthenticationFail(String message){
        super(message);
    }
}
