package com.nembotmarius.financeweb.frontoffice.repository;

import com.nembotmarius.financeweb.frontoffice.entity.FroujoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface FroujoRepository extends CrudRepository<FroujoEntity, Long> {

    @Query(value = "select * from frof.froujo f where stauto = :stauto and oudajr = :oudajr and oustat in (:oustat,:oustat2) and oudele=0 order by ouauto desc;", nativeQuery = true)
    Collection<FroujoEntity> findAllOpenday(int stauto, long oudajr, int oustat, int oustat2);

    @Query(value = "select " +
            "   A.ouauto," +
            "   A.oustat," +
            "   B.recode," +
            "   B.relibe," +
            "   C.usnomp," +
            "   C.uscpte," +
            "   C.cpauto, " +
            "   D.joauto, " +
            "   D.jocode, " +
            "   D.jolibe  " +
            " from frof.froujo A Left Join para.paregi B On A.reauto = B.reauto " +
            "    Left Join secu.scuser C On A.usauto = C.usauto " +
            "    left join para.pajnal D on (A.stauto = D.stauto and jocode='JN_COL' and josyst=10) " +
            "    where A.oudajr = :oudajr and A.stauto = :stauto and oustat in (:oustat,:oustat2) and A.oudele = 0;", nativeQuery = true)
    Collection<JourneeCol> findAllOpenday2(int stauto, long oudajr, int oustat, int oustat2);

    interface JourneeCol {
        long    getOuauto();
        int     getOustat();
        String  getRecode();
        String  getRelibe();
        String  getUsnomp();
        String  getUscpte();
        long    getCpauto();
        long    getJoauto();
        String  getJocode();
        String  getJolibe();
    }
}
