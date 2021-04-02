package com.nembotmarius.financeweb.frontoffice.service;

import com.nembotmarius.financeweb.frontoffice.model.Cojnal;
import java.util.List;

public interface CojnalService {

    Cojnal getJnalbyId(
            String user,
            String token,
            String jnauto
    );

    List<Cojnal> getJnalPeriode(
            String user,
            String token,
            String stauto,
            String debut,
            String fin,
            String nbrows,
            String page
    );

    Cojnal AddJnalCpte(
            String user,
            String token,
            Cojnal cojnal,
            String option
    );

    Cojnal SaveJnalCpte(
            String user,
            String token,
            Cojnal cojnal
    );
}
