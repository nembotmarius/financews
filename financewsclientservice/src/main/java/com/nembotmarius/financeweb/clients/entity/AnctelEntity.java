package com.nembotmarius.financeweb.clients.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "anctel")
@Table(name = "anctel",schema = "andr")
public class AnctelEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long	atauto;
    private int	    stauto;
    private int	    usauto;
    private long	clauto;
    private long	clclez;
    private String	clnomc;
    private String	atotel;
    private String	atntel;
    private String	atdesc;
    private long	atdacr;
    private long	atusup;
    private long	atdaup;
    private int	    atnoup;
    private int	    atdele;
    private int	    atusde;

}
