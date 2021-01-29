package API.ApacheHttp;

import Utils.PayLoadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

public class PostRequestIntro {
    @Test
    //https://reqres.in/api/users
    public void postRequest() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("reqres.in");
        uri.setPath("api/users");
        HttpPost post = new HttpPost(uri.build());
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept", "application/json");
        HttpEntity httpEntity = new StringEntity("{\n" +
                "    \"name\": \"chriss\",\n" +
                "    \"job\": \"student\"\n" +
                "}");
        post.setEntity(httpEntity);
        HttpResponse response = client.execute(post);
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json; charset=utf-8", response.getEntity().getContentType().getValue());

    }

    @Test
    public void petPost() throws URISyntaxException, IOException {

        //https://petstore.swagger.io/v2/pet
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");
        System.out.println("Post");
        HttpPost post = new HttpPost(uriBuilder.build());
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept", "application/json");
        int id=1100;
        String name="dixie";
        String stasus="dead";
        HttpEntity entity = new StringEntity(PayLoadUtils.getPetPayLoad(id,name,stasus));
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json", response.getEntity().getContentType().getValue());
        ObjectMapper mapper=new ObjectMapper();
        Map<String,Object> des=mapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>(){});
        Assert.assertEquals(des.get("id"),id);
        Assert.assertEquals(des.get("name"),name);
        Assert.assertEquals(des.get("status"),stasus);
        uriBuilder.setPath("v2/pet/"+id);
        System.out.println("Get");
        HttpGet get=new HttpGet(uriBuilder.build());
        response=client.execute(get);
        des=mapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>(){});
        Assert.assertEquals(des.get("id"),id);
        Assert.assertEquals(des.get("name"),name);
        Assert.assertEquals(des.get("status"),stasus);
        System.out.println("Delete");
        HttpDelete delete=new HttpDelete(uriBuilder.build());
        response=client.execute(delete);
        des=mapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>(){});
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(des.get("id"),id);
        softAssert.assertEquals(des.get("name"),name);
        softAssert.assertEquals(des.get("status"),stasus);
        softAssert.assertAll();




    }
    @Test
    public void petPut() throws URISyntaxException, IOException {
        //https://reqres.in/api/users/2
        HttpClient client=HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/users/2");
        HttpPut put=new HttpPut(uriBuilder.build());
        put.setHeader("Content-Type","application/json");
        put.setHeader("Accept","application/json");
        HttpEntity entity= null;
        try {
            entity = new StringEntity("{\n" +
                    "    \"name\": \"neo\",\n" +
                    "    \"job\": \"jonitor\"\n" +
                    "}");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        put.setEntity(entity);
        Assert.assertEquals(HttpStatus.SC_OK,client.execute(put).getStatusLine().getStatusCode());
    }

}
