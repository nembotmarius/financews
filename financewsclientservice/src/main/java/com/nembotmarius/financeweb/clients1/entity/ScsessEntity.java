package com.nembotmarius.financeweb.clients1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "scsess")
@Table(name = "scsess",schema = "secu")
public class ScsessEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long	ssauto;
    private long    usauto;
    private int     acauto;
    private int     stauto;
    private String  ssidse;
    private long    ssdacr;
    private long    ssdaup;
}
