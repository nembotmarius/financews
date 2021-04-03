package com.nembotmarius.financeweb.clients.repository;

import com.nembotmarius.financeweb.clients.entity.AnctelEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AnctelRepository extends CrudRepository<AnctelEntity, Long> {

    @Query(value = "SELECT * FROM andr.anctel u WHERE u.atauto = :atauto", nativeQuery = true)
    AnctelEntity findAnctelByid(long atauto);

    @Query(value = "SELECT * FROM andr.anctel u WHERE u.stauto = :stauto", nativeQuery = true)
    List<AnctelEntity> findAllAnctelBystauto(int stauto);
}
