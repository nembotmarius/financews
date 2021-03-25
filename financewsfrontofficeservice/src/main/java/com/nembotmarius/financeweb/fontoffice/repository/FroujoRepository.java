package com.nembotmarius.financeweb.fontoffice.repository;

import com.nembotmarius.financeweb.fontoffice.entity.FroujoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface FroujoRepository extends CrudRepository<FroujoEntity, Long> {

    @Query(value = "select * from frof.froujo f where oudajr = :oudajr and oustat in (:oustat,:oustat2) and oudele=0 order by ouauto desc;", nativeQuery = true)
    Collection<FroujoEntity> findAllOpenday(long oudajr, int oustat, int oustat2);
}
