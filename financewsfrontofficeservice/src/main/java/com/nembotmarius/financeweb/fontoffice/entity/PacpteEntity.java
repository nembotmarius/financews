package com.nembotmarius.financeweb.fontoffice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "pacpte")
@Table(name = "pacpte",schema = "para")
public class PacpteEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long	  clauto;
    private int	      cpacti;
    private long	  cpauto;
    private int	      cpclot;
    private String	  cpcpte;
    private long	  cpdacr;
    private long	  cpdaup;
    private long	  cpdeco;
    private int	      cpdele;
    private int	      cpgele;
    private String	  cpinti;
    private String	  cpmand;
    private int	      cpnoup;
    private long	  cpnsig;
    private long	  cpsobl;
    private long	  cpsold;
    private int	      cpusde;
    private long	  cpusup;
    private long	  csauto;
    private long	  stauto;

}
