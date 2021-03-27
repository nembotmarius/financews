package com.nembotmarius.financeweb.clients1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "antran")
@Table(name = "antran",schema = "andr")
public class AntranEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long	  anauto;
    private long	  stauto;
    private long	  usauto;
    private String	  uscpte;
    private long	  ouauto;
    private long	  andatr;
    private long	  anmont;
    private long	  anclez;
    private String	  aninti;
    private long	  antele;
    private String	  ancnic;
    private long	  clauto;
    private String	  cpcpte;
    private String	  antier;
    private String	  anpiec;
    private String	  anmoti;
    private int	  	  anenso;
    private long	  andacr;
    private long	  anusup;
    private long	  andaup;
    private int	  	  annoup;
    private int	  	  andele;
    private int	  	  anusde;
    private long	  anstat;
}
