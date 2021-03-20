package com.nembotmarius.financeweb.security.repository;

import com.nembotmarius.financeweb.security.entity.ParegiEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ParegiRepository extends CrudRepository<ParegiEntity, Long> {
    @Query(value = "SELECT * FROM para.paregi u WHERE u.reauto = :reauto", nativeQuery = true)
    ParegiEntity findParegiByid(long reauto);
}
