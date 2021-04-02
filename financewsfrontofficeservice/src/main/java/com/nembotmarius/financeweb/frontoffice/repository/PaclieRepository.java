package com.nembotmarius.financeweb.frontoffice.repository;

import com.nembotmarius.financeweb.frontoffice.entity.PaclieEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PaclieRepository extends CrudRepository<PaclieEntity, Long> {

    @Query(value = "SELECT u.* FROM para.paclie u inner join para.pacpte c On u.clauto = c.clauto WHERE c.cpauto = :cpauto", nativeQuery = true)
    PaclieEntity findPaclieByCpauto(long cpauto);
}
