package com.nembotmarius.financeweb.frontoffice.service;

import com.nembotmarius.financeweb.frontoffice.entity.FroujoEntity;
import com.nembotmarius.financeweb.frontoffice.repository.FroujoRepository;

import java.util.Collection;

public interface FroujoService {
    Collection<FroujoRepository.JourneeCol> getAllOpenDay(
            String user,
            String token,
            String stauto,
            String oudajr,
            String oustat,
            String oustat2
    );
}
