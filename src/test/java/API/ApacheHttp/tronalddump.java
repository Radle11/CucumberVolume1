package API.ApacheHttp;
import com.fasterxml.jackson.core.type.TypeReference;
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
import java.util.List;
import java.util.Map;

public class tronalddump {
    @Test
    public void getValueAndLinks() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        //http://tronalddump.io/random/quote
        uriBuilder.setScheme("http").setHost("tronalddump.io").setPath("random/quote");
        HttpGet get = new HttpGet(uriBuilder.build());
        get.setHeader(HttpHeaders.ACCEPT,"application/json");
        get.setHeader(HttpHeaders.CONTENT_TYPE,"application/json");
        HttpResponse response=client.execute(get);
        ObjectMapper mapper=new ObjectMapper();
        Map<String,Object> desObject=mapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        System.out.println(desObject.get("value"));
        Map<String,Map<String,Object>> links=(Map<String,Map<String,Object>>)desObject.get("_links");
      String href=(String)links.get("self").get("href");
        System.out.println(href);
        List<String> tags=(List<String>)desObject.get("tags");
        System.out.println(tags.get(0));
        System.out.println(desObject.get("updated_at"));
        System.out.println(desObject.get("value"));
        System.out.println("________________________________________________________________________");
        Map<String,List<Map<String,Object>>> embedded=(Map<String,List<Map<String,Object>>>)desObject.get("_embedded");
        Map<String,Map<String,String>> authorLink=(Map<String,Map<String,String>>)embedded.get("author").get(0).get("_links");
        System.out.println("author link: "+authorLink.get("self").get("href"));
        Map<String,Map<String,String>> sourceLink=(Map<String,Map<String,String>>)embedded.get("source").get(0).get("_links");
        System.out.println("source link: "+sourceLink.get("self").get("href"));





    }

}
