package com.nembotmarius.financeweb.frontoffice.controller;

import com.nembotmarius.financeweb.frontoffice.model.Cojnal;
import com.nembotmarius.financeweb.frontoffice.service.CojnalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CojnalApiImpl implements CojnalApi{
    private final CojnalService cojnalservice;

    @Override
    public ResponseEntity<Cojnal> getJnalbyId(String user, String token, String jnauto) {
        return new ResponseEntity<>(cojnalservice.getJnalbyId(user, token, jnauto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Cojnal>> getJnalPeriode(String user, String token, String stauto, String debut, String fin, String nbrows, String page) {
        return new ResponseEntity<>(cojnalservice.getJnalPeriode(user, token, stauto, debut, fin, nbrows, page), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Cojnal> AddJnalCpte(String user, String token, Cojnal cojnal, String option) {
        return new ResponseEntity<>(cojnalservice.AddJnalCpte(user, token, cojnal, option), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Cojnal> SaveJnalCpte(String user, String token, Cojnal cojnal) {
        return null;
    }
}
