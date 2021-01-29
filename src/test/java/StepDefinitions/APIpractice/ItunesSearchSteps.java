package StepDefinitions.APIpractice;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

import java.io.IOException;
import java.net.URISyntaxException;

public class ItunesSearchSteps {
    //https://music.apple.com/us/search?=green%20day
    HttpResponse response;
    @Given("endpoint with query parameter {string}")
    public void endpoint_with_query_parameter(String artist) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https").setHost("music.apple.com").setPath("us/search").setCustomQuery(artist.replaceAll(" ","%20"));

        HttpGet get = new HttpGet(uri.build());
        response = client.execute(get);
    }

    @Then("validate correct status code")
    public void validate_correct_status_code() {
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        Assert.assertEquals("text/html; charset=utf-8",response.getEntity().getContentType().getValue());
    }
}
