package com.nembotmarius.financeweb.fontoffice.controller;

import com.nembotmarius.financeweb.fontoffice.entity.PacpteEntity;
import com.nembotmarius.financeweb.fontoffice.repository.PacpteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Collection;

@Api(value = "Collecte Backend", tags = "Api - Collecte")
//@RequestMapping("financewsfrontoffice")
public interface PacpteApi {
    //Get solde by Id
    @PostMapping(path="/getsoldebyid/{cpauto}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Le solde a été recupéré dans la BD"),
            @ApiResponse(code=400, message="Echec de recuperation du solde"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Recherche du solde a partir de son Id",
            notes = "Cette opération va rechercher le solde du client dans la BD a partir de son ID Compte"
    )
    public ResponseEntity<PacpteRepository.SoldeCompte> getSoldebyid(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @NonNull @PathVariable("cpauto") String cpauto
    );

    //Get compte by clez
    @PostMapping(path="/getpacptebyclez/{clclez}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Les comptes du clients ont été recupérés dans la BD"),
            @ApiResponse(code=400, message="Echec de recuperation des compte"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Recherche des comptes du clients a partir de sa clez",
            notes = "Cette opération va rechercher les comptes du clients a partir de sa clez dans la BD a partir de son ID Compte"
    )
    public ResponseEntity<Collection<PacpteEntity>> getComptebyclez(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @NonNull @PathVariable("clclez") String clclez
    );

}
