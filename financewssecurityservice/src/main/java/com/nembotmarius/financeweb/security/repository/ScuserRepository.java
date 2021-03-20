package com.nembotmarius.financeweb.security.repository;

import com.nembotmarius.financeweb.security.entity.ScuserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ScuserRepository extends CrudRepository<ScuserEntity, Long> {
    @Query(value = "SELECT * FROM secu.scuser u WHERE u.usmatr = :usmatr", nativeQuery = true)
    ScuserEntity findScuserByUsmatr(String usmatr);
}
