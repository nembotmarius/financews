package com.nembotmarius.financeweb.frontoffice.repository;

import com.nembotmarius.financeweb.frontoffice.entity.CojnalEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CojnalRepository extends CrudRepository<CojnalEntity, Long> {

    @Query(value = "SELECT * FROM para.cojnal u WHERE u.jnauto = :jnauto", nativeQuery = true)
    CojnalEntity findCojnalById(long jnauto);
}
