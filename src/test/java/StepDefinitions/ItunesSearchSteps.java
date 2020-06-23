package StepDefinitions;

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
    URIBuilder uri;
    HttpClient client;
    HttpGet get=null;
    @Given("a client")
    public void a_client() {client= HttpClientBuilder.create().build();}
    @When("specify HTTP method and endpoint")
    public void specify_HTTP_method_and_endpoint() {uri=new URIBuilder(); uri.setScheme("https").setHost("music.apple.com");}
    @Then("add path parameter")
    public void add_path_parameter() { uri.setPath("us/search");}
    @Then("add query parameter {string}")
    public void add_query_parameter(String artist) {
        if(artist.contains(" ")){uri.setCustomQuery(artist.replaceAll(" ","%20"));}
        else { uri.setCustomQuery(artist);}}
    @Then("add header parameters")
    public void add_header_parameters() {
        try {get=new HttpGet(uri.build());}
        catch (URISyntaxException e) {e.printStackTrace();}}

    @Then("execute by clicking on send button")
    public void execute_by_clicking_on_send_button() {
        HttpResponse response;
            try {response = client.execute(get);
                Assert.assertEquals(200,response.getStatusLine().getStatusCode());
//                Assert.assertEquals("application/javascript",response.getEntity().getContentType().getValue());
            }
            catch (IOException e) {e.printStackTrace();}
    }

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
