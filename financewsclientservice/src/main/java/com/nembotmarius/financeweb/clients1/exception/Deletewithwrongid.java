package com.nembotmarius.financeweb.clients1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Deletewithwrongid extends RuntimeException{
    public Deletewithwrongid(String message){
        super(message);
    }
}
