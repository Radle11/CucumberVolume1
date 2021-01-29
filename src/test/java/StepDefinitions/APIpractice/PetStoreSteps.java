package StepDefinitions.APIpractice;

import Utils.PayLoadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

public class PetStoreSteps {
    HttpPost post;
    HttpClient client;
    URIBuilder uriBuilder;
    HttpResponse response;
    int id=0;
    String name="";
    String status="";
    Map<String,Object> des;
    ObjectMapper mapper;
    @Given("the end point")
    public void the_end_point() {
         client = HttpClientBuilder.create().build();
         uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");
    }

    @When("user sends a POST request with {string},{string},{string}")
    public void user_sends_a_POST_request_with(String id, String name, String status) throws URISyntaxException, IOException {
        System.out.println("Post");
        this.id=Integer.parseInt(id);
        this.name=name;
        this.status=status;
        post = new HttpPost(uriBuilder.build());
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept", "application/json");
        HttpEntity entity = new StringEntity(PayLoadUtils.getPetPayLoad(this.id,this.name,this.status));
        post.setEntity(entity);
        response = client.execute(post);


    }

    @Then("the status codes is OK")
    public void the_status_codes_is_OK() {
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json", response.getEntity().getContentType().getValue());
    }

    @Then("pet is created")
    public void pet_is_created() throws IOException {
        mapper=new ObjectMapper();
        des=mapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>(){});
        Assert.assertEquals(des.get("id"),this.id);
        Assert.assertEquals(des.get("name"),this.name);
        Assert.assertEquals(des.get("status"),this.status);
    }
    @When("user sends a GET request")
    public void user_sends_a_GET_request() throws IOException, URISyntaxException {
        uriBuilder.setPath("v2/pet/"+id);
        System.out.println("Get");
        HttpGet get=new HttpGet(uriBuilder.build());
        response=client.execute(get);
    }

    @Then("validate pet's info")
    public void validate_pet_s_info() throws IOException {
        des=mapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>(){});
        Assert.assertEquals(des.get("id"),this.id);
        Assert.assertEquals(des.get("name"),this.name);
        Assert.assertEquals(des.get("status"),this.status);
    }

    @When("user sends  a DELETE request")
    public void user_sends_a_DELETE_request() throws IOException, URISyntaxException {
        System.out.println("Delete");
        HttpDelete delete=new HttpDelete(uriBuilder.build());
        response=client.execute(delete);
    }

    @Then("validate if pet's info is deleted")
    public void validate_if_pet_s_info_is_deleted() throws IOException {
        des=mapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>(){});
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(des.get("id"),null);
        softAssert.assertEquals(des.get("name"),null);
        softAssert.assertEquals(des.get("status"),null);
        softAssert.assertAll("Validation of deleted pet info");
    }
}
