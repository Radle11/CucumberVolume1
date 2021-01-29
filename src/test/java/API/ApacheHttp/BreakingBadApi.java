package API.ApacheHttp;

import API.POJO.BreakingBadApi.BreakingBadCharacterPojo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
import java.util.*;

public class BreakingBadApi {
    private static final String ALIVE="alive";
    private static final String DECEASED="deceased";
    private static final String PRESUMEDDEAD="presumed_DEAD";
    private static final String UNKNOWN="unknown";
    @Test
    public void getBreakingBadCharacters() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();//postman/terminal etc
        // https://breakingbadapi.com/api/characters
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("breakingbadapi.com");
        uriBuilder.setPath("api/characters");
        HttpGet get=new HttpGet(uriBuilder.build());
        get.setHeader(HttpHeaders.ACCEPT,"application/json");
        HttpResponse response=client.execute(get);
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        List<BreakingBadCharacterPojo> deserializedObject=mapper.readValue(response.getEntity().getContent(), new TypeReference<List<BreakingBadCharacterPojo>>() {
        });
        Map<String,List<String>> charBystatus=new HashMap<>();
        List<String> alive=new ArrayList<>();
        List<String> deceased=new ArrayList<>();
        List<String> presumedDead=new ArrayList<>();
        List<String> unknown=new ArrayList<>();
        for (int i=0; i<deserializedObject.size();i++){
           if (deserializedObject.get(i).getStatus().equalsIgnoreCase(ALIVE)){
               alive.add(deserializedObject.get(i).getName());
           }else if (deserializedObject.get(i).getStatus().equalsIgnoreCase(DECEASED)){
               deceased.add(deserializedObject.get(i).getName());
           }else if (deserializedObject.get(i).getStatus().equalsIgnoreCase(PRESUMEDDEAD)){
               presumedDead.add(deserializedObject.get(i).getName());
           }else {
               unknown.add(deserializedObject.get(i).getName());
           }

        }
        charBystatus.put(ALIVE,alive);
        charBystatus.put(DECEASED,deceased);
        charBystatus.put(PRESUMEDDEAD,presumedDead);
        charBystatus.put(UNKNOWN,unknown);
        System.out.println("Alive: "+charBystatus.get(ALIVE));
        System.out.println("Deseased: "+charBystatus.get(DECEASED));
        System.out.println("Presumed Dead: "+charBystatus.get(PRESUMEDDEAD));
        System.out.println("Unknown: "+charBystatus.get(UNKNOWN));


    }
    @Test
    public void getCharacterByID() throws IOException, URISyntaxException {
        HttpClient client= HttpClientBuilder.create().build();//postman/terminal etc
        // https://breakingbadapi.com/api/characters
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("breakingbadapi.com");
        uriBuilder.setPath("api/characters/12");
        HttpGet get=new HttpGet(uriBuilder.build());
        get.setHeader(HttpHeaders.ACCEPT,"application/json");
        HttpResponse response=client.execute(get);
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        List<BreakingBadCharacterPojo>deserializedObject=mapper.readValue(response.getEntity().getContent(),
                mapper.getTypeFactory().constructCollectionType(List.class,BreakingBadCharacterPojo.class));
        System.out.println(String.format("%s is %s portrayed %s, in %s",deserializedObject.get(0).getName(),
                deserializedObject.get(0).getStatus(),deserializedObject.get(0).getCategory(),deserializedObject.get(0).getPortrayed()));
//        System.out.println(deserializedObject.get(0).getName()+" is "+deserializedObject.get(0).getStatus()+", portrayed: "+deserializedObject.get(0).getCategory());
    }
    @Test
    public void getCharacterByRandomID() throws IOException, URISyntaxException {
        HttpClient client= HttpClientBuilder.create().build();
        // https://breakingbadapi.com/api/characters
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("breakingbadapi.com");
        Random randomID=new Random();
        uriBuilder.setPath("api/characters/"+randomID.nextInt(63));
        HttpGet get=new HttpGet(uriBuilder.build());
        get.setHeader(HttpHeaders.ACCEPT,"application/json");
        HttpResponse response=client.execute(get);
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        List<BreakingBadCharacterPojo>deserializedObject=mapper.readValue(response.getEntity().getContent(),
                mapper.getTypeFactory().constructCollectionType(List.class,BreakingBadCharacterPojo.class));
        System.out.println(String.format("%s is %s portrayed %s, in %s",deserializedObject.get(0).getName(),
                deserializedObject.get(0).getStatus(),deserializedObject.get(0).getCategory(),deserializedObject.get(0).getPortrayed()));
//        System.out.println(deserializedObject.get(0).getName()+" is "+deserializedObject.get(0).getStatus()+", portrayed: "+deserializedObject.get(0).getCategory());
    }

}
