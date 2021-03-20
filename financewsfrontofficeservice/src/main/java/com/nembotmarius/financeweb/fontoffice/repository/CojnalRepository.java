package com.nembotmarius.financeweb.fontoffice.repository;

import com.nembotmarius.financeweb.fontoffice.entity.CojnalEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface CojnalRepository extends CrudRepository<CojnalEntity, Long> {

    @Query(value = "SELECT * FROM para.cojnal u WHERE u.jnauto = :jnauto", nativeQuery = true)
    CojnalEntity findCojnalById(long jnauto);

    @Query(value = "select comp.cojnal_func(:jnauto,:stauto,:joauto,:jndamv,:jndasa,:jndava,:jnmoti,:jnstat,:jnsrct,:jnsrca,:detail,:sessid,:option)", nativeQuery = true)
    long findSoldeCompte(
            long jnauto,
            int stauto,
            int joauto,
            long jndamv,
            long jndasa,
            long jndava,
            String jnmoti,
            int jnstat,
            String jnsrct,
            int jnsrca,
            String details,
            String sessid,
            int option
    );
}
