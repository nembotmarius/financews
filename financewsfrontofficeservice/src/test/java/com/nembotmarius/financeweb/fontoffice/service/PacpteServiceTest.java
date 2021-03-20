package com.nembotmarius.financeweb.fontoffice.service;

import com.google.gson.Gson;
import com.nembotmarius.financeweb.fontoffice.entity.PacpteEntity;
import com.nembotmarius.financeweb.fontoffice.entity.PacpteEntity;
import com.nembotmarius.financeweb.fontoffice.repository.PacpteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.mockito.Mockito.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class PacpteServiceTest {

    @InjectMocks
    private PacpteServiceImpl pacpteservice;

    @Mock
    private PacpteRepository pacpterepository;



}
