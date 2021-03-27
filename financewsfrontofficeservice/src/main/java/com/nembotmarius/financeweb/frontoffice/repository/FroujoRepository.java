package com.nembotmarius.financeweb.frontoffice.repository;

import com.nembotmarius.financeweb.frontoffice.entity.FroujoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface FroujoRepository extends CrudRepository<FroujoEntity, Long> {

    @Query(value = "select * from frof.froujo f where stauto = :stauto and oudajr = :oudajr and oustat in (:oustat,:oustat2) and oudele=0 order by ouauto desc;", nativeQuery = true)
    Collection<FroujoEntity> findAllOpenday(int stauto, long oudajr, int oustat, int oustat2);
}
