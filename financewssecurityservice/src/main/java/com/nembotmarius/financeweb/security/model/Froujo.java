package com.nembotmarius.financeweb.security.model;

import com.nembotmarius.financeweb.security.entity.FroujoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Froujo {

    private long	 ouauto;
    private long	 stauto;
    private long	 usauto;
    private long	 reauto;
    private long	 usaut2;
    private long	 oudajr;
    private int	 	 outran;
    private long	 oumtde;
    private long	 oumtre;
    private int	 	 ounbcl;
    private int	 	 ounbre;
    private int	 	 caauto;
    private String	 oucana;
    private long	 oustat;
    private String	 recode;
    private String	 cacode;
    private long	 oudacr;
    private long	 ouusup;
    private long	 oudaup;
    private int	 	 ounoup;
    private int	 	 oudele;
    private int	 	 ouusde;
    private long	 oucode;

    private String	 uscpte;
    private String	 token;
    private String	 relibe;

    public void setEntitytoModel(FroujoEntity f){
        ouauto = f.getOuauto();
        stauto = f.getStauto();
        usauto = f.getUsauto();
        reauto = f.getReauto();
        usaut2 = f.getUsaut2();
        oudajr = f.getOudajr();
        outran = f.getOutran();
        oumtde = f.getOumtde();
        oumtre = f.getOumtre();
        ounbcl = f.getOunbcl();
        ounbre = f.getOunbre();
        caauto = f.getCaauto();
        oucana = f.getOucana();
        oustat = f.getOustat();
        recode = f.getRecode();
        cacode = f.getCacode();
        oudacr = f.getOudacr();
        ouusup = f.getOuusup();
        oudaup = f.getOudaup();
        ounoup = f.getOunoup();
        oudele = f.getOudele();
        ouusde = f.getOuusde();
        oucode = f.getOucode();
    }
}
