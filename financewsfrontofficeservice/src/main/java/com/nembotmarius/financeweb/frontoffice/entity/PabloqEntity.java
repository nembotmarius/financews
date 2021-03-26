package com.nembotmarius.financeweb.frontoffice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "pabloq")
@Table(name = "pabloq",schema = "para")
public class PabloqEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long blauto;
    private long cpauto;
    private long blmont;
    private String blmoti;
    private long bldasa;
    private long bldaex;
    private long bldacr;
    private long blusup;
    private long bldaup;
    private int	 blnoup;
    private int	 bldele;
    private int	 blusde;
}
