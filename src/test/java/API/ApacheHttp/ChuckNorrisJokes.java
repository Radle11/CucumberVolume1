package API.ApacheHttp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.errorprone.annotations.Var;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class ChuckNorrisJokes {
    HttpResponse response;
    HttpClient client;
    URIBuilder uriBuilder;

    @Test
    public void getJokes() throws URISyntaxException, IOException {
        client = HttpClientBuilder.create().build();
        uriBuilder = new URIBuilder();
        //https://api.chucknorris.io/jokes/random
        uriBuilder.setScheme("https").setHost("api.chucknorris.io").setPath("jokes/random");
        HttpGet get = new HttpGet(uriBuilder.build());
        get.setHeader("Content-Type", "application/json");
        get.setHeader("Accept", "application/json");
        response = client.execute(get);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> deserialize = mapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        String actualValue = (String) deserialize.get("deserialize");
        System.out.println(actualValue);

    }
}
