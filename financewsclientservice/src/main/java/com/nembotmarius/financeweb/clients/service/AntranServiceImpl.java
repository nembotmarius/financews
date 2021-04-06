package com.nembotmarius.financeweb.clients.service;

import com.nembotmarius.financeweb.clients.entity.AnctelEntity;
import com.nembotmarius.financeweb.clients.entity.AntranEntity;
import com.nembotmarius.financeweb.clients.entity.PaclieEntity;
import com.nembotmarius.financeweb.clients.entity.ScsessEntity;
import com.nembotmarius.financeweb.clients.exception.AuthenticationFail;
import com.nembotmarius.financeweb.clients.exception.Deletewithwrongid;
import com.nembotmarius.financeweb.clients.exception.NotFoundException;
import com.nembotmarius.financeweb.clients.model.Collecte;
import com.nembotmarius.financeweb.clients.repository.AnctelRepository;
import com.nembotmarius.financeweb.clients.repository.AntranRepository;
import com.nembotmarius.financeweb.clients.repository.PaclieRepository;
import com.nembotmarius.financeweb.clients.repository.ScsessRepository;
import com.nembotmarius.financeweb.clients.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AntranServiceImpl implements AntranService {
    private final AntranRepository antranrepository;
    private final ScsessRepository scsessrepository;
    private final PaclieRepository paclierepository;
    private final AnctelRepository anctelrepository;

    @Autowired
    private String getUserBucketPath;


    @Override
    public AntranEntity insertAntran(String user, String token, Collecte c) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide

        Utils o = new Utils();
        String Motif = "Collecte du " + o.getCurrentDateStr() + "(" + c.getCpinti() + ")";

        //recupere le client qui a effectué l'operation
        PaclieEntity paclieentity = paclierepository.findPaclieById(Long.parseLong(c.getClauto()));
        if(paclieentity!=null){
            String otelval = paclieentity.getCltelp();
            String otel = String.valueOf(paclieentity.getCltel1());
            String ntel = c.getCltel1();
            //si le client n'a pas encore activé les sms alors mets a jours le telephone et active
            if(otelval.equals("")){
                if(c.getCltel1().length()>=9){
                    paclieentity.setCltel1(Long.parseLong(c.getCltel1()));
                    paclieentity.setCltelp("Ok");
                    paclierepository.save(paclieentity);
                }
            }else{
                if(!ntel.equals(otel)){
                    AnctelEntity anctelentity = new AnctelEntity();
                    anctelentity.setAtauto(-1);
                    anctelentity.setUsauto(Integer.parseInt(c.getUsauto()));
                    anctelentity.setClauto(paclieentity.getClauto());
                    anctelentity.setClclez(paclieentity.getClclez());
                    anctelentity.setClnomc(paclieentity.getClnomc());
                    anctelentity.setAtdesc("Modification Numero de telephone");
                    anctelentity.setAtntel(c.getCltel1());
                    anctelentity.setAtotel(String.valueOf(paclieentity.getCltel1()));
                    anctelentity.setStauto(Integer.parseInt(c.getStauto()));

                    anctelrepository.save(anctelentity);
                }
            }
        }

        AntranEntity antranentitycheck = antranrepository.findAntranByanpiec(c.getIdtran(), Long.parseLong(c.getOuauto()));
        int vardelete = 0;
        if(antranentitycheck==null){
            vardelete = 0;
        }else{
            vardelete = 1;
        }

            //si la transaction n'existe pas crée
            AntranEntity antranentity = new AntranEntity();
            antranentity.setAnauto(-1);
            antranentity.setStauto(Long.parseLong(c.getStauto()));
            antranentity.setUsauto(Long.parseLong(c.getUsauto()));
            antranentity.setUscpte(c.getCpcpte());
            antranentity.setOuauto(Long.parseLong(c.getOuauto()));
            antranentity.setAndatr(o.getCurrentDate());
            antranentity.setAnmont(Long.parseLong(c.getMontant()));
            antranentity.setAnclez(Long.parseLong(c.getClclez()));
            antranentity.setAninti(c.getCpinti());
            antranentity.setAntele(Long.parseLong(c.getCltel1()));
            antranentity.setAncnic(c.getClucni());
            antranentity.setClauto(Long.parseLong(c.getClauto()));
            antranentity.setCpcpte(c.getCpcpte());
            antranentity.setAntier(c.getCpinti());
            antranentity.setAnpiec(c.getIdtran());
            antranentity.setAnmoti(Motif);
            antranentity.setAnenso(-1);
            antranentity.setAndacr(o.getCurrentDate());
            antranentity.setAnusup(0);
            antranentity.setAndaup(o.getCurrentDate());
            antranentity.setAnnoup(0);
            antranentity.setAndele(vardelete);
            antranentity.setAnusde(0);
            antranentity.setAnstat(10);

            return antranrepository.save(antranentity);

    }

    @Override
    public AntranEntity deleteAntran(String user, String token, AntranEntity collecte, String id) {
        //verifie si l'id est un numeric
        //si numeric verifie si existe dans la base de données
        //si oui supprimer de la base  de données
        //si non retourner une movie exception
        //verifie si clauto n'est pas null


        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide
        Utils o = new Utils();
        if(!o.isNumeric(id)){
            throw new Deletewithwrongid("L'id doit être un numeric");
        }

        AntranEntity antranentitytodelete = antranrepository.findAntranByidstat10(Long.parseLong(id));
        if(antranentitytodelete==null){
            throw new Deletewithwrongid("La collecte n'existe pas dans la base ou le statut ne permet plus la modification");
        }

        antranrepository.deleteById(Long.parseLong(id));
        return antranentitytodelete;
    }

    @Override
    public AntranEntity updateAntran(String user, String token, AntranEntity collecte, String id) {
        //verifie si l'id est un numeric
        //si numeric verifie si existe dans la base de données
        //si oui supprimer de la base  de données
        //si non retourner une movie exception
        //verifie si clauto n'est pas null


        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide
        Utils o = new Utils();
        if(!o.isNumeric(id)){
            throw new Deletewithwrongid("L'id doit être un numeric");
        }

        AntranEntity antranentitytoupdate = antranrepository.findAntranByidstat10(Long.parseLong(id));
        if(antranentitytoupdate==null){
            throw new Deletewithwrongid("La collecte n'existe pas dans la base ou le statut ne permet plus la modification");
        }

        antranentitytoupdate.setStauto(collecte.getStauto());
        antranentitytoupdate.setUsauto(collecte.getUsauto());
        antranentitytoupdate.setUscpte(collecte.getUscpte());
        antranentitytoupdate.setOuauto(collecte.getOuauto());
        antranentitytoupdate.setAndatr(collecte.getAndatr());
        antranentitytoupdate.setAnmont(collecte.getAnmont());
        antranentitytoupdate.setAnclez(collecte.getAnclez());
        antranentitytoupdate.setAninti(collecte.getAninti());
        antranentitytoupdate.setAntele(collecte.getAntele());
        antranentitytoupdate.setAncnic(collecte.getAncnic());
        antranentitytoupdate.setClauto(collecte.getClauto());
        antranentitytoupdate.setCpcpte(collecte.getCpcpte());
        antranentitytoupdate.setAntier(collecte.getAntier());
        antranentitytoupdate.setAnpiec(collecte.getAnpiec());
        antranentitytoupdate.setAnmoti(collecte.getAnmoti());
        antranentitytoupdate.setAnenso(collecte.getAnenso());
        antranentitytoupdate.setAndacr(collecte.getAndacr());
        antranentitytoupdate.setAnusup(collecte.getAnusup());
        antranentitytoupdate.setAndaup(collecte.getAndaup());
        antranentitytoupdate.setAnnoup(collecte.getAnnoup());
        antranentitytoupdate.setAndele(collecte.getAndele());
        antranentitytoupdate.setAnusde(collecte.getAnusde());
        antranentitytoupdate.setAnstat(collecte.getAnstat());

        antranrepository.save(antranentitytoupdate);
        return antranentitytoupdate;
    }

    @Override
    public AntranEntity getAntranbyid(String user, String token, String antranid) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide

        //mets a jour la date de derniere connection
        //verifie si clauto n'est pas null
        Utils o = new Utils();
        if(o.isNumeric(antranid)){
            //sinon cherche si ce clients existe dans la bd
            long anauto = Long.parseLong(antranid);
            AntranEntity antran = antranrepository.findAntranByid(anauto);

            if(antran != null){
                //une fois trouver retourner la collecte
                return antran;
            }else{
                //sinon retourne une exception 404
                throw new NotFoundException("Collecte inexistante");
            }
        }else{
            //sinon retourne une exception 404
            throw new NotFoundException("id collecte incorrecte");
        }
    }

    @Override
    public Collection<AntranEntity> getAllCollecteByDay(String user, String token, String ouauto) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide

        //mets a jour la date de derniere connection
        //verifie si clauto n'est pas null
        Utils o = new Utils();
        if(o.isNumeric(ouauto)){
            //sinon cherche si ce clients existe dans la bd
            long ouauto2 = Long.parseLong(ouauto);
            Collection<AntranEntity> lstantran = antranrepository.findAntranByDay(ouauto2);

            if(lstantran != null){
                //une fois trouver retourner la collecte
                return lstantran;
            }else{
                //sinon retourne une exception 404
                throw new NotFoundException("Collecte inexistante");
            }
        }else{
            //sinon retourne une exception 404
            throw new NotFoundException("id collecte incorrecte");
        }
    }

    public boolean checkAuthentification(String user, String token) {
        ScsessEntity scsessentity = scsessrepository.findScsessBySsidese(token);
        Utils o = new Utils();
        if(scsessentity==null){
            return false;
        }else{
            long lastupdatedate = scsessentity.getSsdaup();
            long currupdatedate = o.getCurrentDate();
            if(lastupdatedate<100000000){
                lastupdatedate=lastupdatedate*10000;
            }
            if((currupdatedate-lastupdatedate)>Integer.parseInt(getUserBucketPath)){
                return false;
            }
            scsessentity.setSsdaup(o.getCurrentDate());
            scsessrepository.save(scsessentity);
            return true;

        }
    }
}
