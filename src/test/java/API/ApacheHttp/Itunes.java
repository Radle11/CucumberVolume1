package API.ApacheHttp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class Itunes {
    HttpClient client;
    URIBuilder uriBuilder;
    HttpGet get;
    HttpResponse response;
    ObjectMapper mapper;


    @Test
    public void getInfoItunes() throws IOException, URISyntaxException {
        int limitValue=100;
        client = HttpClientBuilder.create().build();
        uriBuilder = new URIBuilder();
        //https://itunes.apple.com/search?term=green%20day&limit=100
        uriBuilder.setScheme("https").setHost("itunes.apple.com").setPath("search").setCustomQuery("term=greenday&limit="+limitValue);
        get = new HttpGet(uriBuilder.build());
        response = client.execute(get);
        mapper = new ObjectMapper();
        get.setHeader(HttpHeaders.ACCEPT,"application/json");

        Map<String,Object> des=mapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        System.out.println(des);
        List<Map<String, Object>> results=(List<Map<String, Object>>)des.get("results");
        for (Map<String, Object> result:results){
            if (result.get("artistName").toString().equalsIgnoreCase("Green Day"))
            Assert.assertEquals(result.get("artistName"),"Green Day");
        }
        Assert.assertEquals(des.get("resultCount"),results.size());
    }
}
