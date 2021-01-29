package API.RestAssured;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredDelete {
    @Test
    public void deletePet(){
        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().delete("https://petstore.swagger.io/v2/pet/1")
                .then().contentType(ContentType.JSON).statusCode(200).log().body(true);
    }
}
