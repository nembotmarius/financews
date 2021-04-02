package com.nembotmarius.financeweb.frontoffice.service;

import com.nembotmarius.financeweb.frontoffice.entity.*;
import com.nembotmarius.financeweb.frontoffice.exception.AuthenticationFail;
import com.nembotmarius.financeweb.frontoffice.exception.NotFoundException;
import com.nembotmarius.financeweb.frontoffice.exception.SoldeNotAvailable;
import com.nembotmarius.financeweb.frontoffice.mapper.CodetjMapper;
import com.nembotmarius.financeweb.frontoffice.mapper.CojnalMapper;
import com.nembotmarius.financeweb.frontoffice.model.Codetj;
import com.nembotmarius.financeweb.frontoffice.model.Cojnal;
import com.nembotmarius.financeweb.frontoffice.model.Pacpte;
import com.nembotmarius.financeweb.frontoffice.repository.*;
import com.nembotmarius.financeweb.frontoffice.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CojnalServiceImpl implements CojnalService{
    private final ScsessRepository scsessrepository;
    private final CojnalRepository cojnalrepository;
    private final CodetjRepository codetjrepository;
    private final PaclieRepository paclierepository;
    private final PaconfRepository paconfrepository;
    private final AntranRepository antranrepository;

    private final PacpteService pacpteservice;

    @Autowired
    private String getUserBucketPath;



    @Override
    public Cojnal getJnalbyId(String user, String token, String jnauto) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide

        //mets a jour la date de derniere connection
        //verifie si clauto n'est pas null
        Utils o = new Utils();
        if(o.isNumeric(jnauto)){
            //sinon cherche si cette ecriture existe dans la bd
            long jnauto2 = Integer.parseInt(jnauto);
            CojnalEntity cojnalentity = cojnalrepository.findCojnalById(jnauto2);
            if(cojnalentity!=null){
                Cojnal cojnal = CojnalMapper.INSTANCE.mapEntityToModel(cojnalentity);
                Collection<CodetjEntity> lstcodetjentity = codetjrepository.findAllCodetj(jnauto2);
                List<Codetj> lstcodetj = new ArrayList<>();
                for (CodetjEntity c : lstcodetjentity) {
                    Codetj codetj = CodetjMapper.INSTANCE.mapEntityToModel(c);
                    lstcodetj.add(codetj);
                }
                cojnal.setLstcodetj(lstcodetj);

                return cojnal;
            }else{
                //sinon retourne une exception 404
                throw new NotFoundException("Pas d'ecriture dans le journal");
            }
        }else{
            //sinon retourne une exception 404
            throw new NotFoundException("id Compte incorrecte");
        }
    }

    @Override
    public List<Cojnal> getJnalPeriode(String user, String token, String stauto, String debut, String fin, String nbrows, String page) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide

        //mets a jour la date de derniere connection
        //verifie si clauto n'est pas null
        Utils o = new Utils();
        if(o.isNumeric(stauto) && o.isNumeric(debut) && o.isNumeric(fin) && o.isNumeric(nbrows) && o.isNumeric(page)){
            //sinon cherche si cette ecriture existe dans la bd
            long stauto2 = Long.parseLong(stauto);
            long debut2 = Long.parseLong(debut);
            long fin2 = Long.parseLong(fin);
            int nbrows2 = Integer.parseInt(nbrows);
            int page2 = Integer.parseInt(page);

            Collection<CojnalEntity> lstcojnalentity = cojnalrepository.findCojnalByPeriode(stauto2,debut2,fin2,nbrows2,page2);
            if(lstcojnalentity!=null){
                List<Cojnal> lstcojnal = new ArrayList<>();
                for (CojnalEntity jnalentity : lstcojnalentity) {
                    Cojnal cojnal = CojnalMapper.INSTANCE.mapEntityToModel(jnalentity);
                    Collection<CodetjEntity> lstcodetjentity = codetjrepository.findAllCodetj(cojnal.getJnauto());
                    List<Codetj> lstcodetj = new ArrayList<>();
                    for (CodetjEntity c : lstcodetjentity) {
                        Codetj codetj = CodetjMapper.INSTANCE.mapEntityToModel(c);
                        lstcodetj.add(codetj);
                    }
                    cojnal.setLstcodetj(lstcodetj);
                    lstcojnal.add(cojnal);
                }
                return lstcojnal;
            }else{
                //sinon retourne une exception 404
                throw new NotFoundException("Pas d'ecriture dans le journal");
            }
        }else{
            //sinon retourne une exception 404
            throw new NotFoundException("id Compte incorrecte");
        }
    }

    @Override
    public Cojnal AddJnalCpte(String user, String token, Cojnal cojnal2, String option) {
        Cojnal cojnal = cojnal2;

        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide
        //Verifie si les comptes a debiter ont des soldes disponibles
        //sinon renvoi une exeption
        List<Codetj> lstc = cojnal.getLstcodetj();
        List<Codetj> lstc2 = new ArrayList<>();
        for (Codetj c : lstc) {
            //Recupere les champs supplementaires pour la mise à jour
            String cpcpte = c.getDjncoc() + c.getDjncod();
            CodetjRepository.Codetjplus cp = codetjrepository.findCodetj(cpcpte);
            c.setCpauto(cp.getCpauto());
            c.setCsauto(cp.getCsauto());
            c.setCscode(cp.getCscode());
            c.setCstypc(cp.getCstypc());
            lstc2.add(c);
        }
        cojnal.setLstcodetj(lstc2);
        String checkresult = checkSolde(user, token, cojnal);
        if(!checkresult.equals("")){
            throw new SoldeNotAvailable(checkresult);
        }

        Utils o = new Utils();
        //Convertir les données du model vers entity
        cojnal.setJndacr(o.getCurrentDate2());
        CojnalEntity cojnalentity = CojnalMapper.INSTANCE.mapModelToEntity(cojnal);
        //Enregistre l'entete de l'ecriture comptable dans la base et recupere le nouvel enregistrement
        CojnalEntity cojnalentityresult = cojnalrepository.save(cojnalentity);
        //Convertir l'entity vers le model
        Cojnal cojnaltoreturn = CojnalMapper.INSTANCE.mapEntityToModel(cojnalentityresult);
        //recupère les lignes de details pour les enregistrer dans la base
        List<Codetj> lstcodetj = cojnal.getLstcodetj();
        List<Codetj> lstcodetjtoreturn = new ArrayList<>();
        for (Codetj c : lstcodetj) {
            //Mets a jour la clé etrangère et converti le model en entity
            c.setDjdacr(o.getCurrentDate2());
            c.setJnauto(cojnaltoreturn.getJnauto());
            //-------------------------------------------------------
            CodetjEntity codetjentity = CodetjMapper.INSTANCE.mapModelToEntity(c);
            //Sauvegarde dans la base
            CodetjEntity codetjentityresult = codetjrepository.save(codetjentity);
            Codetj codetjtoreturn = CodetjMapper.INSTANCE.mapEntityToModel(codetjentityresult);
            lstcodetjtoreturn.add(codetjtoreturn);

            //Change le statut de la collecte pour la mettre a Valider
            //-------------------------------------------------------------------
            String anautostr = codetjtoreturn.getDjncoc2();
            if(!anautostr.equals("") && o.isNumeric(anautostr)){
                long anauto = Long.parseLong(anautostr);
                AntranEntity antranentity = antranrepository.findAntranByid(anauto);
                antranentity.setAnstat(11);
                antranrepository.save(antranentity);
            }
            //--------------------------------------------------------------------
        }
        //mets à jour la liste des ecritures comptables du journal
        cojnaltoreturn.setLstcodetj(lstcodetjtoreturn);
        //Envoi de messages au clients
        smsClient(cojnaltoreturn);

        return cojnaltoreturn;
    }

    @Override
    public Cojnal SaveJnalCpte(String user, String token, Cojnal cojnal) {
        return null;
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

    public String checkSolde(String user, String token, Cojnal cojnal) {
        //Cette fonction liste les comptes a debiter d'une ecriture comptable
        // et verifie si le solde est disponible

        String result = "";
        List<Codetj> lstcodetj = cojnal.getLstcodetj();
        for (Codetj c : lstcodetj) {
            long djmond = c.getDjmond();
            int cstypc = (int) c.getCstypc();
            if(cstypc!=4 && djmond>0){
                long cpauto = c.getCpauto();
                //recupere le solde du compte
                Pacpte pacpte = pacpteservice.getComptebyid(user, token, String.valueOf(cpauto));
                long solde = pacpte.getCpsold();
                long fraisgestion = pacpte.getCsfrfc();
                long decouvert = 0;
                Collection<PadecoEntity> lsdeco = pacpte.getLsdeco();
                for(PadecoEntity padecoentity : lsdeco){
                    decouvert += padecoentity.getDcmont();
                }

                long montantbloque = 0;
                Collection<PabloqEntity> lsbloq = pacpte.getLsbloq();
                for(PabloqEntity pabloqentity : lsbloq){
                    montantbloque += pabloqentity.getBlmont();
                }

                long soldedispo = solde + decouvert - fraisgestion - montantbloque;
                if(soldedispo < djmond){
                    result += pacpte.getCpinti() + " - Solde insufisant \n" +
                        " Solde : " + String.valueOf(solde) + "\n " +
                        " Decouvert : " + String.valueOf(decouvert) + "\n " +
                        " Montant Bloqué : " + String.valueOf(montantbloque) + "\n " +
                        " Frais de gestion : " + String.valueOf(fraisgestion) + "\n " +
                        " Solde disponible : " + String.valueOf(soldedispo) + "\n " +
                        "--------------------------------------- \n";
                }
            }
        }
        return result;
    }

    public String smsClient(Cojnal cojnal) {
        //Cette fonction liste les comptes a debiter d'une ecriture comptable
        // et verifie si le solde est disponible

        String login = "";
        String password = "";
        String sender_id = "";

        //Recupere la liste des configurations relative a l'envoi des messages
        List<PaconfEntity> lstconfig = paconfrepository.findAllConfSms();
        for (PaconfEntity cf : lstconfig) {
            if(cf.getCfpk02().equals("login")) login = cf.getCfvst1();
            if(cf.getCfpk02().equals("password")) password = cf.getCfvst1();
            if(cf.getCfpk02().equals("sender_id")) sender_id = cf.getCfvst1();
        }

        String result = "";
        List<Codetj> lstcodetj = cojnal.getLstcodetj();
        for (Codetj c : lstcodetj) {
            long cpauto = c.getCpauto();
            long djmond = c.getDjmond();
            long djmonc = c.getDjmonc();
            String cpcpte = c.getDjncoc() + c.getDjncod();
            String[] cpcptetbl = cpcpte.split(" ");
            if(cpcptetbl.length>=3) cpcpte = cpcptetbl[0] + ".." + cpcptetbl[2];
            String cpinti = (!c.getCpinti().equals(""))?c.getCpinti().split(" ")[0]:"";
            long montant = djmond + djmonc;

            String typeop = "crédit";
            if(djmond>0) typeop = "débit";
            //Recupère le numero de telephone du clients et verifie si il est activer
            //au envoi des messages
            PaclieEntity p = paclierepository.findPaclieByCpauto(cpauto);
            String cltelp = p.getCltelp();
            long cltel1 = p.getCltel1();

            Utils o = new Utils();

            //Change le statut de la collecte pour la mettre a Valider
            //-------------------------------------------------------------------
            String anautostr = c.getDjncoc2();
            AntranEntity antranentity = null;

            if(!anautostr.equals("") && o.isNumeric(anautostr)){
                long anauto = Long.parseLong(anautostr);
                antranentity = antranrepository.findAntranByid(anauto);
                antranentity.setAntele(p.getCltel1());
            }
            //--------------------------------------------------------------------
            // Envoi le sms et Modifie le statut a 21 sms envoyé
            if(!cltelp.equals("")){
                String messagesms = "M.(Mme) " + cpinti + ", " + typeop + " de votre compte " + cpcpte + " de XAF " + String.valueOf(montant) + " le  29-03-2021 à 10:54. Merci pour votre fidélité.";
                String destinataire = String.valueOf(cltel1);
                String message = messagesms;

                if(!login.equals("") && !password.equals("") && !sender_id.equals("")){
                    o.sendSms(login,password,sender_id,destinataire,message);
                    if(antranentity!=null) antranentity.setAnstat(21);
                }
            }
            //-----------------------------------------------------------------
            //Mets a jour les données dans la base
            if(antranentity!=null)  antranrepository.save(antranentity);
            //--------------------------------------------------------------
        }
        return result;
    }
}
