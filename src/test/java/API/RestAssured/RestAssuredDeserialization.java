package API.RestAssured;

import API.POJO.BreakingBadApi.BreakingBadCharacterPojo;
import API.POJO.Reqres.ReqresPojo;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RestAssuredDeserialization {
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://breakingbadapi.com";
        RestAssured.basePath = "api/characters";
    }

    @Test
    public void restDes1() {
        List<BreakingBadCharacterPojo> des =
                given().header("accept", ContentType.JSON)
                .when().get("50")//request specifications
                .then().statusCode(200).contentType(ContentType.JSON)//assertion part
                .extract()//extracts back to request/response specifications
                .as(new TypeRef<List<BreakingBadCharacterPojo>>() {});//deserialization part/response body extraction
        Assert.assertEquals(des.get(0).getCategory(),"Breaking Bad");

    }
    @Test
    public void restDes2() {
        List<BreakingBadCharacterPojo> des = given().header("accept", ContentType.JSON)
                .when().get("35")//request specifications
                .then().log().ifValidationFails()
                .statusCode(200).contentType(ContentType.JSON)//assertion part
                .body("[0].birthday", Matchers.is("Unknown"))
                .body("[0].appearance",Matchers.hasSize(2))
                .body("[0].nickname",Matchers.containsString("Dr"))
                .extract()//extracts back to request/response specifications
                .as(new TypeRef<List<BreakingBadCharacterPojo>>() {});//deserialization part/response body extraction
        Assert.assertEquals(des.get(0).getCategory(),"Breaking Bad");
        Assert.assertEquals(des.get(0).getName(),"Dr. Delcavoli");
        Assert.assertEquals(des.get(0).getAppearance().size(),2);
        int[] exp=new int[]{1,2};
        Assert.assertEquals(des.get(0).getAppearance().toArray(),exp);

    }

    @Test
    public void restDes3() {
        ReqresPojo reqresPojoDes=given().header("accept", ContentType.JSON).when().request("Get","https://reqres.in/api/users/2")//request specifications
                .then().log().ifValidationFails()
                .statusCode(200).contentType(ContentType.JSON)//assertion part
                .extract()//extracts back to request/response specifications
                .as(ReqresPojo.class);//deserialization part/response body extraction
        Assert.assertEquals(reqresPojoDes.getData().getFirst_name(),"Janet");
        Assert.assertEquals(reqresPojoDes.getData().getEmail(),"janet.weaver@reqres.in");

    }
    @Test
    public void getUser2(){
        //prerequesite
        RequestSpecification requestSpecification=given().header("accept", ContentType.JSON);
        //action
        Response response = requestSpecification.when().get("https://reqres.in/api/users/2");
        //validation
        ValidatableResponse validatableResponse = response.then().log().all().statusCode(200).and().contentType(ContentType.JSON);
        //Deserialization
        ReqresPojo deserilization = validatableResponse.extract().as(ReqresPojo.class);
        Assert.assertEquals(deserilization.getData().getLast_name(),"Weaver");
        Assert.assertEquals(deserilization.getAd().getCompany(),"StatusCode Weekly");
    }



}

