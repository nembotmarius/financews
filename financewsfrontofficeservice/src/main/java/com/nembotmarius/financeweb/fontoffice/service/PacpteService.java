package com.nembotmarius.financeweb.fontoffice.service;

import com.nembotmarius.financeweb.fontoffice.entity.PacpteEntity;
import com.nembotmarius.financeweb.fontoffice.repository.PacpteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Collection;

public interface PacpteService {
    public PacpteRepository.SoldeCompte getSoldebyid(
            String user,
            String token,
            String cpauto
    );

    public Collection<PacpteEntity> getComptebyclez(
            String user,
            String token,
            String clclez
    );
}
