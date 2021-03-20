package com.nembotmarius.financeweb.fontoffice.repository;

import com.nembotmarius.financeweb.fontoffice.entity.ScsessEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ScsessRepository extends CrudRepository<ScsessEntity, Long> {

    @Query(value = "SELECT * FROM secu.scsess u WHERE u.ssidse = :ssidse", nativeQuery = true)
    ScsessEntity findScsessBySsidese(String ssidse);
}
