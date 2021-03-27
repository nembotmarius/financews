package com.nembotmarius.financeweb.clients.controller;

import com.nembotmarius.financeweb.clients.entity.PaclieEntity;
import com.nembotmarius.financeweb.clients.repository.PaclieRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Api(value = "Clients Backend", tags = "Api - Clients")
//@RequestMapping("financewsclient")
public interface PaclieApi {
    //Teste si le service fonctionne
    @PostMapping(path="/status")
    public String testStatus();

    //Créer un nouveau client
    @PostMapping(path="/insertpaclie")
    @ApiResponses(value = {
            @ApiResponse(code=201, message="Le client a été bien crée"),
            @ApiResponse(code=400, message="Echec de création"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Créer un nouveau client",
            notes = "Cette opération va créer un nouveau client dans la base de données"
    )
    public ResponseEntity<PaclieEntity> insertPaclie(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @Validated @NonNull @RequestBody PaclieEntity paclieentity
    );


    //Get Customer by Id
    @PostMapping(path="/getpacliebyid/{paclieid}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Le client a été recupéré dans la BD"),
            @ApiResponse(code=400, message="Echec de recuperation du client"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Recherche un client a partir de son Id",
            notes = "Cette opération va rechercher un client dans la BD a partir de son ID"
    )
    public ResponseEntity<PaclieEntity> getPacliebyid(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @NonNull @PathVariable("paclieid") String paclieid
    );

    //Update Customer by Id
    @PutMapping(path="/updatepaclie/{paclieid}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Le client a été mis à jour"),
            @ApiResponse(code=400, message="Echec de mise à jour"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Mets à jour un nouveau client",
            notes = "Cette opération va mettre à jour un client dans la base de données"
    )
    public ResponseEntity<PaclieEntity> updatePaclie(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @NonNull @PathVariable("paclieid") String paclieid,
            @Validated @NonNull @RequestBody PaclieEntity paclieentity
    );

    //Delete Customer by Id
    @DeleteMapping(path="/deletepaclie/{paclieid}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Le client a été bien supprimé"),
            @ApiResponse(code=400, message="Echec de suppression"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Supprime un client de la BD",
            notes = "Cette opération va supprimer un client dans la BD"
    )
    public ResponseEntity<PaclieEntity> deletePaclie(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @NonNull @PathVariable("paclieid") String paclieid
    );

    //Get All Customer
    @PostMapping(path="/getallpaclie")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Les clients ont été recupérés avec succès"),
            @ApiResponse(code=400, message="Echec de recuperation des clients de la BD"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Recupère tous les clients de la BD",
            notes = "Cette opération va recupèrer tous les clients dans la BD"
    )
    public ResponseEntity<Collection<PaclieEntity>> getAllPaclie(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token
    );

    //Get All Collecte Compte
    @PostMapping(path="/getallcollectecompte/{stauto}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Les clients ont été recupérés avec succès"),
            @ApiResponse(code=400, message="Echec de recuperation des clients de la BD"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Recupère tous les compte de la BD",
            notes = "Cette opération va recupèrer tous les clients dans la BD"
    )
    public ResponseEntity<List<PaclieRepository.Compte>> getAllCollecteCompte(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @NonNull @PathVariable("stauto") String stauto
    );
}
