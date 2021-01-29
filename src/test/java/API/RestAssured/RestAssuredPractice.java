package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredPractice {
    @Test
    public void get1(){
       given().header("accept", ContentType.JSON).when().get("https://breakingbadapi.com/api/characters/50")
                .then().log().ifValidationFails().assertThat().statusCode(200).and().contentType(ContentType.JSON)
               .body("[0].name", Matchers.equalToIgnoringCase("juan bolsa"))
               .and().body("[0].occupation",Matchers.hasSize(1));
    }
    @Test
    public void get3(){
        given().header("accept", ContentType.JSON).when().get("https://breakingbadapi.com/api/characters/50")
                .then().log().ifValidationFails().assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .body("[0].nickname",Matchers.containsString("Juan"))
                .body("[0].status", Matchers.equalToIgnoringCase("Deceased"))
                .and().body("[0].appearance.size",Matchers.greaterThan(1))
                .and().body("[0].appearance[1]",Matchers.is(4));
    }
    @Test
    public void get2(){
        Map<String,Object> dsBB=given().header("accept", ContentType.JSON).when().get("https://breakingbadapi.com/api/characters/50")
                .getBody().as(new TypeRef<Map<String, Object>>() {});
    }
    @Test
    public void get4(){
        RestAssured.baseURI="https://api.got.show";
        RestAssured.basePath="api/map/characters/byId/5cc0743504e71a0010b852d9";
        given().header("accept", ContentType.JSON).when().get()
                .then().log().ifValidationFails().assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .rootPath("data")
                .body("books",Matchers.hasItem("A Storm of Swords"))
                .body("dateOfBirth",Matchers.equalTo(283))

        ;}


}
