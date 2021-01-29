package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredGet {
    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath="v2/pet";
    }
    @Test
    public void getPet(){
        given().accept(ContentType.JSON)
                .when().get("2")
                .then().contentType(ContentType.JSON).statusCode(200).log().body(false);
    }
    @Test
    public void getPet2(){
        given().accept(ContentType.JSON)
                .when().get("{id}",2)
                .then().contentType(ContentType.JSON).statusCode(200).log().body(false);
    }
    @Test
    public void getPet3(){
        given().accept(ContentType.JSON)
                .when().request("Get","2")
                .then().contentType(ContentType.JSON).statusCode(200).log().body(false);
    }
    @Test
    public void getPet4(){
        given().accept(ContentType.JSON)
                .when().request("Get","{id}",2)
                .then().contentType(ContentType.JSON).statusCode(200).log().body(false);
    }
}
