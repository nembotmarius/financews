package com.nembotmarius.financeweb.frontoffice.repository;

import com.nembotmarius.financeweb.frontoffice.entity.PacpteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface PacpteRepository extends CrudRepository<PacpteEntity, Long> {

    @Query(value = "SELECT * FROM para.pacpte u WHERE u.cpauto = :cpauto", nativeQuery = true)
    PacpteEntity findPacpteById(long cpauto);

    @Query(value = "SELECT * FROM para.pacpte u ORDER BY cpcpte", nativeQuery = true)
    Collection<PacpteEntity> findAllPacpte();

    @Query(value = "Select A.* from para.pacpte A " +
            "inner join para.paclie B on A.clauto = B.clauto " +
            "inner join para.paclas C on A.csauto = C.csauto " +
            "where A.cpdele = 0 and B.clclez = :clclez and cstypc = 3" +
            "and (A.cpgele not in (1,11,111,101));", nativeQuery = true)
    Collection<PacpteEntity> findAllPacpteColbyClez(long clclez);

    @Query(value = "Select A.* from para.pacpte A " +
            "inner join para.paclie B on A.clauto = B.clauto " +
            "inner join para.paclas C on A.csauto = C.csauto " +
            "where A.cpdele = 0 and B.clclez = :clclez ;", nativeQuery = true)
    Collection<PacpteEntity> findAllPacptebyClez(long clclez);

    @Query(value = "select A.cpauto, A.csauto, A.cscode, A.cpcpte, A.csfrfc, sum(A.djsold) as djsold from ( \n" +
            " select C.cpauto, B.csauto, B.cscode, B.csfrfc, C.cpcpte as cpcpte, coalesce((-A.djmond + A.djmonc),0) as djsold \n" +
            " from para.paclas B inner join  para.pacpte C on B.csauto = C.csauto left join comp.codetj A on (C.cpauto=A.cpauto) where C.cpauto= :cpauto \n" +
            " ) A group by A.cpauto, A.csauto, A.cscode, A.cpcpte, A.csfrfc;", nativeQuery = true)
    SoldeCompte findSoldeCompte(long cpauto);

    interface SoldeCompte {
        long    getCpauto();
        long    getCsauto();
        long    getCscode();
        String  getCpcpte();
        long    getCsfrfc();
        long    getDjsold();
    }
}
