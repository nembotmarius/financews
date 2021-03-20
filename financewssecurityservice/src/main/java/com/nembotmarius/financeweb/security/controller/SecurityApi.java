package com.nembotmarius.financeweb.security.controller;

import com.nembotmarius.financeweb.security.entity.FroujoEntity;
import com.nembotmarius.financeweb.security.model.Froujo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Security Backend", tags = "Api - Security")
//@RequestMapping("financewssecurity")
public interface SecurityApi {
    //Tester si l'api fonctionne
    @GetMapping(path="/status")
    public String testStatus();

    //Demande de d'authentification
    @PostMapping(path="/auth")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="La connection est acceptée"),
            @ApiResponse(code=400, message="Compte inexistant"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Authentifier l'utilisateur",
            notes = "Cette opération va verifier que l'utilisateur existe dans la base de données et verifier son authentification." +
                    "Si oui créer un token pour le permettre de travailler"
    )
    public ResponseEntity<String> authentifier(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token
    );

    //Demande de d'authentification avec verification du code du jour
    @PostMapping(path="/auth2")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="La connection est acceptée"),
            @ApiResponse(code=400, message="Compte inexistant"),
            @ApiResponse(code=500, message="Echec Server"),
            @ApiResponse(code=401, message="Echec d'authentification")
    })
    @ApiOperation(
            value = "Authentifier l'utilisateur",
            notes = "Cette opération va verifier que l'utilisateur existe dans la base de données et verifier son authentification." +
                    "Si oui créer un token pour le permettre de travailler"
    )
    public ResponseEntity<Froujo> authentifiercode(
            @RequestHeader("user") String user,
            @RequestHeader("token") String token,
            @RequestHeader("code") String code
    );
}
