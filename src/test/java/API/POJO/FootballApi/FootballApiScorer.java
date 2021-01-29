package API.POJO.FootballApi;

import Utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class FootballApiScorer {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @BeforeMethod
    public void setUp() {
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
        response = given().spec(requestSpecification)
                .when().get()
                .then().spec(responseSpecification)
                .extract().response();
    }
    @Test
    public void getHighestScorer(){

        int numberOfGoalsByHarryKane = response.path("scorers.find { it.player.name == 'Harry Kane' }.numberOfGoals");
        Assert.assertEquals( numberOfGoalsByHarryKane,6);

    }
    @Test
    public void getHighestScorer2(){
        String playerCountry=response.path("scorers.find{it.player.name == 'Denis Cheryshev'}.player.countryOfBirth");
        Assert.assertEquals(playerCountry,"Russia");

    }
    @Test
    public void getHighestScorer3(){//GROOVY MIN/MAX
        String maxScorer=response.path("scorers.max{it.numberOfGoals}.player.name");
        String minScorer=response.path("scorers.min{it.numberOfGoals}.player.name");
        Assert.assertEquals(maxScorer,"Harry Kane");
        Assert.assertEquals(minScorer,"Artem Dzyuba");

    }
    @Test
    public void getHighestScorer4(){//GROOVY MIN/MAX
        int minGoal=response.path("scorers.min{it.numberOfGoals}.numberOfGoals");
       List<String>  minScorers=response.path("scorers.findAll{it.numberOfGoals=="+minGoal+"}.player.name");
        System.out.println(minScorers);
        Assert.assertEquals(minScorers, Arrays.asList(new String[]{"Artem Dzyuba", "Diego Costa", "Eden Hazard", "Yerry Mina"}));
    }
    @Test
    public void getHighestScorer5(){//Groovy functions in hamcrest matchers verification
        response.then().body("scorers.find{it.player.name=='Harry Kane'}.numberOfGoals", Matchers.is(6));
    }
    @Test
    public void getHighestScorer6(){//Groovy functions in hamcrest matchers verification
        response.then().body("scorers.findAll{it.team.name=='Russia'}", Matchers.hasSize(2));
    }

    @Test
    public void getHighestScorer7(){//Groovy collect functions
//        response.then().body("scorers.collect{it.team.name}", Matchers.hasItem("Turkey"));
        response.then().body("scorers.collect{it.team.name}", Matchers.hasItems("England","Portugal"));
    }


}
