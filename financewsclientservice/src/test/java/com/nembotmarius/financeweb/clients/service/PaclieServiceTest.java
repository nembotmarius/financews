package com.nembotmarius.financeweb.clients.service;

import com.google.gson.Gson;
import com.nembotmarius.financeweb.clients.entity.PaclieEntity;
import com.nembotmarius.financeweb.clients.exception.Deletewithwrongid;
import com.nembotmarius.financeweb.clients.exception.NotFoundException;
import com.nembotmarius.financeweb.clients.exception.PaclieUpdatewithwrongPaclieid;
import com.nembotmarius.financeweb.clients.repository.PaclieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.mockito.Mockito.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class PaclieServiceTest {

    @InjectMocks
    private PaclieServiceImpl paclieservice;

    @Mock
    private PaclieRepository paclierepository;

    @Test
    public void testCreateNewMovie(){
        //Appel de la methode createMovie du service
        //Test si la fonction save a été appelé au moins une fois
        PaclieEntity paclieentitycreated = initPaclieJsonString();
        paclieservice.insertPaclie("su","DFB978642404612A83050D0DF185E911",paclieentitycreated);
        verify(paclierepository,times(1)).save(any());
    }

    @Test
    public void testGetPacliewithFoundMovie(){
        //definissons un clients a trouvé dans la bd
        //appeller la methode
        PaclieEntity paclieentitycreated = initPaclieJsonString();
        paclieentitycreated.setClauto(1818);
        when(paclierepository.findPaclieById(1818)).thenReturn(paclieentitycreated);
        PaclieEntity paclieentity = paclieservice.getPaclieById("su","DFB978642404612A83050D0DF185E911","1818");
        assertThat(paclieentity.getClauto(), is(Long.parseLong("1818")));
    }

    @Test(expected = NotFoundException.class)
    public void testGetPacliewithNotFoundMovie(){
        when(paclierepository.findPaclieById(343211)).thenReturn(null);
        paclieservice.getPaclieById("su","DFB978642404612A83050D0DF185E911","343211");
    }

    @Test(expected = PaclieUpdatewithwrongPaclieid.class)
    public void testUpdatePaclieWhenPaclieIdisnonNumeric(){
        //Fais un appel de la methode updatePaclie de paclie service
        //Le systeme doit generer une exception de type PaclieUpdatewithwrongPaclieid
        PaclieEntity paclieentitytoupdate = initPaclieJsonString();
        paclieentitytoupdate.setClauto(-22334);
        paclieservice.updatePaclie("su","DFB978642404612A83050D0DF185E911","wrong id",paclieentitytoupdate);
    }

    @Test(expected = PaclieUpdatewithwrongPaclieid.class)
    public void testUpdatePaclieWhenPaclieIdisdifferents(){
        //Fais un appel de la methode updatePaclie de paclie service
        //Le systeme doit generer une exception de type PaclieUpdatewithwrongPaclieid
        PaclieEntity paclieentitytoupdate = initPaclieJsonString();
        paclieentitytoupdate.setClauto(-22334);
        paclieservice.updatePaclie("su","DFB978642404612A83050D0DF185E911","16095",paclieentitytoupdate);
    }

    @Test
    public void testUpdatePaclie(){
        //Fais un appel de la methode updatePaclie de paclie service
        //Le systeme doit generer une exception de type PaclieUpdatewithwrongPaclieid
        PaclieEntity paclieentitytoupdate = initPaclieJsonString();
        paclieentitytoupdate.setClauto(1818);
        when(paclierepository.findPaclieById(1818)).thenReturn(paclieentitytoupdate);
        paclieservice.updatePaclie("su","DFB978642404612A83050D0DF185E911","1818",paclieentitytoupdate);
        verify(paclierepository,times(1)).save(any());
    }


    @Test(expected = Deletewithwrongid.class)
    public void testDeletePaclieWhenPaclieisNotExist(){
        //Fais un appel de la methode updatePaclie de paclie service
        //Le systeme doit generer une exception de type PaclieUpdatewithwrongPaclieid
        PaclieEntity paclieentitytodelete = initPaclieJsonString();
        paclieentitytodelete.setClauto(22334);
        when(paclierepository.findPaclieById(22334)).thenReturn(null);
        paclieservice.deletePaclie("su","DFB978642404612A83050D0DF185E911","22334");
    }

    @Test
    public void testDeletePaclie(){
        //Fais un appel de la methode updatePaclie de paclie service
        //Le systeme doit generer une exception de type PaclieUpdatewithwrongPaclieid
        PaclieEntity paclieentitytodelete = initPaclieJsonString();
        paclieentitytodelete.setClauto(1818);
        when(paclierepository.findPaclieById(1818)).thenReturn(paclieentitytodelete);
        paclieservice.deletePaclie("su","DFB978642404612A83050D0DF185E911","1818");
        verify(paclierepository,times(1)).deleteById(any());
    }


    public PaclieEntity initPaclieJsonString(){
        Gson gson=new Gson();
        String jsonString = "{\n" +
                "    \"claut2\": 0,\n" +
                "    \"stauto\": 1,\n" +
                "    \"clclez\": 250888,\n" +
                "    \"clnomc\": \"SUNDJATA KEITA\",\n" +
                "    \"cldana\": 0,\n" +
                "    \"cllieu\": \"\",\n" +
                "    \"clprof\": \"\",\n" +
                "    \"clcnic\": \"114604731 DU 10/12/13 A LT 16\",\n" +
                "    \"cladre\": \"\",\n" +
                "    \"clsitm\": \"\",\n" +
                "    \"cltel1\": 699201915,\n" +
                "    \"cltel2\": 0,\n" +
                "    \"clmail\": \"\",\n" +
                "    \"clquar\": \"\",\n" +
                "    \"clphot\": 0,\n" +
                "    \"clsign\": 0,\n" +
                "    \"clplan\": 0,\n" +
                "    \"clcose\": 0,\n" +
                "    \"clacti\": 0,\n" +
                "    \"cldacr\": 0,\n" +
                "    \"clusup\": 0,\n" +
                "    \"cldaup\": 0,\n" +
                "    \"clnoup\": 0,\n" +
                "    \"cldele\": 0,\n" +
                "    \"clusde\": 0,\n" +
                "    \"cltitr\": \"\",\n" +
                "    \"clnati\": \"\",\n" +
                "    \"clmodi\": \"\",\n" +
                "    \"clpcon\": \"\",\n" +
                "    \"cltelp\": \"\",\n" +
                "    \"clncom\": \"\",\n" +
                "    \"cltypa\": \"\",\n" +
                "    \"clrcom\": \"\",\n" +
                "    \"cldcre\": \"\",\n" +
                "    \"clfjur\": \"\"\n" +
                "}";
        PaclieEntity paclieentitycreated = gson.fromJson(jsonString,PaclieEntity.class);
        return paclieentitycreated;
    }
}
