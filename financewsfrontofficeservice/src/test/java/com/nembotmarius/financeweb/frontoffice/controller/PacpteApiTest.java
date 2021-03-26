package com.nembotmarius.financeweb.frontoffice.controller;


import com.nembotmarius.financeweb.frontoffice.service.PacpteServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Optional.empty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(PacpteApiImpl.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PacpteApiTest {
    private static final String GET_SOLDEBYCPAUTO = "/getsoldebyid/";
    private static final String TOKEN = "c1758dff-5dfc-4235-a35b-201335e769a1";


    @Autowired
    private MockMvc mvc;

    @MockBean
    private PacpteServiceImpl service;

    @Test
    public void testGetCollectebyday() throws Exception {
        //Inserer une route customerservices/addcustomer

        String cpauto = "1556";
        HttpHeaders header= new HttpHeaders();
        header.add("user","su");
        header.add("token",TOKEN);
        MockHttpServletResponse response = mvc.perform(
                post(GET_SOLDEBYCPAUTO + cpauto)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(header)
                        .content(String.valueOf(empty())))
                .andReturn().getResponse();

        assertThat(response.getStatus(),is(HttpStatus.OK.value()));
    }

}
