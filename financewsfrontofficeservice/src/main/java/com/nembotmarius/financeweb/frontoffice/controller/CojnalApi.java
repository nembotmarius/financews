package com.nembotmarius.financeweb.frontoffice.controller;

import com.nembotmarius.financeweb.frontoffice.model.Cojnal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(value = "Collecte Journaliere", tags = "Api - Collecte Journaliere")
//@RequestMapping("financewsfrontoffice")
public interface CojnalApi {
    //Recuperer une ecriture dans le journal comptable
    @PostMapping(path="/getJnalbyid/{jnauto}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Retourne une ecriture complete du journal"),
            @ApiResponse(code=400, message="Echec de recuperation ecriture complete du journal"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Recherche une ecriture complete du journal",
            notes = "Cette opération va rechercher une ecriture complete du journal"
    )
    ResponseEntity<Cojnal> getJnalbyId(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @PathVariable("jnauto") String jnauto
    );

    //Liste des ecritures comptables pour une periode données
    @PostMapping(path="/getJnalbyperiode/{stauto}/{debut}/{fin}/{nbrows}/{page}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Retourne la liste des ecritures pour une periode données"),
            @ApiResponse(code=400, message="Echec de recuperation des ecritures comptables"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Liste des ecritures comptables pour une periode données",
            notes = "Cette opération va rechercher la liste des ecritures comptables pour une periode données"
    )
    ResponseEntity<List<Cojnal>> getJnalPeriode(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @PathVariable("stauto") String stauto,
            @PathVariable("debut") String debut,
            @PathVariable("fin") String fin,
            @PathVariable("nbrows") String nbrows,
            @PathVariable("page") String page
    );

    //Enregistre les ecritures comptables
    @PostMapping(path="/addjnalcpte/{option}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ajoute une ecriture comptable dans la bd"),
            @ApiResponse(code=400, message="Echec d'ajout"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Ajoute une ecriture comptable dans la bd",
            notes = "Cette opération va Ajouter une ecriture comptable dans la bd"
    )
    ResponseEntity<Cojnal> AddJnalCpte(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @Validated @NonNull @RequestBody Cojnal cojnal,
            @PathVariable("option") String option
    );

    //  addbatchjnalcpte  Enregistre les ecritures comptables en batch
    // ----------------------------------------------------------------
    @PostMapping(path="/addbatchjnalcpte/{option}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ajoute une ecriture comptable dans la bd"),
            @ApiResponse(code=400, message="Echec d'ajout"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Ajoute des ecritures comptable dans la bd",
            notes = "Cette opération va Ajouter des ecritures comptables dans la bd"
    )
    ResponseEntity<List<Cojnal>> AddBatchJnalCpte(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @Validated @NonNull @RequestBody List<Cojnal> listcojnal,
            @PathVariable("option") String option
    );
    // -----------------------------------------------------------------------------------
    // --- fin addbatchjnalcpte ----------------------------------------------------------


    //mise à jour des ecritures comptables
    @PutMapping(path="/savejnalcpte")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="sauvegarde une ecriture comptable dans la bd"),
            @ApiResponse(code=400, message="Echec de mise à jour"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "met à jour une ecriture comptable dans la bd",
            notes = "Cette opération va mettre à jour une ecriture comptable dans la bd"
    )
    ResponseEntity<Cojnal> SaveJnalCpte(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @Validated @NonNull @RequestBody Cojnal cojnal
    );
}
