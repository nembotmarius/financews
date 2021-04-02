package com.nembotmarius.financeweb.frontoffice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class Properties{

    // passing the key which you set in application.properties
    @Value("${userdata.timeout}")
    private String userTimeout;

    @Value("${userdata.smslogin}")
    private String smslogin;

    @Value("${userdata.smspassword}")
    private String smspassword;

    @Value("${userdata.smssenderid}")
    private String smssenderid;

    // getting the value from that key which you set in application.properties
    @Bean
    public String getUserTimeout() {
        return userTimeout;
    }
}