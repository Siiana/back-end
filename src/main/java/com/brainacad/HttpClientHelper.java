package com.brainacad;

import io.qameta.allure.Step;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static org.apache.http.protocol.HTTP.USER_AGENT;


public class HttpClientHelper {

    private static Map<String, String> headers = new HashMap<>();
    static {
        headers.put("Content-Type", "application/json");
    }

    //REST GET запрос
    @Step
     public static HttpResponse get(String endpointUrl, String parameters) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(endpointUrl + "?" + parameters);
        for (String headerKey : headers.keySet()) {
            request.addHeader(headerKey, headers.get(headerKey));
        }
        HttpResponse response = client.execute(request);
        return response;
    }

    //REST POST запрос
    @Step
    public static HttpResponse post(String endpointUrl, String body) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(endpointUrl);
        for (String headerKey : headers.keySet()) {
            post.addHeader(headerKey, headers.get(headerKey));
        }
        post.setEntity(new StringEntity(body));
        HttpResponse response = client.execute(post);
        return response;
    }

    //REST PUT запрос
    @Step
    public static HttpResponse put(String endpointUrl, String body) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPut put = new HttpPut(endpointUrl);
        for (String headerKey : headers.keySet()) {
            put.addHeader(headerKey, headers.get(headerKey));
        }
        put.setEntity(new StringEntity(body));
        HttpResponse response = client.execute(put);
        return response;
    }

    //REST PATCH запрос
    @Step
    public static HttpResponse patch(String endpointUrl, String body) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPatch patch = new HttpPatch(endpointUrl);
        for (String headerKey : headers.keySet()) {
            patch.addHeader(headerKey, headers.get(headerKey));
        }
        patch.setEntity(new StringEntity(body));
        HttpResponse response = client.execute(patch);
        return response;
    }

    //REST DELETE запрос
    @Step
    public static HttpResponse delete(String endpointUrl) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpDelete delete = new HttpDelete(endpointUrl);
        for (String headerKey : headers.keySet()) {
            delete.addHeader(headerKey, headers.get(headerKey));
        }
        HttpResponse response = client.execute(delete);
        return response;
    }



    @Step("test 2 {0}")
    public static String getBodyFromResponse(HttpResponse response) throws IOException {
        //создаём ридер буффера и передаём в него входящий поток респонса
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line;

        //получаем в цикле построчно строки из входящего потока и собираем в одну строку
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }


    //TODO: допишите методы для запросов PUT, PATCH и DELETE
}
