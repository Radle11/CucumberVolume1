package API.RestAssured;

import API.POJO.Petstore.PetPojo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.ws.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ResAssuredPost {//3 ways to create POST request
    public static final String NAME="name";//constant
    public static final String STATUS="status";
    public static final String ID="id";
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    ValidatableResponseOptions validatableResponseOptions;
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath="v2/pet";
         requestSpecification=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
         responseSpecification=new ResponseSpecBuilder()
                 .expectStatusCode(200)
                 .expectContentType(ContentType.JSON)
                 .build();


    }

    @Test
    public void createPet() {//(json file)
        File path = new File("target\\pet.json");
                given().spec(requestSpecification).body(path)
                .when().post()
                .then().log().all().spec(responseSpecification)
                .body(NAME, Matchers.equalTo("Hatiko"))
                .and().body(STATUS, Matchers.is("waiting"));
    }

    @Test
    public void createPet2() {//(Java object(Pojo.class)
        PetPojo petPojo = new PetPojo("Hatiko", "Gone", 1011);
            given().spec(requestSpecification).body(petPojo)
                .when().post()
                .then().log().body().spec(responseSpecification)
                .body(NAME, Matchers.equalTo(petPojo.getName()))
                .and().body(STATUS, Matchers.is(petPojo.getStatus()))
                .and().body(ID, Matchers.is(petPojo.getId()));
    }
    @Test
    public void createPet3() {//Java generics(Map)
        Map<String,Object> petPayload=new HashMap<>();
        petPayload.put(NAME,"Hatiko");
        petPayload.put("age",7);
        petPayload.put(STATUS,"dead");
        petPayload.put(ID,1010);
        petPayload.put("photoUrls",new String[]{"blabla.com"});
        given().spec(requestSpecification).body(petPayload)
                .when().post()
                .then().log().body().spec(responseSpecification)
                .body(NAME, Matchers.equalTo(petPayload.get(NAME)))
                .and().body(STATUS, Matchers.is(petPayload.get(STATUS)))
                .and().body(ID, Matchers.is(petPayload.get(ID)));
    }



}