package com.nembotmarius.financeweb.frontoffice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "paclie")
public class PaclieEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long clauto;
    private int claut2;
    private int stauto;
    private int clclez;
    private String clnomc;
    private long cldana;
    private String cllieu;
    private String clprof;
    private String clcnic;
    private String cladre;
    private String clsitm;
    private long cltel1;
    private long cltel2;
    private String clmail;
    private String clquar;
    private int clphot;
    private int clsign;
    private int clplan;
    private int clcose;
    private int clacti;
    private long cldacr;
    private int clusup;
    private long cldaup;
    private int clnoup;
    private int cldele;
    private int clusde;
    private String cltitr;
    private String clnati;
    private String clmodi;
    private String clpcon;
    private String cltelp;
    private String clncom;
    private String cltypa;
    private String clrcom;
    private String cldcre;
    private String clfjur;
}
