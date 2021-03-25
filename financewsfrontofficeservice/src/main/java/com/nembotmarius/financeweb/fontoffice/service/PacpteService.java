package com.nembotmarius.financeweb.fontoffice.service;

import com.nembotmarius.financeweb.fontoffice.entity.PacpteEntity;
import com.nembotmarius.financeweb.fontoffice.model.Pacpte;
import com.nembotmarius.financeweb.fontoffice.repository.PacpteRepository;

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
