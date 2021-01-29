package API.ApacheHttp;

import API.POJO.StarWars.StarWarStarshipsPojo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
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

public class StarWarsStarships {
    @Test
    public void getStarWarsStarships() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();//postman/terminal etc
       // https://swapi.dev/api/starships
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("swapi.dev");
        uriBuilder.setPath("api/starships");
        HttpGet get=new HttpGet(uriBuilder.build());
        get.setHeader(HttpHeaders.ACCEPT,"application/json");
        HttpResponse response=client.execute(get);
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        StarWarStarshipsPojo deserializedObject=mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,
                true).readValue(response.getEntity().getContent(), StarWarStarshipsPojo.class);
        System.out.println(deserializedObject.getResults().get(0).getMGLT());

    }
}
