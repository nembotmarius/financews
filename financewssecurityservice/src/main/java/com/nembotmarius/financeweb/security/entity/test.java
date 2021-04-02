package com.nembotmarius.financeweb.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "scsess", schema="secu")
public class test {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long	agauto;
    private long	stauto;
    private long	cpauto;
    private String	cpcpte;
    private String	cpinti;
    private long	agsold;
    private long	agdeco;
    private long	agdajr;
    private long	agnbjr;
    private double   agtaux;
    private double   agintd;
    private long	agdacr;
    private long	agusup;
    private long	agdaup;
    private int	    agnoup;
    private int	    agdele;
    private int	    agusde;

}
