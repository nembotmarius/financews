package com.nembotmarius.financeweb.frontoffice.repository;

import com.nembotmarius.financeweb.frontoffice.entity.CojnalEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface CojnalRepository extends CrudRepository<CojnalEntity, Long> {

    @Query(value = "SELECT * FROM comp.cojnal u WHERE u.jnauto = :jnauto", nativeQuery = true)
    CojnalEntity findCojnalById(long jnauto);

    @Query(value = "SELECT * FROM comp.cojnal u WHERE u.stauto = :stauto and (u.jndamv >= :jndamv1 and u.jndamv <= :jndamv2) limit :nbrows offset :page ;", nativeQuery = true)
    Collection<CojnalEntity> findCojnalByPeriode(long stauto, long jndamv1, long jndamv2, int nbrows, int page);
}
