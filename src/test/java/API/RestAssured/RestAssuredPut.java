package API.RestAssured;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredPut {
    @Test
    public void updatePet1(){
        File file =new File("target\\pet.json");
        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(file)
                .when().put("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body(ResAssuredPost.NAME, Matchers.is("Hatiko"))
                .and().body(ResAssuredPost.STATUS, Matchers.equalTo("waiting")).log().body();
    }
    @Test
    public void updatePet2(){
        Map<String,Object> petPayload=new HashMap<>();
        petPayload.put(ResAssuredPost.NAME,"Bobik");
        petPayload.put("age",5);
        petPayload.put(ResAssuredPost.STATUS,"dead");
        petPayload.put(ResAssuredPost.ID,1956);
        petPayload.put("photoUrls",new String[]{"blabla.com","pitbul.com","kandek.gov"});
        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(petPayload)
                .when().put("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200).contentType(ContentType.JSON)
                .and().body(ResAssuredPost.NAME, Matchers.is(petPayload.get(ResAssuredPost.NAME)))
                .and().body(ResAssuredPost.STATUS, Matchers.equalTo(petPayload.get(ResAssuredPost.STATUS))).log().body();
    }

}
