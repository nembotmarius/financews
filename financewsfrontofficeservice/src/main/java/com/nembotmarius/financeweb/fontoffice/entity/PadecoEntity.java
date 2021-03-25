package com.nembotmarius.financeweb.fontoffice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "padeco")
@Table(name = "padeco",schema = "para")
public class PadecoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long	dcauto;
    private long	cpauto;
    private long	stauto;
    private long	dcdava;
    private long	dcdaex;
    private String	dcobsr;
    private long	dcmont;
    private long	dcfrmi;
    private long	dcauth;
    private long	dcstat;
    private long	dcdacr;
    private long	dcusup;
    private long	dcdaup;
    private int	    dcnoup;
    private int	    dcdele;
    private int	    dcusde;
}
