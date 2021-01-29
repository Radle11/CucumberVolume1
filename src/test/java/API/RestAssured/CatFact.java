package API.RestAssured;

import API.POJO.CatFacts.CatFactAllPojo;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.given;

public class CatFact {
    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI="http://cat-fact.herokuapp.com";
        RestAssured.basePath="facts";
    }
    @Test
    public void get25Cat(){
       Map<String,Object> responseDes= given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get()
                .then().log().ifValidationFails().statusCode(200)
                .and().contentType(ContentType.JSON)
                .extract().as(new TypeRef<Map<String,Object>>() {});
        List<Map<String,Object>> allList=(List<Map<String,Object>>) responseDes.get("all");
        Map<String,Map<String,Object>> user=(Map<String,Map<String,Object>>)allList.get(25).get("user");
        System.out.println("ID: "+user.get("_id"));
        System.out.println("Name: "+user.get("name").get("first"));
        System.out.println("Last name: "+user.get("name").get("last"));

    }
    @Test
    public void get25Cat2(){
        Response responseDes= given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get()
                .then().log().ifValidationFails().statusCode(200)
                .and().contentType(ContentType.JSON)
                .extract().response();
        CatFactAllPojo desCatFact=responseDes.as(CatFactAllPojo.class);
      Map<String,Object> name=(Map<String,Object>) desCatFact.getAll().get(25).getUser().get("name");
        System.out.println(name.get("first"));
        System.out.println(name.get("last"));
    }
}
