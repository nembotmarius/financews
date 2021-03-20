package com.nembotmarius.financeweb.fontoffice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class Cojnal {
    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    public class CojnalEntity {
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

        List<Codetj> details;
    }
}
