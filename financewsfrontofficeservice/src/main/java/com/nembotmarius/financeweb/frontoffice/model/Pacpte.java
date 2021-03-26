package com.nembotmarius.financeweb.frontoffice.model;

import com.nembotmarius.financeweb.frontoffice.entity.PabloqEntity;
import com.nembotmarius.financeweb.frontoffice.entity.PadecoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.Collection;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Pacpte {
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
    private long	  cscode;
    private long	  csfrfc;
    private Collection<PadecoEntity> lsdeco;
    private Collection<PabloqEntity> lsbloq;
}
