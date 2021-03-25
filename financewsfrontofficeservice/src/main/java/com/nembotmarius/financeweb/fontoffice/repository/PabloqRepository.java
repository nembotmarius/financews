package com.nembotmarius.financeweb.fontoffice.repository;

import com.nembotmarius.financeweb.fontoffice.entity.PabloqEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface PabloqRepository extends CrudRepository<PabloqEntity, Long> {

    @Query(value = "select * from para.pabloq p where cpauto = :cpauto and bldaex >= :bldaex", nativeQuery = true)
    Collection<PabloqEntity> findAllBloquer(long cpauto, long bldaex);
}
