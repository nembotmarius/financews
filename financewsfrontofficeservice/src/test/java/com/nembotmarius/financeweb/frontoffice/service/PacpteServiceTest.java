package com.nembotmarius.financeweb.frontoffice.service;

import com.nembotmarius.financeweb.frontoffice.repository.PacpteRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class PacpteServiceTest {

    @InjectMocks
    private PacpteServiceImpl pacpteservice;

    @Mock
    private PacpteRepository pacpterepository;



}
