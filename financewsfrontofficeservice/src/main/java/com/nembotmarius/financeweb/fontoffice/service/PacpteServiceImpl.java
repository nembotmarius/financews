package com.nembotmarius.financeweb.fontoffice.service;

import com.nembotmarius.financeweb.fontoffice.entity.PacpteEntity;
import com.nembotmarius.financeweb.fontoffice.entity.ScsessEntity;
import com.nembotmarius.financeweb.fontoffice.exception.AuthenticationFail;
import com.nembotmarius.financeweb.fontoffice.exception.NotFoundException;
import com.nembotmarius.financeweb.fontoffice.repository.PacpteRepository;
import com.nembotmarius.financeweb.fontoffice.repository.ScsessRepository;
import com.nembotmarius.financeweb.fontoffice.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PacpteServiceImpl implements PacpteService{

    private final PacpteRepository pacpterepository;
    private final ScsessRepository scsessrepository;

    @Autowired
    private String getUserBucketPath;

    @Override
    public PacpteRepository.SoldeCompte getSoldebyid(String user, String token, String cpauto) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide

        //mets a jour la date de derniere connection
        //verifie si clauto n'est pas null
        Utils o = new Utils();
        if(o.isNumeric(cpauto)){
            //sinon cherche si ce clients existe dans la bd
            long cpauto2 = Long.parseLong(cpauto);
            PacpteRepository.SoldeCompte soldecompte = pacpterepository.findSoldeCompte(cpauto2);

            if(soldecompte != null){
                //une fois trouver retourner la collecte
                return soldecompte;
            }else{
                //sinon retourne une exception 404
                throw new NotFoundException("Compte inexistante");
            }
        }else{
            //sinon retourne une exception 404
            throw new NotFoundException("id Compte incorrecte");
        }
    }

    @Override
    public Collection<PacpteEntity> getComptebyclez(String user, String token, String clclez) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide

        //mets a jour la date de derniere connection
        //verifie si clauto n'est pas null
        Utils o = new Utils();
        if(o.isNumeric(clclez)){
            //sinon cherche si ce clients existe dans la bd
            long clclez2 = Long.parseLong(clclez);
            Collection<PacpteEntity> lstpacpte = pacpterepository.findAllPacptebyClez(clclez2);

            if(lstpacpte != null){
                //une fois trouver retourner la collecte
                return lstpacpte;
            }else{
                //sinon retourne une exception 404
                throw new NotFoundException("Compte inexistant");
            }
        }else{
            //sinon retourne une exception 404
            throw new NotFoundException("clez Compte incorrecte");
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
