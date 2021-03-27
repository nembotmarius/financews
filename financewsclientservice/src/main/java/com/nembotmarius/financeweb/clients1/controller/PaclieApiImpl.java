package com.nembotmarius.financeweb.clients1.controller;

import com.nembotmarius.financeweb.clients1.entity.PaclieEntity;
import com.nembotmarius.financeweb.clients1.repository.PaclieRepository;
import com.nembotmarius.financeweb.clients1.service.PaclieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class PaclieApiImpl implements PaclieApi {

    private final PaclieServiceImpl paclieservice;

    @Override
    public String testStatus() {
        return "Clients Back End Fonctionne correctement";
    }

    @Override
    public ResponseEntity<PaclieEntity> insertPaclie(String user, String token, PaclieEntity paclieentity) {
        //Si la création a été bien faite, alors
        //donne un customer en retour
        return new ResponseEntity<>(paclieservice.insertPaclie(user, token, paclieentity), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PaclieEntity> updatePaclie(String user, String token, String paclieid, PaclieEntity paclieentity) {
        return new ResponseEntity<>(paclieservice.updatePaclie(user, token, paclieid, paclieentity), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PaclieEntity> deletePaclie(String user, String token, String paclieid) {
        return new ResponseEntity<>(paclieservice.deletePaclie(user, token, paclieid), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PaclieEntity> getPacliebyid(String user, String token, String paclieid) {
        //recherche le client par son id et retourne le resultat
        return new ResponseEntity<>(paclieservice.getPaclieById(user, token, paclieid), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<PaclieEntity>> getAllPaclie(String user, String token) {
        //recupere tous les clients1 de la base et retourne le resultat
        return new ResponseEntity<>(paclieservice.getAllPaclies(user, token), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PaclieRepository.Compte>> getAllCollecteCompte(String user, String token, String stauto) {
        //recupere tous les clients1 de la base et retourne le resultat
        return new ResponseEntity<>(paclieservice.getAllCollecteCompte(user, token, stauto), HttpStatus.OK);
    }
}
