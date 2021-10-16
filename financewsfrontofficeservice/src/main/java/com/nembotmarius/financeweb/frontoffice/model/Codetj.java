package com.nembotmarius.financeweb.frontoffice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Codetj {
    private long	djauto;
    private long	jnauto;
    private String	djtyco;
    private String	djncod;
    private String	djncoc;
    private String	djlibe;
    private long	djmond;
    private long	djmonc;
    private long	djdacr;
    private long	djusup;
    private long	djdaup;
    private int	    djnoup;
    private int	    djdele;
    private int	    djusde;
    private long	stauto;
    private long	cpauto;
    private long	csauto;
    private long	cscode;
    private String	cpinti;
    private long	cstypc;
    private String	cslibe;
    private String	djncoc2;

    private long	cssold; // le montant du solde
    private String	csdets; //Le details du solde
}
