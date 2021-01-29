package API.ApacheHttp;

import Utils.ConfigReader;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StarWarsApi {
    @Test
    public void test1(){
        Response response=given().accept(ContentType.JSON).when().get("https://swapi.dev/api/planets");
        Map<String, Object> bodyInfo = response.getBody().as(new TypeRef<Map<String, Object>>() {});
        List<Map<String,Object>> planets = (List<Map<String, Object>>) bodyInfo.get("results");
        Map<String,String> namePopulation=new HashMap<>();
        planets.stream().forEach(n->namePopulation.put((String)n.get("name"),(String)n.get("population")));
        System.out.println(namePopulation);
    }
    @Test
    public void test2(){

    }
}
