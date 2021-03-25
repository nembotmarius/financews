package com.nembotmarius.financeweb.fontoffice.controller;

import com.nembotmarius.financeweb.fontoffice.entity.FroujoEntity;
import com.nembotmarius.financeweb.fontoffice.service.FroujoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class FroujoApiImpl implements FroujoApi{

    private final FroujoService froujoservice;

    @Override
    public ResponseEntity<Collection<FroujoEntity>> getAllOpenDay(
            @NonNull String user,
            @NonNull String token,
            @NonNull String oudajr,
            @NonNull String oustat,
            @NonNull String oustat2)
    {
        return new ResponseEntity<>(froujoservice.getAllOpenDay(user, token, oudajr, oustat, oustat2), HttpStatus.OK);
    }
}
