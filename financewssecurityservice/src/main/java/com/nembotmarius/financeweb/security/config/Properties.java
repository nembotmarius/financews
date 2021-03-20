package com.nembotmarius.financeweb.security.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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