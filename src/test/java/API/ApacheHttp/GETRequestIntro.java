package API.ApacheHttp;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class GETRequestIntro {
@Test
    public void getRequest() throws URISyntaxException {
    HttpClient client= HttpClientBuilder.create().build();
    URIBuilder uriBuilder=new URIBuilder();
    uriBuilder.setScheme("https");
    uriBuilder.setHost("petstore.swagger.io");
    uriBuilder.setPath("v2/pet/2324");
    HttpGet get=new HttpGet(uriBuilder.build());
    get.setHeader("Accept","application/json");
    //client specifies the request type, server specifies the response type

    try {
        HttpResponse response=client.execute(get);
        Assert.assertEquals(200,response.getStatusLine().getStatusCode());
//        System.out.println("Status code for get request is: "+response.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json",response.getEntity().getContentType().getValue());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@Test
    public void getPetByStatus(){
    //https://petstore.swagger.io/v2/pet/findByStatus?status=sold
    HttpClient client= HttpClientBuilder.create().build();//postman/terminal etc
    URIBuilder uriBuilder=new URIBuilder();
    uriBuilder.setScheme("https");
    uriBuilder.setHost("petstore.swagger.io");
    uriBuilder.setPath("v2/pet/findByStatus");
    uriBuilder.setCustomQuery("status=sold");
    HttpGet get= null;                                      //method specification
    try {
        get = new HttpGet(uriBuilder.build());
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }
    get.setHeader("Accept","application/json");
    HttpResponse response=null;
    try {
         response=client.execute(get);
        Assert.assertEquals(200,response.getStatusLine().getStatusCode());
        Assert.assertEquals("application/json",response.getEntity().getContentType().getValue());
    } catch (IOException e) {
        e.printStackTrace();
    }


}

}
