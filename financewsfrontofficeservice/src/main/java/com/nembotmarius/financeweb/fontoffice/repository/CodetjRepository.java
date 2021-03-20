package com.nembotmarius.financeweb.fontoffice.repository;

import com.nembotmarius.financeweb.fontoffice.entity.CodetjEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface CodetjRepository extends CrudRepository<CodetjEntity, Long> {

    @Query(value = "SELECT * FROM para.codetj u WHERE u.djauto = :djauto", nativeQuery = true)
    CodetjEntity findCodetjById(long djauto);

    @Query(value = "SELECT * FROM para.codetj u ORDER BY jnauto", nativeQuery = true)
    Collection<CodetjEntity> findAllCodetj(long jnauto);
}
