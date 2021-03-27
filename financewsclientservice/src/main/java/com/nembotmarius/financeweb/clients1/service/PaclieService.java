package com.nembotmarius.financeweb.clients1.service;

import com.nembotmarius.financeweb.clients1.entity.PaclieEntity;
import com.nembotmarius.financeweb.clients1.repository.PaclieRepository;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.List;

public interface PaclieService {
    PaclieEntity insertPaclie(@NonNull String user, @NonNull String token, @Validated @NonNull PaclieEntity paclieentity);

    PaclieEntity updatePaclie(@NonNull String user, @NonNull String token, @NonNull String id, @Validated @NonNull PaclieEntity paclieentity);

    PaclieEntity deletePaclie(@NonNull String user, @NonNull String token, @NonNull String id);

    Collection<PaclieEntity> getAllPaclies(@NonNull String user, @NonNull String token);

    PaclieEntity getPaclieById(@NonNull String user, @NonNull String token, @NonNull String clauto);

    boolean checkAuthentification(@NonNull String user, @NonNull String token);

    List<PaclieRepository.Compte> getAllCollecteCompte(@NonNull String user, @NonNull String token, @NonNull String stauto);
}
