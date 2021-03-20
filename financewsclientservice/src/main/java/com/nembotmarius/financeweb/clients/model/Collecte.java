package com.nembotmarius.financeweb.clients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Collecte {
    private String idtran;
    private String cpcpte;
    private String clnomc;
    private String clclez;
    private String cslibe;
    private String cltel1;
    private String clquar;
    private String montant;
    private String cpauto;
    private String cpinti;
    private String cscode;

    private String stauto;
    private String usauto;
    private String ouauto;
    private String clucni;
    private String clauto;
}
