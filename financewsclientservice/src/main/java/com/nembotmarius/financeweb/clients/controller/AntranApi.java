package com.nembotmarius.financeweb.clients.controller;

import com.nembotmarius.financeweb.clients.entity.AntranEntity;
import com.nembotmarius.financeweb.clients.entity.PaclieEntity;
import com.nembotmarius.financeweb.clients.model.Collecte;
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

@Api(value = "Collecte Backend", tags = "Api - Collecte")
//@RequestMapping("financewsclient")
public interface AntranApi {

    //Créer un nouveau client
    @PostMapping(path="/insertcollecte")
    @ApiResponses(value = {
            @ApiResponse(code=201, message="La collecte a été bien crée"),
            @ApiResponse(code=400, message="Echec de création"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Créer une nouvelle collecte",
            notes = "Cette opération va créer une nouvelle collecte dans la base de données"
    )
    public ResponseEntity<AntranEntity> insertAntran(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @Validated @NonNull @RequestBody Collecte collecte
    );

    //Suppression collecte
    @DeleteMapping(path="/deletecollecte/{antranid}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="La collecte a été bien supprimer"),
            @ApiResponse(code=400, message="Echec de suppression"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Delete une nouvelle collecte",
            notes = "Cette opération va supprimer une nouvelle collecte dans la base de données"
    )
    public ResponseEntity<AntranEntity> deleteAntran(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @Validated @NonNull @RequestBody AntranEntity collecte,
            @NonNull @PathVariable("antranid") String antranid
    );



    //update collecte
    @PutMapping(path="/updatecollecte/{antranid}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="La collecte a été bien modifier"),
            @ApiResponse(code=400, message="Echec de modification"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Modification une nouvelle collecte",
            notes = "Cette opération va modifier une nouvelle collecte dans la base de données"
    )
    public ResponseEntity<AntranEntity> UpdateAntran(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @Validated @NonNull @RequestBody AntranEntity collecte,
            @NonNull @PathVariable("antranid") String antranid
    );


    //Get Customer by Id
    @PostMapping(path="/getantranbyid/{antranid}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="La collecte a été recupéré dans la BD"),
            @ApiResponse(code=400, message="Echec de recuperation de la collecte"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Recherche de la collecte a partir de son Id",
            notes = "Cette opération va rechercher un client dans la BD a partir de son ID"
    )
    public ResponseEntity<AntranEntity> getAntranbyid(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @NonNull @PathVariable("antranid") String antranid
    );


    //Get All Collecte jornaliere
    @PostMapping(path="/getallcollectebyday/{ouauto}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Les collectes de la journée ont été recupérées avec succès"),
            @ApiResponse(code=400, message="Echec de recuperation des collectes de la BD"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Recupère les collectes journalière pour une tournée donnée de la BD",
            notes = "Cette opération va recupèrer les collectes journalière pour une tournée donnée de la BD"
    )
    public ResponseEntity<Collection<AntranEntity>> getAllCollecteByDay(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @NonNull @PathVariable("ouauto") String ouauto
    );
}
