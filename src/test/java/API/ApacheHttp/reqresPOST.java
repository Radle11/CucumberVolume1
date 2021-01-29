package API.ApacheHttp;

import API.POJO.Reqres.ReqresPojo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class reqresPOST {
    Faker faker;

    @Test
    public void reqresPost() throws IOException, URISyntaxException {
        faker = new Faker();
        //https://reqres.in/api/users/2
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users");
        HttpPost post = new HttpPost(uriBuilder.build());
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept", "application/json");
        HttpEntity entity = new StringEntity("{\n" +
                "    \"name\": \"" + faker.name().firstName() + "\",\n" +
                "    \"job\": \"" + faker.name().title() + "\"\n" +
                "}");
        post.setEntity(entity);
        Assert.assertEquals(HttpStatus.SC_CREATED, client.execute(post).getStatusLine().getStatusCode());

    }

    @Test
    public void reqresPut() throws URISyntaxException, IOException {
        //https://reqres.in/api/users/2
        faker = new Faker();
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/2");
        HttpPut put = new HttpPut(uriBuilder.build());
        put.setHeader("Content-Type", "application/json");
        put.setHeader("Accept", "application/json");
        HttpEntity entity = new StringEntity("{\n" +
                "    \"name\": \"" + faker.name().firstName() + "\",\n" +
                "    \"job\": \"" + faker.name().title() + "\"\n" +
                "}");
        put.setEntity(entity);
        //  Assert.assertEquals(HttpStatus.SC_CREATED,client.execute(put).getStatusLine().getStatusCode());
    }

    HttpClient client;
    URIBuilder uriBuilder;
    HttpResponse response;
    HttpGet get;
    ObjectMapper mapper;

    @Test
    public void getReqresValue() throws IOException, URISyntaxException {
        //https://reqres.in/api/users/2
        client = HttpClientBuilder.create().build();
        uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users").setCustomQuery("per_page=6");
        get = new HttpGet(uriBuilder.build());
        get.setHeader("Content-Type", "application/json");
        get.setHeader("Accept", "application/json");
        response = client.execute(get);
        mapper = new ObjectMapper();
        Map<String, Object> deserializedData = mapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<Map<String, Object>> data = (List<Map<String, Object>>) deserializedData.get("data");

//        System.out.println(data.size());
//        Iterator<Map<String,Object>> iterator=data.iterator();
//        int sum=0;
//        while(iterator.hasNext()){
//            System.out.println(iterator.next().get("first_name"));
//            sum+=(int)iterator.next().get("id");
//
//        }
//        Assert.assertEquals(deserializedData.get("per_page"),data.size());
//        System.out.println(sum);
        data.stream().forEach(d -> System.out.println(d.get("first_name")));

    }
    @Test
    public void testWithPojo() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();//postman/terminal etc
        URIBuilder uriBuilder=new URIBuilder();
        https://reqres.in/api/users/7
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users/7");
        HttpGet get=new HttpGet(uriBuilder.build());
        get.setHeader(HttpHeaders.ACCEPT,"application/json");
        HttpResponse response=client.execute(get);
        ObjectMapper mapper=new ObjectMapper();
        ReqresPojo deserializedObject=mapper.readValue(response.getEntity().getContent(),ReqresPojo.class);
        System.out.println(deserializedObject.getAd().getCompany());
        System.out.println(deserializedObject.getData().getFirst_name());
        System.out.println(deserializedObject.getData().getLast_name());
    }
}