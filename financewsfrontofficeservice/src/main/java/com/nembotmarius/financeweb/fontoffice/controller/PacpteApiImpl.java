package com.nembotmarius.financeweb.fontoffice.controller;

import com.nembotmarius.financeweb.fontoffice.entity.PacpteEntity;
import com.nembotmarius.financeweb.fontoffice.repository.PacpteRepository;
import com.nembotmarius.financeweb.fontoffice.service.PacpteServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequiredArgsConstructor
public class PacpteApiImpl implements PacpteApi{

    private final PacpteServiceImpl pacpteservice;

    @Override
    public ResponseEntity<PacpteRepository.SoldeCompte> getSoldebyid(
            @NonNull String user,
            @NonNull String token,
            @NonNull String cpauto
    ) {
        return new ResponseEntity<>(pacpteservice.getSoldebyid(user, token, cpauto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<PacpteEntity>> getComptebyclez(
            @NonNull String user,
            @NonNull String token,
            @NonNull String clclez
    ) {
        return new ResponseEntity<>(pacpteservice.getComptebyclez(user, token, clclez), HttpStatus.OK);
    }
}
