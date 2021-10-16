package com.nembotmarius.financeweb.frontoffice.repository;

import com.nembotmarius.financeweb.frontoffice.entity.PaconfEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface PaconfRepository extends CrudRepository<PaconfEntity, Long> {
    @Query(value = "select * from para.paconf p where cfpk01='smsconfig';", nativeQuery = true)
    List<PaconfEntity> findAllConfSms();

    @Query(value = "select * from para.paconf p where p.cfpk01 = 'SMS_ACTIVATION' and p.stauto = :stauto and p.cfpk02 = :cfpk02 ;", nativeQuery = true)
    Collection<PaconfEntity> findConfSmsClient(long stauto, String cfpk02);
}
