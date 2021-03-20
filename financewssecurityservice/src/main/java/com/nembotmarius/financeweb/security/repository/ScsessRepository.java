package com.nembotmarius.financeweb.security.repository;

import com.nembotmarius.financeweb.security.entity.ScsessEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface ScsessRepository extends CrudRepository<ScsessEntity, Long> {
    @Query(value = "SELECT * FROM secu.scsess u WHERE u.ssidse = :ssidse", nativeQuery = true)
    ScsessEntity findScsessBySsidese(String ssidse);

    @Query(value = "SELECT * FROM secu.scsess u WHERE u.usauto=:usauto", nativeQuery = true)
    Collection<ScsessEntity> findAllUserActiveSession(long usauto);
}
