package com.nembotmarius.financeweb.frontoffice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "paconf")
@Table(name = "paconf",schema = "para")
public class PaconfEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long	cfauto;
    private long	stauto;
    private String	cfpk01;
    private String	cfpk02;
    private String	cfpk03;
    private String	cfpk04;
    private String	cfvst1;
    private String	cfvst2;
    private String	cfvst3;
    private String	cfvst4;
    private String	cfvst5;
    private String	cfvst6;
    private String	cfvst7;
    private String	cfvst8;
    private long	cfvin1;
    private long	cfvin2;
    private long	cfvin3;
    private long	cfvin4;
    private long	cfvin5;
    private long	cfvin6;
    private long	cfvin7;
    private long	cfvin8;
    private long	cfdacr;
    private long	cfusup;
    private long	cfdaup;
    private int	    cfnoup;
    private int	    cfdele;
    private int	    cfusde;

}
