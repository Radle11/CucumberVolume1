package API.RestAssured;

import API.POJO.FootballApi.CompetitionsPojo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FootballApiCompetitions {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "v2/competitions";
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
        response = given().spec(requestSpecification)
                .when().get()
                .then().spec(responseSpecification)
                .extract().response();
    }

    @Test
    public void getCompetitions() {
        CompetitionsPojo competitionsDes = response.getBody().as(CompetitionsPojo.class);
        List<Map<String, Object>> competitionsList = (List<Map<String, Object>>) competitionsDes.getCompetitions();
        competitionsList.stream().forEach(c -> {
            if ((int) c.get("id") >= 2100) System.out.println(c.get("name"));
        });
        System.out.print(competitionsList.get(0).get("name"));

    }

    @Test
    public void getCompetitions2() {//JPATH
        JsonPath jsonPath=response.jsonPath();
        List<Map<String,Object>> competitions = jsonPath.getList("competitions");
        for (Map<String, Object> c : competitions) {
            if ((int) c.get("id") >= 2100) System.out.print(c.get("name"));
        }
    }
    @Test
    public void getCompetitions3() {//GROOVY MANIPULATION
        List<String> competitionList=response.path("competitions.findAll { it.id>2100}.name");
        //findAll is Groovy specific function, 'it' in Groovy represents 'this' in java refers to current instance
        System.out.println(competitionList);
        List<String> competitionMexico=response.path("competitions.findAll { it.area.name=='Mexico'}.name");
        System.out.println(competitionMexico);
    }
}
