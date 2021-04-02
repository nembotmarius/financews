package com.nembotmarius.financeweb.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "scuser")
public class ScuserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long	   usauto;
    private long	   acauto;
    private String	   usmatr;
    private String	   usnomp;
    private String	   uspass;
    private long	   usdana;
    private long	   usdaem;
    private String	   uscnii;
    private int	       ussima;
    private String	   usmail;
    private int	       us1806;
    private int	       usdima;
    private long	   usdaex;
    private long	   usaffe;
    private long	   usdacr;
    private long	   ususup;
    private long	   usdaup;
    private int	       usnoup;
    private int	       usdele;
    private int	       ususde;
    private String	   uscpte;
    private long	   usleve;
}
