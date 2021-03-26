package com.nembotmarius.financeweb.frontoffice.service;

import com.nembotmarius.financeweb.frontoffice.entity.PacpteEntity;
import com.nembotmarius.financeweb.frontoffice.model.Pacpte;
import com.nembotmarius.financeweb.frontoffice.repository.PacpteRepository;

import java.util.Collection;

public interface PacpteService {
    PacpteRepository.SoldeCompte getSoldebyid(
            String user,
            String token,
            String cpauto
    );

    Pacpte getComptebyid(
            String user,
            String token,
            String cpauto
    );

    Collection<PacpteEntity> getComptebyclez(
            String user,
            String token,
            String clclez
    );

    Collection<PacpteEntity> getAllComptebyclez(
            String user,
            String token,
            String clclez
    );
}
