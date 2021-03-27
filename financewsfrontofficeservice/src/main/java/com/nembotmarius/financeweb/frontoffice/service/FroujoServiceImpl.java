package com.nembotmarius.financeweb.frontoffice.service;

import com.nembotmarius.financeweb.frontoffice.entity.FroujoEntity;
import com.nembotmarius.financeweb.frontoffice.entity.ScsessEntity;
import com.nembotmarius.financeweb.frontoffice.exception.AuthenticationFail;
import com.nembotmarius.financeweb.frontoffice.exception.NotFoundException;
import com.nembotmarius.financeweb.frontoffice.repository.FroujoRepository;
import com.nembotmarius.financeweb.frontoffice.repository.ScsessRepository;
import com.nembotmarius.financeweb.frontoffice.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class FroujoServiceImpl implements FroujoService{

    private final FroujoRepository Froujorepository;
    private final ScsessRepository scsessrepository;

    @Autowired
    private String getUserBucketPath;

    @Override
    public Collection<FroujoRepository.JourneeCol> getAllOpenDay(String user, String token, String stauto, String oudajr, String oustat, String oustat2) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide

        //mets a jour la date de derniere connection
        //verifie si clauto n'est pas null
        Utils o = new Utils();
        if(o.isNumeric(oudajr) && o.isNumeric(oustat) && o.isNumeric(oustat2)){
            //sinon cherche si ce clients existe dans la bd
            int stauto2 = Integer.parseInt(stauto);
            long oudajr2 = Long.parseLong(oudajr);
            int oustat21 = Integer.parseInt(oustat);
            int oustat22 = Integer.parseInt(oustat2);
            Collection<FroujoRepository.JourneeCol> lstfroujo = Froujorepository.findAllOpenday2(stauto2, oudajr2, oustat21, oustat22);

            if(lstfroujo != null){
                //une fois trouver retourner la collecte
                return lstfroujo;
            }else{
                //sinon retourne une exception 404
                throw new NotFoundException("Aucune jounée ouverte");
            }
        }else{
            //sinon retourne une exception 404
            throw new NotFoundException("id Compte incorrecte");
        }
    }

    public boolean checkAuthentification(String user, String token) {
        ScsessEntity scsessentity = scsessrepository.findScsessBySsidese(token);
        Utils o = new Utils();
        if (scsessentity == null) {
            return false;
        } else {
            long lastupdatedate = scsessentity.getSsdaup();
            long currupdatedate = o.getCurrentDate();
            if (lastupdatedate < 100000000) {
                lastupdatedate = lastupdatedate * 10000;
            }
            if ((currupdatedate - lastupdatedate) > Integer.parseInt(getUserBucketPath)) {
                return false;
            }
            scsessentity.setSsdaup(o.getCurrentDate());
            scsessrepository.save(scsessentity);
            return true;

        }
    }
}
