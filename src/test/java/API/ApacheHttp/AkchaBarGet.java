package API.ApacheHttp;

import API.POJO.Akchabar.AkchaBar;
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

public class AkchaBarGet {
    @Test
    public void getAkchaBar() throws URISyntaxException, IOException {
    HttpClient client= HttpClientBuilder.create().build();//postman/terminal etc
    //http://rates.akchabar.kg/get.json
    URIBuilder uriBuilder=new URIBuilder();
    uriBuilder.setScheme("http");
    uriBuilder.setHost("rates.akchabar.kg");
    uriBuilder.setPath("get.json");
    HttpGet get=new HttpGet(uriBuilder.build());
    get.setHeader(HttpHeaders.ACCEPT,"application/json");
    HttpResponse response=client.execute(get);
    ObjectMapper mapper=new ObjectMapper();
    AkchaBar deserializedObject=mapper.readValue(response.getEntity().getContent(), AkchaBar.class);
    System.out.println(deserializedObject.getDate());
    System.out.println(deserializedObject.getRates().getBtc());

}
}
