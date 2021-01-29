package API.RestAssured;

import Utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;//* wild card

public class RestAssureAdvancedDeserialization {
    @Test
    public void adv1(){
        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "v2/competitions/2000/scorers";
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("X-Auth-Token", ConfigReader.getProperty("X-Auth-Token"))
                .build();
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
        Response response = given().spec(requestSpecification)
                .when().get()
                .then().spec(responseSpecification)
                .extract().response();
        Map<?,?> map= response.as(Map.class);
        Object count = map.get("count");
        System.out.println(count);

    }
}
