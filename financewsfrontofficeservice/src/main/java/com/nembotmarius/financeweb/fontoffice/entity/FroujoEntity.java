package com.nembotmarius.financeweb.fontoffice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "froujo")
@Table(name = "froujo",schema = "frof")
public class FroujoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long	 ouauto;
    private long	 stauto;
    private long	 usauto;
    private long	 reauto;
    private long	 usaut2;
    private long	 oudajr;
    private int	     outran;
    private long	 oumtde;
    private long	 oumtre;
    private int	     ounbcl;
    private int	     ounbre;
    private int	     caauto;
    private String	 oucana;
    private long	 oustat;
    private String	 recode;
    private String	 cacode;
    private long	 oudacr;
    private long	 ouusup;
    private long	 oudaup;
    private int	     ounoup;
    private int	     oudele;
    private int	     ouusde;
    private long	 oucode;

}
