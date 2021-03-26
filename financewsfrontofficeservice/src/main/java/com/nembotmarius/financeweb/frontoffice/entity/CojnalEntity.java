package com.nembotmarius.financeweb.frontoffice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "cojnal")
@Table(name = "cojnal",schema = "comp")
public class CojnalEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long	 jnauto;
    private long	 stauto;
    private long	 joauto;
    private long	 jndamv;
    private long	 jndasa;
    private long	 jndava;
    private String	 jnmoti;
    private long	 jnstat;
    private String	 jnsrct;
    private long	 jnsrca;
    private long	 jndacr;
    private long	 jnusup;
    private long	 jndaup;
    private int	     jnnoup;
    private int	     jndele;
    private int	     jnusde;
}
