package com.nembotmarius.financeweb.security.repository;

import com.nembotmarius.financeweb.security.entity.FroujoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface FroujoRepository extends CrudRepository<FroujoEntity, Long> {


    @Query(value = "SELECT * FROM frof.froujo u WHERE u.oucode = :oucode and u.usauto = :usauto", nativeQuery = true)
    FroujoEntity findFroujoByoucode(int oucode, long usauto);
}
