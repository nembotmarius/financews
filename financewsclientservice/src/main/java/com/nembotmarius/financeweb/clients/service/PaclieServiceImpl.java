package com.nembotmarius.financeweb.clients.service;

import com.nembotmarius.financeweb.clients.entity.PaclieEntity;
import com.nembotmarius.financeweb.clients.entity.ScsessEntity;
import com.nembotmarius.financeweb.clients.exception.AuthenticationFail;
import com.nembotmarius.financeweb.clients.exception.Deletewithwrongid;
import com.nembotmarius.financeweb.clients.exception.NotFoundException;
import com.nembotmarius.financeweb.clients.exception.PaclieUpdatewithwrongPaclieid;
import com.nembotmarius.financeweb.clients.repository.PaclieRepository;
import com.nembotmarius.financeweb.clients.repository.ScsessRepository;
import com.nembotmarius.financeweb.clients.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaclieServiceImpl implements PaclieService {
    private final PaclieRepository paclierepository;
    private final ScsessRepository scsessrepository;

    @Autowired
    private String getUserBucketPath;

    //Definition des variables session user _session, l'option de l'operation a effectuer _acauto, du code de l'activité
    @Override
    public Collection<PaclieEntity> getAllPaclies(@NonNull String user, @NonNull String token) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }

        //recherche tous les clients de la base
        Collection<PaclieEntity> paclieList = paclierepository.findAllPaclie();
        //si tout est bon je retourne la liste des clients
        return paclieList;
    }



    @Override
    public List<PaclieRepository.Compte> getAllCollecteCompte(String user, String token, String stauto) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }

        //mets a jour la date de derniere connection
        //verifie si clauto n'est pas null
        Utils o = new Utils();
        if(o.isNumeric(stauto)){
            //sinon cherche si ce clients existe dans la bd
            int stauto2 = Integer.parseInt(stauto);
            List<PaclieRepository.Compte> lstcomptes = paclierepository.findAllCollecteCompte(stauto2);

            if(lstcomptes != null){
                //une fois trouver retourner le clients
                return lstcomptes;
            }else{
                //sinon retourne une exception 404
                throw new NotFoundException("Comptes inexistants");
            }
        }else{
            //sinon retourne une exception 404
            throw new NotFoundException("stauto incorrecte");
        }
    }

    @Override
    public PaclieEntity getPaclieById(@NonNull String user, @NonNull String token, @NonNull String id) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide

        //mets a jour la date de derniere connection
        //verifie si clauto n'est pas null
        Utils o = new Utils();
        if(o.isNumeric(id)){
            //sinon cherche si ce clients existe dans la bd
            long clauto = Long.parseLong(id);
            PaclieEntity paclie = paclierepository.findPaclieById(clauto);

            if(paclie != null){
                //une fois trouver retourner le clients
                return paclie;
            }else{
                //sinon retourne une exception 404
                throw new NotFoundException("Client inexistant");
            }
        }else{
            //sinon retourne une exception 404
            throw new NotFoundException("id client incorrecte");
        }
    }

    @Override
    public PaclieEntity insertPaclie(@NonNull String user, @NonNull String token, @NonNull PaclieEntity paclieentity) {
        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide
        return paclierepository.save(paclieentity);
    }

    @Override
    public PaclieEntity updatePaclie(@NonNull String user, @NonNull String token, @NonNull String id, @NonNull PaclieEntity paclieentity) {
        //verifie si id est null ou n'est pas un numeric
        //si oui
            //renvoyer une exception avec le code 404 avec message d'erreur
        //sinon verifie si id et l'id du clients a modifié sont differents
            //si oui
                // renvoyer une exception avec le code 404 avec message d'erreur
            //sinon verifie si le movie a modifier existe bien dans la base, avant d'envisager de changer
                //si n'existe pas
                    // renvoyer une exception avec 404 Not found
                //si existe
                    // prendre ce clients et remplacer avec les informations à changer par les nouvelles valeurs
                    //si ok alors enregistrer de nouveau dans le BD

        //Verifie que le token est valide
        //si non valide renvoi une erreur 401
        if(!checkAuthentification(user, token)){
            throw new AuthenticationFail("Vous n'etes pas autorisé à utiliser ce service");
        }
        //si valide
        // verifie si clauto n'est pas null
        Utils o = new Utils();
        if(!o.isNumeric(id)){
            throw new PaclieUpdatewithwrongPaclieid("L'id doit être un numeric");
        }

        if(Long.parseLong(id)!=paclieentity.getClauto()){
            throw new PaclieUpdatewithwrongPaclieid("Les Ids Clients sont differents");
        }

        PaclieEntity paclieentitytoupdate = paclierepository.findPaclieById(Long.parseLong(id));
        if(paclieentitytoupdate==null){
            throw new PaclieUpdatewithwrongPaclieid("Le clients n'existe pas dans la base");
        }

        paclieentitytoupdate.setClaut2(paclieentity.getClaut2());
        paclieentitytoupdate.setStauto(paclieentity.getStauto());
        paclieentitytoupdate.setClclez(paclieentity.getClclez());
        paclieentitytoupdate.setClnomc(paclieentity.getClnomc());
        paclieentitytoupdate.setCldana(paclieentity.getCldana());
        paclieentitytoupdate.setCllieu(paclieentity.getCllieu());
        paclieentitytoupdate.setClprof(paclieentity.getClprof());
        paclieentitytoupdate.setClcnic(paclieentity.getClcnic());
        paclieentitytoupdate.setCladre(paclieentity.getCladre());
        paclieentitytoupdate.setClsitm(paclieentity.getClsitm());
        paclieentitytoupdate.setCltel1(paclieentity.getCltel1());
        paclieentitytoupdate.setCltel2(paclieentity.getCltel2());
        paclieentitytoupdate.setClmail(paclieentity.getClmail());
        paclieentitytoupdate.setClquar(paclieentity.getClquar());
        paclieentitytoupdate.setClphot(paclieentity.getClphot());
        paclieentitytoupdate.setClsign(paclieentity.getClsign());
        paclieentitytoupdate.setClplan(paclieentity.getClplan());
        paclieentitytoupdate.setClcose(paclieentity.getClcose());
        paclieentitytoupdate.setClacti(paclieentity.getClacti());
        paclieentitytoupdate.setCldacr(paclieentity.getCldacr());
        paclieentitytoupdate.setClusup(paclieentity.getClusup());
        paclieentitytoupdate.setCldaup(paclieentity.getCldaup());
        paclieentitytoupdate.setClnoup(paclieentity.getClnoup());
        paclieentitytoupdate.setCldele(paclieentity.getCldele());
        paclieentitytoupdate.setClusde(paclieentity.getClusde());
        paclieentitytoupdate.setCltitr(paclieentity.getCltitr());
        paclieentitytoupdate.setClnati(paclieentity.getClnati());
        paclieentitytoupdate.setClmodi(paclieentity.getClmodi());
        paclieentitytoupdate.setClpcon(paclieentity.getClpcon());
        paclieentitytoupdate.setCltelp(paclieentity.getCltelp());
        paclieentitytoupdate.setClncom(paclieentity.getClncom());
        paclieentitytoupdate.setCltypa(paclieentity.getCltypa());
        paclieentitytoupdate.setClrcom(paclieentity.getClrcom());
        paclieentitytoupdate.setCldcre(paclieentity.getCldcre());
        paclieentitytoupdate.setClfjur(paclieentity.getClfjur());

        return paclierepository.save(paclieentitytoupdate);
    }

    @Override
    public PaclieEntity deletePaclie(@NonNull String user, @NonNull String token, @NonNull String id) {
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

        PaclieEntity paclieentitytodelete = paclierepository.findPaclieById(Long.parseLong(id));
        if(paclieentitytodelete==null){
            throw new Deletewithwrongid("Le clients n'existe pas dans la base");
        }

        paclierepository.deleteById(Long.parseLong(id));
        return paclieentitytodelete;
    }

    @Override
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
