package com.nembotmarius.financeweb.clients.controller;


import com.nembotmarius.financeweb.clients.service.AntranServiceImpl;
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


@WebMvcTest(AntranApiImpl.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AntranApiTest {
    private static final String POST_INSERT_COLLECTE = "/insertcollecte";
    private static final String POST_DELETE_COLLECTE = "/deletecollecte/";
    private static final String PUT_UPDATE_COLLECTE = "/updatecollecte/";
    private static final String GET_ANTRAN_BYID = "/getantranbyid/";
    private static final String GET_ANTRAN_BYDAY = "/getallcollectebyday/";
    private static final String TOKEN = "0400fac9-29f2-4f9f-955d-a29d287e95b7";


    @Autowired
    private MockMvc mvc;

    @MockBean
    private AntranServiceImpl service;

    @Test
    public void testGetCollectebyid() throws Exception {
        //Inserer une route customerservices/addcustomer

        String antranid = "2";
        HttpHeaders header= new HttpHeaders();
        header.add("user","su");
        header.add("token",TOKEN);
        MockHttpServletResponse response = mvc.perform(
                post(GET_ANTRAN_BYID + antranid)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(header)
                        .content(String.valueOf(empty())))
                .andReturn().getResponse();

        assertThat(response.getStatus(),is(HttpStatus.OK.value()));
    }

    @Test
    public void testGetCollectebyday() throws Exception {
        //Inserer une route customerservices/addcustomer

        String dayid = "14799";
        HttpHeaders header= new HttpHeaders();
        header.add("user","su");
        header.add("token",TOKEN);
        MockHttpServletResponse response = mvc.perform(
                post(GET_ANTRAN_BYDAY + dayid)
                        .contentType(MediaType.APPLICATION_JSON)
                        .headers(header)
                        .content(String.valueOf(empty())))
                .andReturn().getResponse();

        assertThat(response.getStatus(),is(HttpStatus.OK.value()));
    }


    /*
    @Test
    public void testGetAllCustomer() throws Exception {
        //Inserer une route customerservices/addcustomer

        MockHttpServletResponse response = mvc.perform(
                get(GET_ALL_CUSTOMER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(empty())))
                .andReturn().getResponse();

        assertThat(response.getStatus(),is(HttpStatus.OK.value()));
    }


    @Test
    public void testInsertpaclie() throws Exception {
        //Inserer une route customerservices/addcustomer

        MockHttpServletResponse response = mvc.perform(
                post(CREATE_CUSTOMER)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"claut2\": 13792,\n" +
                        "    \"stauto\": 1,\n" +
                        "    \"clclez\": 220055,\n" +
                        "    \"clnomc\": \"CECI EST UN TEST CREATE\",\n" +
                        "    \"cldana\": 0,\n" +
                        "    \"cllieu\": \"\",\n" +
                        "    \"clprof\": \"\",\n" +
                        "    \"clcnic\": \"1101484050\",\n" +
                        "    \"cladre\": \"\",\n" +
                        "    \"clsitm\": \"\",\n" +
                        "    \"cltel1\": 0,\n" +
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
                        "}"))
                .andReturn().getResponse();

        assertThat(response.getStatus(),is(HttpStatus.CREATED.value()));
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        //Inserer une route customerservices/addcustomer

        MockHttpServletResponse response = mvc.perform(
                put(PUT_CUSTOMER + "16095")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"clauto\": 16095,\n" +
                                "    \"claut2\": 13792,\n" +
                                "    \"stauto\": 1,\n" +
                                "    \"clclez\": 220055,\n" +
                                "    \"clnomc\": \"CECI EST UN TEST CREATE ET MISE A JOUR\",\n" +
                                "    \"cldana\": 0,\n" +
                                "    \"cllieu\": \"\",\n" +
                                "    \"clprof\": \"\",\n" +
                                "    \"clcnic\": \"1101484050\",\n" +
                                "    \"cladre\": \"\",\n" +
                                "    \"clsitm\": \"\",\n" +
                                "    \"cltel1\": 0,\n" +
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
                                "}"))
                .andReturn().getResponse();

        assertThat(response.getStatus(),is(HttpStatus.OK.value()));
    }
*/
}
