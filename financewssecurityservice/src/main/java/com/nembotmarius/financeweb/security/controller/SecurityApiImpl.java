package com.nembotmarius.financeweb.security.controller;

import com.nembotmarius.financeweb.security.entity.FroujoEntity;
import com.nembotmarius.financeweb.security.model.Froujo;
import com.nembotmarius.financeweb.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SecurityApiImpl implements SecurityApi {

    private final SecurityService securityservice;

    @Override
    public String testStatus() {
        return "Cette Api fonctionne bien";
    }

    @Override
    public ResponseEntity<String> authentifier(String user, String token) {
        //Authentifie l'utilisateur et retourne un token
        return new ResponseEntity<>(securityservice.authentifier(user, token), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Froujo> authentifiercode(String user, String token, String code) {
        //Authentifie l'utilisateur et retourne un token
        return new ResponseEntity<>(securityservice.authentifiercode(user, token, code), HttpStatus.OK);
    }
}
