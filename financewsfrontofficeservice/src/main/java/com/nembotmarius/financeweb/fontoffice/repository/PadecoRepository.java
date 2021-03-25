package com.nembotmarius.financeweb.fontoffice.repository;

import com.nembotmarius.financeweb.fontoffice.entity.PadecoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface PadecoRepository extends CrudRepository<PadecoEntity, Long> {

    @Query(value = "select * from para.padeco p where cpauto = :cpauto and dcdaex >= :dcdaex", nativeQuery = true)
    Collection<PadecoEntity> findAllDecouvert(long cpauto, long dcdaex);
}
