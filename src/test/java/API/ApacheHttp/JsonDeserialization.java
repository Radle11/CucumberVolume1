package API.ApacheHttp;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JsonDeserialization {
    @Test
    //https://petstore.swagger.io/v2/pet/134
            public void getDeserialized() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/1");
        HttpGet get=new HttpGet(uriBuilder.build());
        get.setHeader("Content-Type","application/json");
        get.setHeader("Accept","application/json");
        HttpResponse response=client.execute(get);
        if(response.getStatusLine().getStatusCode()!= HttpStatus.SC_OK){
            Assert.fail("Status code is not matching.");
        }
        ObjectMapper mapper=new ObjectMapper();
        Map<String,Object> deserializedResponse=mapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String,Object>>() {});

        System.out.println("the id is from response body is: "+deserializedResponse.get("id"));
        System.out.println("the id is from response body is: "+deserializedResponse.get("name"));
        Map<String,Object> category=(Map<String,Object>) deserializedResponse.get("category");//--->since it is object we have ot cast it to map
        System.out.println("category name is: "+category.get("name"));
        List<Map<String,Object>> tags=(List<Map< String, Object >>) deserializedResponse.get("tags");
        System.out.println("tags name is: "+tags.get(0).get("name"));




    }



}
