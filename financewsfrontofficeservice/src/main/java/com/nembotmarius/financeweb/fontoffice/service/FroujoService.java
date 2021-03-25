package com.nembotmarius.financeweb.fontoffice.service;

import com.nembotmarius.financeweb.fontoffice.entity.FroujoEntity;
import com.nembotmarius.financeweb.fontoffice.entity.PacpteEntity;
import com.nembotmarius.financeweb.fontoffice.repository.PacpteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Collection;

public interface FroujoService {
    Collection<FroujoEntity> getAllOpenDay(
            String user,
            String token,
            String oudajr,
            String oustat,
            String oustat2
    );
}
