package com.nembotmarius.financeweb.clients.repository;

import com.nembotmarius.financeweb.clients.entity.AntranEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface AntranRepository extends CrudRepository<AntranEntity, Long> {

    @Query(value = "SELECT * FROM andr.antran u WHERE u.anauto = :anauto", nativeQuery = true)
    AntranEntity findAntranByid(long anauto);

    @Query(value = "SELECT * FROM andr.antran u WHERE u.anauto = :anauto and anstat = 10", nativeQuery = true)
    AntranEntity findAntranByidstat10(long anauto);


    @Query(value = "SELECT * FROM andr.antran u WHERE u.ouauto = :ouauto", nativeQuery = true)
    Collection<AntranEntity> findAntranByDay(long ouauto);

    @Query(value = "SELECT * FROM andr.antran u WHERE u.anpiec = :anpiec and u.ouauto = :ouauto", nativeQuery = true)
    AntranEntity findAntranByanpiec(String anpiec, long ouauto);
}
