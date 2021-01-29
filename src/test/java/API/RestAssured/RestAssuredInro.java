package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredInro {
    @Test
    public void rest1(){
        given().header("contentType",ContentType.JSON).header("accept",ContentType.JSON)
        .when().get("https://swapi.dev/api/planets/1").then().statusCode(200).and().contentType(ContentType.JSON);


    }
    @Test
    public void rest2(){
        given().header("accept",ContentType.JSON)
                .when().get("https://swapi.dev/api/planets/1").then().statusCode(200).and().contentType(ContentType.JSON).and()
                .assertThat().body("name",equalTo("Tatooine"));


    }
    @Test
    public void rest3(){
        given().header("accept",ContentType.JSON)
                .when().get("https://swapi.dev/api/planets/1").then().statusCode(200).and().contentType(ContentType.JSON).and()
                .assertThat().body("population",equalTo("200000"));


    }
    @Test
    public void rest4(){
        given().header("accept",ContentType.JSON)
                .when().get("https://swapi.dev/api/planets").then().log().all().assertThat().statusCode(200).contentType(ContentType.JSON).and()
                .body("results[0].gravity", Matchers.is("1 standard")).body("results[0].terrain",Matchers.isA(String.class));


    }
}
