package com.nembotmarius.financeweb.fontoffice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UpdatewithwrongPaclieid extends RuntimeException{
    public UpdatewithwrongPaclieid(String message){
        super(message);
    }
}
