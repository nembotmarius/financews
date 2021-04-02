package com.nembotmarius.financeweb.frontoffice.repository;

import com.nembotmarius.financeweb.frontoffice.entity.AntranEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface AntranRepository extends CrudRepository<AntranEntity, Long> {
    @Query(value = "SELECT * FROM andr.antran u WHERE u.anauto = :anauto", nativeQuery = true)
    AntranEntity findAntranByid(long anauto);
}
