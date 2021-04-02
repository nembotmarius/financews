package com.nembotmarius.financeweb.frontoffice.repository;

import com.nembotmarius.financeweb.frontoffice.entity.PaconfEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaconfRepository extends CrudRepository<PaconfEntity, Long> {
    @Query(value = "select * from para.paconf p where cfpk01='smsconfig';", nativeQuery = true)
    List<PaconfEntity> findAllConfSms();
}
