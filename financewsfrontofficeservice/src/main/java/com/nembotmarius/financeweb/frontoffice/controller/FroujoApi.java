package com.nembotmarius.financeweb.frontoffice.controller;

import com.nembotmarius.financeweb.frontoffice.entity.FroujoEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Collection;

@Api(value = "Collecte Journaliere", tags = "Api - Collecte Journaliere")
//@RequestMapping("financewsfrontoffice")
public interface FroujoApi {
    //Journée collecte ouvertes du jour
    @PostMapping(path="/getallopenday/{oudajr}/{oustat}/{oustat2}")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Les journées collectes de la journée"),
            @ApiResponse(code=400, message="Echec de recuperation des journées collectes"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Recherche les journées collectes ouvertes",
            notes = "Cette opération va rechercher les journées ouvertes au niveau de la bd"
    )
    ResponseEntity<Collection<FroujoEntity>> getAllOpenDay(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @PathVariable("oudajr") String oudajr,
            @PathVariable("oustat") String oustat,
            @PathVariable("oustat2") String oustat2
    );
}
