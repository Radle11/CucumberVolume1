package StepDefinitions;

import API.POJO.Petstore.PetPojo;
import API.POJO.Reqres.ReqresPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class PetStoreSteps {
    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    Response response;
    @Given("a header accept type is {string}")
    public void a_header_content_type_is(String format) {
         requestSpecification=given().header("accept", format);
    }

    @When("make a GET request to endpoint")
    public void make_a_GET_request_to_endpoint() {
         response = requestSpecification.when().get("https://petstore.swagger.io/v2/pet/10");
    }

    @Then("validate status code is {int}, content type is {string}")
    public void validate_status_code_is_OK_content_type_is(int statusCode,String contentType) {
         validatableResponse = response.then().log().all().statusCode(statusCode).and().contentType(contentType);
    }

    @Then("deserialize the reponse")
    public void deserialize_the_reponse() {
        PetPojo deserilization = validatableResponse.extract().as(PetPojo.class);
        Assert.assertEquals(deserilization.getName(),"doggie");
        Assert.assertEquals(deserilization.getCategory().getName(),"6tJJK7eDZ4QCOJS_");
    }

}
