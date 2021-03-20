package com.nembotmarius.financeweb.security.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "paregi", schema="para")
public class ParegiEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long	reauto;
    long	teauto;
    String	recode;
    String	relibe;
    long	recpte;
    String	rejnal;
    long	redacr;
    long	reusup;
    long	redaup;
    int	    renoup;
    int	    redele;
    int	    reusde;
    long	stauto;

}
