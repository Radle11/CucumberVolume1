package API.ApacheHttp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DeserializationPractice {
    HttpClient client;
    URIBuilder uriBuilder;
    HttpResponse response;
    HttpGet get;
    ObjectMapper mapper;
    @Test
    public void test1() throws URISyntaxException, IOException {
        client= HttpClientBuilder.create().build();
        uriBuilder=new URIBuilder();
        //http://cat-fact.herokuapp.com/facts
        uriBuilder.setScheme("http").setHost("cat-fact.herokuapp.com").setPath("facts");
        get=new HttpGet(uriBuilder.build());
        response=client.execute(get);
        mapper=new ObjectMapper();
        Map<String, Object> objectDes=mapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<Map<String, Object>> all=(List<Map<String, Object>>)objectDes.get("all");
        System.out.println(all.get(0).get("text"));
        System.out.println(all.size());
    }
    @Test
    public void test2() throws URISyntaxException, IOException {
        client= HttpClientBuilder.create().build();
        uriBuilder=new URIBuilder();
        //http://cat-fact.herokuapp.com/facts
        uriBuilder.setScheme("http").setHost("cat-fact.herokuapp.com").setPath("facts");
        get=new HttpGet(uriBuilder.build());
        response=client.execute(get);
        mapper=new ObjectMapper();
        Map<String,List<Map<String,Object>>> objectDes=mapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, List<Map<String, Object>>>>() {

        });
        System.out.println("amount of facts: "+objectDes.get("all").size());
        List<String> noCat=new ArrayList<>();
        for (Map<String,Object> des:objectDes.get("all")){
            String text=(String)des.get("text");
            if (!text.contains("cat")&&!text.contains("Cat")&&
                    !text.contains("Kitten")&&
                    !text.contains("kitten")&&
                    !text.contains("kitty")&&
                    !text.contains("Kitty")){
                noCat.add(text);
            }
           // System.out.println(des.get("text"));
            Map<String,Map<String,String>> user=(Map<String,Map<String,String>>)des.get("user");
            System.out.println(user.get("name").get("first")+" "+user.get("name").get("last"));
        }
        System.out.println("amount of facts without cat: "+noCat.size());
        System.out.println(noCat);


    }
    @Test
    public void test3(){




    }
}
