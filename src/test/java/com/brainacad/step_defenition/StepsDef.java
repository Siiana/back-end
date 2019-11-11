package com.brainacad.step_defenition;

import com.brainacad.HttpClientHelper;
import cucumber.api.java.en.*;
import org.apache.http.HttpResponse;
import sun.security.util.PendingException;

import java.io.IOException;
import java.net.URL;

public class StepsDef {
    private String URL;
    private HttpResponse response;


    @Given("I have server by url {string}")
    public void i_have_server_by_url(String url) {
        URL = url;
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();

    }

    @When("I send GET request on endpoint {string} and parameters {string}")
    public void i_send_GET_request_on_endpoint_and_parameters(String endpoint, String parameters)throws IOException {
        response = HttpClientHelper.get(URL+endpoint,parameters);
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("I get response status code {integer}")
    public void i_get_response_status_code(int statusCod) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @Given("^I have server by url {string}")
    public void iHaveServerByUrl(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
