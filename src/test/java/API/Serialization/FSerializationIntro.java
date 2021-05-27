package API.Serialization;

import Utils.PayLoadUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class FSerializationIntro {
    ObjectMapper mapper;
    @Test
    public void serializa1() throws IOException {
        Pet pet=new Pet("Hatiko","waiting",3);
        pet.setId(1);
        pet.setPhotoURL("https://s3.petpics.amazon.com");
         mapper=new ObjectMapper();
        mapper.writeValue(new File("target/pet.json"),pet);
    }
    @Test
    public void serialize2() throws IOException {
        Car car=new Car("Toyota","Camry",2020);
        car.setCondition("new");
        car.setPrice(20000);
        mapper=new ObjectMapper();
        mapper.writeValue(new File("target/car.json"),car);
    }
    @Test
    public void createPet() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        //https://petstore.swagger.io/v2/pet
        uriBuilder.setScheme("http").setHost("petstore.swagger.io").setPath("v2/pet");
        HttpPost post=new HttpPost(uriBuilder.build());
        post.setHeader("Content-Type","application/json");
        post.setHeader("Accept","application/json");
        HttpEntity entity=new StringEntity(PayLoadUtils.generateStringFromResource("target/pet.json"));
        post.setEntity(entity);
        HttpResponse response=client.execute(post);
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());
    }

}
