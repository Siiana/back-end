package com.brainacad;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;


public class RestTest{

    private static final String URL="https://reqres.in/";

    @Test//GET метод
    public void checkGetResponseStatusCode() throws IOException {
        String endpoint="/api/users";
        HttpResponse response = HttpClientHelper.get(URL+endpoint,"page=2");
        String body=HttpClientHelper.getBodyFromResponse(response);
        int id = JsonUtils.intFromJSONByPath(body,"$.data[0].id" );
        int size = JsonUtils.intFromJSONByPath(body,"$.data.size()" );
        int perPage = JsonUtils.intFromJSONByPath(body,"$.per_page" );
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200",200,statusCode);
        Assert.assertEquals("id should be 7", 7, id);
        Assert.assertEquals("perPage=size=6", perPage, size);
    }

    @Test//GET метод
    public void checkGetResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";
        HttpResponse response = HttpClientHelper.get(URL+endpoint,"page=2");
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test//POST метод
    public void checkPostResponseStatusCode() throws IOException {
        String endpoint="/api/users";
        String requestBody="{\"name\": \"morpheus\",\"job\": \"leader\"}";
        HttpResponse response = HttpClientHelper.post(URL+endpoint,requestBody);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 201", 201, statusCode);
    }

    @Test//POST метод
    public void checkPostResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";
        String requestBody="{\"name\": \"morpheus\",\"job\": \"leader\"}";
        HttpResponse response = HttpClientHelper.post(URL+endpoint,requestBody);
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test//PUT метод
    public void checkPutResponseStatusCode() throws IOException {
        String endpoint="/api/users";
        String requestBody="{\"name\": \"morpheus\",\"job\": \"resident\"}";
        HttpResponse response = HttpClientHelper.put(URL+endpoint,requestBody);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 200, statusCode);
    }

    @Test//PUT метод
    public void checkPutResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";
        String requestBody="{\"name\": \"morpheus\",\"job\": \"resident\"}";
        HttpResponse response = HttpClientHelper.put(URL+endpoint,requestBody);
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test//PATCH метод
    public void checkPatchResponseStatusCode() throws IOException {
        String endpoint="/api/users";
        String requestBody="{\"name\": \"morpheus\",\"job\": \"resident\"}";
        HttpResponse response = HttpClientHelper.patch(URL+endpoint,requestBody);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 200, statusCode);
    }

    @Test//PATCH метод
    public void checkPatchResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";
        String requestBody="{\"name\": \"morpheus\",\"job\": \"resident\"}";
        HttpResponse response = HttpClientHelper.patch(URL+endpoint,requestBody);
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test//Delete метод
    public void checkDeleteResponseStatusCode() throws IOException {
        String endpoint="/api/users/2";
        HttpResponse response = HttpClientHelper.delete(URL+endpoint);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 204", 204, statusCode);
    }

    //TODO: напишите по тесткейсу на каждый вариант запроса на сайте https://reqres.in
    //TODO: в тескейсах проверьте Result Code и несколько параметров из JSON ответа (если он есть)

}
