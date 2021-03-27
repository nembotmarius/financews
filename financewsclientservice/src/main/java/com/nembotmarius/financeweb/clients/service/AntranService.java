package com.nembotmarius.financeweb.clients.service;

import com.nembotmarius.financeweb.clients.entity.AntranEntity;
import com.nembotmarius.financeweb.clients.model.Collecte;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;

public interface AntranService {
    public AntranEntity insertAntran(
            @NonNull String user,
            @NonNull String token,
            @Validated @NonNull Collecte collecte
    );

    public AntranEntity deleteAntran(
            @NonNull String user,
            @NonNull String token,
            @Validated @NonNull AntranEntity collecte,
            @NonNull String id
    );

    public AntranEntity updateAntran(
            @NonNull String user,
            @NonNull String token,
            @Validated @NonNull AntranEntity collecte,
            @NonNull String id
    );


    public AntranEntity getAntranbyid(
            @NonNull String user,
            @NonNull String token,
            @NonNull String antranid
    );


    public Collection<AntranEntity> getAllCollecteByDay(
            @NonNull String user,
            @NonNull String token,
            @NonNull String ouauto
    );
}
