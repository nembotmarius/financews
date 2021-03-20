package com.nembotmarius.financeweb.security.service;

import com.nembotmarius.financeweb.security.model.Froujo;

public interface SecurityService {
    String authentifier(String user, String token);
    Froujo authentifiercode(String user, String token, String code);
}

