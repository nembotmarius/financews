package com.nembotmarius.financeweb.security.service;

import com.google.gson.Gson;
import com.nembotmarius.financeweb.security.entity.ScuserEntity;
import com.nembotmarius.financeweb.security.exception.AuthenticationFail;
import com.nembotmarius.financeweb.security.repository.ScsessRepository;
import com.nembotmarius.financeweb.security.repository.ScuserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class SecurityServiceTest {

    @InjectMocks
    private SecurityServiceImpl securityservice;

    @Mock
    private ScsessRepository scsessrepository;

    @Mock
    private ScuserRepository scuserrepository;

    @Test
    public void testAuthenticate(){
        //Appel de la methode authentifier du service
        //Test si la fonction save a été appelé au moins une fois
        ScuserEntity scuserentitycreated = initScUserJsonString();
        when(scuserrepository.findScuserByUsmatr("su")).thenReturn(scuserentitycreated);
        securityservice.authentifier("su","24c28597a41e312e3cdf2c1d8fe1ae0d");
        verify(scsessrepository,times(1)).save(any());
    }

    @Test(expected = AuthenticationFail.class)
    public void testAuthenticatewhenwronguser(){
        //Appel de la methode authentifier du service
        //Test si la fonction save a été appelé au moins une fois
        ScuserEntity scuserentitycreated = initScUserJsonString();
        when(scuserrepository.findScuserByUsmatr("su")).thenReturn(scuserentitycreated);
        securityservice.authentifier("su1","24c28597a41e312e3cdf2c1d8fe1ae0d");
    }

    @Test(expected = AuthenticationFail.class)
    public void testAuthenticatewhenemptyuserortoken(){
        //Appel de la methode authentifier du service
        //Test si la fonction save a été appelé au moins une fois
        ScuserEntity scuserentitycreated = initScUserJsonString();
        when(scuserrepository.findScuserByUsmatr("su")).thenReturn(scuserentitycreated);
        securityservice.authentifier("","24c28597a41e312e3cdf2c1d8fe1ae0d");
    }

    public ScuserEntity initScUserJsonString(){
        Gson gson=new Gson();
        String jsonString = "{\n" +
                "    \"usauto\": 0,\n" +
                "    \"acauto\": 1,\n" +
                "    \"usmatr\": \"su\",\n" +
                "    \"usnomp\": \"super admin\",\n" +
                "    \"uspass\": \"24c28597a41e312e3cdf2c1d8fe1ae0d\"\n" +
                "}";

        ScuserEntity scuserentitycreated = gson.fromJson(jsonString,ScuserEntity.class);
        return scuserentitycreated;
    }
}
