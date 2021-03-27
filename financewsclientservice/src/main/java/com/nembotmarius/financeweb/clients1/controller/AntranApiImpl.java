package com.nembotmarius.financeweb.clients1.controller;

import com.nembotmarius.financeweb.clients1.entity.AntranEntity;
import com.nembotmarius.financeweb.clients1.model.Collecte;
import com.nembotmarius.financeweb.clients1.service.AntranServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequiredArgsConstructor
public class AntranApiImpl implements AntranApi {

    private final AntranServiceImpl antranservice;


    @Override
    public ResponseEntity<AntranEntity> insertAntran(String user, String token, Collecte collecte) {
        return new ResponseEntity<>(antranservice.insertAntran(user, token, collecte), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AntranEntity> deleteAntran(String user, String token, AntranEntity collecte, String antranid) {
        return new ResponseEntity<>(antranservice.deleteAntran(user, token, collecte, antranid), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AntranEntity> UpdateAntran(String user, String token, AntranEntity collecte, String antranid) {
        return new ResponseEntity<>(antranservice.updateAntran(user, token, collecte, antranid), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AntranEntity> getAntranbyid(String user, String token, String antranid) {
        return new ResponseEntity<>(antranservice.getAntranbyid(user, token, antranid), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<AntranEntity>> getAllCollecteByDay(String user, String token, String ouauto) {
        return new ResponseEntity<>(antranservice.getAllCollecteByDay(user, token, ouauto), HttpStatus.OK);
    }
}
