package com.nembotmarius.financeweb.fontoffice.repository;

import com.nembotmarius.financeweb.fontoffice.entity.CojnalEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface CojnalRepository extends CrudRepository<CojnalEntity, Long> {

    @Query(value = "SELECT * FROM para.cojnal u WHERE u.jnauto = :jnauto", nativeQuery = true)
    CojnalEntity findCojnalById(long jnauto);
}
