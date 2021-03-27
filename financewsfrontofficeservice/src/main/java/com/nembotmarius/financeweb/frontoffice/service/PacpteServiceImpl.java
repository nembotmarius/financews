package com.nembotmarius.financeweb.frontoffice.service;

import com.nembotmarius.financeweb.frontoffice.entity.PabloqEntity;
import com.nembotmarius.financeweb.frontoffice.entity.PacpteEntity;
import com.nembotmarius.financeweb.frontoffice.entity.PadecoEntity;
import com.nembotmarius.financeweb.frontoffice.entity.ScsessEntity;
import com.nembotmarius.financeweb.frontoffice.exception.AuthenticationFail;
import com.nembotmarius.financeweb.frontoffice.exception.NotFoundException;
import com.nembotmarius.financeweb.frontoffice.model.Pacpte;
import com.nembotmarius.financeweb.frontoffice.repository.PabloqRepository;
import com.nembotmarius.financeweb.frontoffice.repository.PacpteRepository;
import com.nembotmarius.financeweb.frontoffice.repository.PadecoRepository;
import com.nembotmarius.financeweb.frontoffice.repository.ScsessRepository;
import com.nembotmarius.financeweb.frontoffice.mapper.PacpteMapper;
import com.nembotmarius.financeweb.frontoffice.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PacpteServiceImpl implements PacpteService{

    private final PacpteRepository pacpterepository;
    private final PadecoRepository padecorepository;
    private final PabloqRepository pabloqrepository;
    private final ScsessRepository scsessrepository;

    @Autowired
    private String getUserBucketPath;

    @Override
    public PacpteRepository.SoldeCompte getSoldebyid(String user, String token, String cpauto) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(checkAuthentification(user, token)){
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
    public Pacpte getComptebyid(String user, String token, String cpauto) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide

        //mets a jour la date de derniere connection
        //verifie si clauto n'est pas null
        Utils o = new Utils();
        if(o.isNumeric(cpauto)){
            //sinon cherche si ce clients existe dans la bd
            long cpauto2 = Long.parseLong(cpauto);
            PacpteEntity pacpteentity = pacpterepository.findPacpteById(cpauto2);
            Collection<PadecoEntity> lsdeco = padecorepository.findAllDecouvert(cpauto2, o.getCurrentDate2());
            Collection<PabloqEntity> lsbloq = pabloqrepository.findAllBloquer(cpauto2, o.getCurrentDate2());
            PacpteRepository.SoldeCompte soldecompte = pacpterepository.findSoldeCompte(cpauto2);

            if(soldecompte != null){
                //une fois trouver retourner la collecte
                Pacpte pacptetoreturn;
                pacptetoreturn = PacpteMapper.INSTANCE.mapEntityToModel(pacpteentity);
                pacptetoreturn.setCpauto(soldecompte.getCpauto());
                pacptetoreturn.setCsauto(soldecompte.getCsauto());
                pacptetoreturn.setCpcpte(soldecompte.getCpcpte());
                pacptetoreturn.setCpsold(soldecompte.getDjsold());

                pacptetoreturn.setCsfrfc(soldecompte.getCsfrfc());
                pacptetoreturn.setCscode(soldecompte.getCscode());
                pacptetoreturn.setLsbloq(lsbloq);
                pacptetoreturn.setLsdeco(lsdeco);

                return pacptetoreturn;
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
        if(checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide

        //mets a jour la date de derniere connection
        //verifie si clauto n'est pas null
        Utils o = new Utils();
        if(o.isNumeric(clclez)){
            //sinon cherche si ce clients existe dans la bd
            long clclez2 = Long.parseLong(clclez);
            Collection<PacpteEntity> lstpacpte = pacpterepository.findAllPacpteColbyClez(clclez2);

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

    @Override
    public Collection<PacpteEntity> getAllComptebyclez(String user, String token, String clclez) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(checkAuthentification(user, token)){
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
            return true;
        } else {
            long lastupdatedate = scsessentity.getSsdaup();
            long currupdatedate = o.getCurrentDate();
            if (lastupdatedate < 100000000) {
                lastupdatedate = lastupdatedate * 10000;
            }
            if ((currupdatedate - lastupdatedate) > Integer.parseInt(getUserBucketPath)) {
                return true;
            }
            scsessentity.setSsdaup(o.getCurrentDate());
            scsessrepository.save(scsessentity);
            return false;

        }
    }
}
