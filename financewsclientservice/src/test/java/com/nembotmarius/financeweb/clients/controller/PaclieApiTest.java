package com.nembotmarius.financeweb.clients.controller;


import com.nembotmarius.financeweb.clients.service.PaclieServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Optional.empty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(PaclieApiImpl.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PaclieApiTest {
    private static final String TEST_STATUS_API = "/status";
    private static final String GET_CUSTOMER = "/getpacliebyid/";
    private static final String GET_ALL_CUSTOMER = "/getallpaclie";
    private static final String CREATE_CUSTOMER = "/insertpaclie";
    private static final String PUT_CUSTOMER = "/updatepaclie/";


    @Autowired
    private MockMvc mvc;

    @MockBean
    private PaclieServiceImpl service;

    @Test
    public void testStatusServiceIfWorking() throws Exception {
        //Inserer une route clients_backend/status

        MockHttpServletResponse response = mvc.perform(get(TEST_STATUS_API)
                .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus(),is(HttpStatus.OK.value()));
    }

    @Test
    public void testStatusServiceIfWrongapi() throws Exception {
        //Inserer une route clients_backend/status

        MockHttpServletResponse response = mvc.perform(get("/wrong/api")
                .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus(),is(HttpStatus.NOT_FOUND.value()));
    }


    @Test
    public void testGetCustomer() throws Exception {
        //Inserer une route customerservices/addcustomer

        String paclieid = "6888";
        MockHttpServletResponse response = mvc.perform(
                post(GET_CUSTOMER + paclieid)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(empty())))
                .andReturn().getResponse();

        assertThat(response.getStatus(),is(HttpStatus.OK.value()));
    }

    @Test
    public void testGetAllCustomer() throws Exception {
        //Inserer une route customerservices/addcustomer

        MockHttpServletResponse response = mvc.perform(
                post(GET_ALL_CUSTOMER)
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

}
