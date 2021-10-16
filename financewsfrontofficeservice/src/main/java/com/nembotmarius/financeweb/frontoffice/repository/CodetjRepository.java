package com.nembotmarius.financeweb.frontoffice.repository;

import com.nembotmarius.financeweb.frontoffice.entity.CodetjEntity;
import com.nembotmarius.financeweb.frontoffice.model.Codetj;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface CodetjRepository extends CrudRepository<CodetjEntity, Long> {

    @Query(value = "SELECT * FROM comp.codetj u WHERE u.djauto = :djauto", nativeQuery = true)
    CodetjEntity findCodetjById(long djauto);

    @Query(value = "SELECT * FROM comp.codetj u where jnauto = :jnauto ORDER BY djauto", nativeQuery = true)
    Collection<CodetjEntity> findAllCodetj(long jnauto);

    @Query(value = "select a.cpauto, a.cpinti, b.csauto, b.cscode, b.cstypc from para.pacpte a inner join para.paclas b on a.csauto = b.csauto where a.cpcpte = :cpcpte", nativeQuery = true)
    Codetjplus findCodetj(String cpcpte);

    @Query(value = "select a.cpauto, a.cpinti, b.csauto, b.cscode, b.cstypc from para.pacpte a inner join para.paclas b on a.csauto = b.csauto where a.cpcpte = :cpcpte and a.stauto = :stauto", nativeQuery = true)
    Codetjplus findCodetj(String cpcpte, long stauto);

    interface Codetjplus {
        long    getCpauto();
        long    getCsauto();
        long    getCscode();
        String  getCpinti();
        int    getCstypc();
    }
}
