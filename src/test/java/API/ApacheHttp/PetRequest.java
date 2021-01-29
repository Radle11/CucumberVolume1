package API.ApacheHttp;

import API.POJO.Petstore.PetPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class PetRequest {
    @Test
    public void getPet() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();//postman/terminal etc
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/1");
        HttpGet get=new HttpGet(uriBuilder.build());
        get.setHeader(HttpHeaders.ACCEPT,"application/json");
        HttpResponse response=client.execute(get);
        ObjectMapper mapper=new ObjectMapper();
        PetPojo deserializedObject=mapper.readValue(response.getEntity().getContent(),PetPojo.class);
        System.out.println(deserializedObject.getId());
        System.out.println(deserializedObject.getName());
    }
}
