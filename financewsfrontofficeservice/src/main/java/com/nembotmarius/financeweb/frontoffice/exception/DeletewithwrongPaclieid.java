package com.nembotmarius.financeweb.frontoffice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DeletewithwrongPaclieid extends RuntimeException{
    public DeletewithwrongPaclieid(String message){
        super(message);
    }
}
