package com.nembotmarius.financeweb.frontoffice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class Properties{

    // passing the key which you set in application.properties
    @Value("${userdata.timeout}")
    private String userTimeout;

    // getting the value from that key which you set in application.properties
    @Bean
    public String getUserTimeout() {
        return userTimeout;
    }
}