package com.nembotmarius.financeweb.security.controller;

import com.nembotmarius.financeweb.security.service.SecurityServiceImpl;
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


@WebMvcTest(SecurityApiImpl.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SecurityApiTest {
    private static final String TEST_STATUS_API = "/status";
    private static final String POST_AUTH = "/auth/";


    @Autowired
    private MockMvc mvc;

    @MockBean
    private SecurityServiceImpl service;

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
}
