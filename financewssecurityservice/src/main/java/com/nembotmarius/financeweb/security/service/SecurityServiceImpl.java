package com.nembotmarius.financeweb.security.service;

import com.nembotmarius.financeweb.security.entity.FroujoEntity;
import com.nembotmarius.financeweb.security.entity.ParegiEntity;
import com.nembotmarius.financeweb.security.entity.ScsessEntity;
import com.nembotmarius.financeweb.security.entity.ScuserEntity;
import com.nembotmarius.financeweb.security.exception.AuthenticationFail;
import com.nembotmarius.financeweb.security.model.Froujo;
import com.nembotmarius.financeweb.security.repository.FroujoRepository;
import com.nembotmarius.financeweb.security.repository.ParegiRepository;
import com.nembotmarius.financeweb.security.repository.ScsessRepository;
import com.nembotmarius.financeweb.security.repository.ScuserRepository;
import com.nembotmarius.financeweb.security.utils.Outils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService{
    private final ScuserRepository scuserrepository;
    private final ScsessRepository scsessrepository;
    private final FroujoRepository froujorepository;
    private final ParegiRepository paregirepository;

    @Override
    public String authentifier(String user, String token) {

        //verifie que le user n'est pas null ou vide
        if(user.equals("") || token.equals("")){
            throw new AuthenticationFail("Information d'identification incorrecte");
        }
        //verifie que l'utilisateur existe bien dans la BD
        //Si non ok Gererer une erreur
        ScuserEntity scuserentity = scuserrepository.findScuserByUsmatr(user);
        if(scuserentity==null){
            throw new AuthenticationFail("Identifiant inconnu");
        }
        //Si ok verifier que le mot de passe est correct
        //si non ok, renvoyer une erreur d'authentification
        if(!token.equals(scuserentity.getUspass())){
            throw new AuthenticationFail("Mot de passe incorrect");
        }
        //si oui créer un token
        String tokentoreturn= UUID.randomUUID().toString();
        Collection<ScsessEntity> listsession = scsessrepository.findAllUserActiveSession(scuserentity.getUsauto());
        //supprime les comptes actifs dans la bases
        Iterator<ScsessEntity> iterator = listsession.iterator();
        // while loop
        while (iterator.hasNext()) {
            ScsessEntity scsessentitytodelete = (ScsessEntity) iterator.next();
            scsessrepository.delete(scsessentitytodelete);
        }
        //sauvegarder dans la table des session scsess et retourner le token
        ScsessEntity scssesstocreate = new ScsessEntity();
        Outils o = new Outils();
        scssesstocreate.setAcauto((int) scuserentity.getAcauto());
        scssesstocreate.setSsdacr(o.getCurrentDate());
        scssesstocreate.setSsdaup(o.getCurrentDate());
        scssesstocreate.setUsauto(scuserentity.getUsauto());
        scssesstocreate.setStauto(0);
        scssesstocreate.setSsidse(tokentoreturn);
        scsessrepository.save(scssesstocreate);
        return tokentoreturn;
    }

    @Override
    public Froujo authentifiercode(String user, String token, String code) {
        //Authentifie l'utilisateur
        //verifie que le code fourni est numerique
        //verifie que le code fourni est le code du jour attribué a cet utilisateur
        //affecte le jeton dans l'object froujoentity et retourne la valeur

        Outils o = new Outils();
        if(!o.isNumeric(code)){
            throw new AuthenticationFail("Le code de la journée doit être numerique");
        }
        String tokentoreturn = this.authentifier(user, token);
        ScuserEntity scuserentity = scuserrepository.findScuserByUsmatr(user);
        if(scuserentity==null){
            throw new AuthenticationFail("Utilisateur Inconnu");
        }
        FroujoEntity froujoentity = froujorepository.findFroujoByoucode(Integer.parseInt(code), scuserentity.getUsauto());
        if(froujoentity==null){
            throw new AuthenticationFail("Accès non autorisé");
        }

        //Sauvegarde le jeton dans un champs quelquonque de l'objet et retourne l'objet
        froujoentity.setOucana(tokentoreturn);
        Froujo froujo = new Froujo();
        froujo.setEntitytoModel(froujoentity);
        froujo.setUscpte(scuserentity.getUscpte());
        froujo.setToken(tokentoreturn);

        ParegiEntity paregientity = paregirepository.findParegiByid(froujoentity.getReauto());
        if(paregientity!=null){
            froujo.setRecode(paregientity.getRecode());
            froujo.setRelibe(paregientity.getRelibe());
        }



        return froujo;
    }
}
