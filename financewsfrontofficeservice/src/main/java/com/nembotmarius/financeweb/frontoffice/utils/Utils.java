package com.nembotmarius.financeweb.frontoffice.utils;

import lombok.RequiredArgsConstructor;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
public class Utils {
    public boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public long getCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        LocalDateTime now = LocalDateTime.now();
        return Long.parseLong(dtf.format(now));
    }

    public long getCurrentDate2(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();
        return Long.parseLong(dtf.format(now));
    }

    public String getCurrentDateStr(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String convertDateintToStr(long intdate){
        String strdate = String.valueOf(intdate);
        String result = strdate.substring(6, 8) + "/" + strdate.substring(4, 6) + "/" + strdate.substring(0, 4) + " " + strdate.substring(8, 10) + ":" + strdate.substring(10, 12);
        return result;
    }

    public boolean sendSms(String login,String password,String sender_id,String destinataire,String message) {
        URIBuilder builder = new URIBuilder()
                .setScheme("https")
                .setHost("sms.etech-keys.com")
                .setPath("/ss/api.php")
                .addParameter("login", login)
                .addParameter("password", password)
                .addParameter("sender_id", sender_id)
                .addParameter("destinataire", destinataire)
                .addParameter("message", message);
        String uri = builder.toString();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
