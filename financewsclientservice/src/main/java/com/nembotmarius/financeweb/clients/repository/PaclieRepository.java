package com.nembotmarius.financeweb.clients.repository;

import java.util.Collection;
import java.util.List;

import com.nembotmarius.financeweb.clients.entity.PaclieEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;


public interface PaclieRepository extends CrudRepository<PaclieEntity, Long> {

    @Query(value = "SELECT * FROM para.paclie u WHERE u.clauto = :clauto", nativeQuery = true)
    PaclieEntity findPaclieById(long clauto);

    @Query(value = "SELECT * FROM para.paclie u ORDER BY clclez", nativeQuery = true)
    Collection<PaclieEntity> findAllPaclie();

    @Query(value = "Select C.clauto, C.clclez, C.clnomc, C.cltel1, C.clquar, B.cscode, B.cslibe, A.cpcpte, A.cpinti, A.cpauto  from para.pacpte A \n" +
            "                inner join para.paclas B on A.csauto = B.csauto\n" +
            "                inner join para.paclie C on A.clauto = C.clauto \n" +
            "            where B.cscode in ('3736','3737','3636')  and A.cpdele = 0 and A.stauto = :stauto and length(A.cpcpte)>10\n" +
            "            order by C.clclez, A.cpinti, B.cscode", nativeQuery = true)
    List<Compte> findAllCollecteCompte(int stauto);

    public interface Compte {
        long    getClauto();
        long    getClclez();
        String  getClnomc();
        long    getCltel1();
        String  getClquar();
        long    getCscode();
        String  getCslibe();
        String  getCpcpte();
        String  getCpinti();
        long    getCpauto();
    }
}
