package API.Jira;

import Utils.ConfigReader;
import Utils.PayLoadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static Utils.PayLoadUtils.getJiraSesionCookie;

public class JiraGetRequest {
    HttpClient client;
    URIBuilder uriBuilder;
    HttpPost post;
    HttpResponse response;
    ObjectMapper mapper;
    HttpEntity entity;
    HttpGet get;
    @BeforeMethod
    public void setTest(){
        client = HttpClientBuilder.create().build();
        uriBuilder = new URIBuilder();
        mapper = new ObjectMapper();
    }
    @Test
    public void getIssuesInfo() throws URISyntaxException, IOException {
        //http://localhost:8080/rest/api/2/search?jql=assignee=Goefrey&maxResults=1
        uriBuilder.setScheme("http").setHost("localhost").setPort(8080).setPath("rest/api/2/search").setCustomQuery("jql=assignee=radle11&maxResults=5");
        get =new HttpGet(uriBuilder.build());
        get.setHeader(HttpHeaders.ACCEPT,"application/json");
        get.setHeader(HttpHeaders.CONTENT_TYPE,"application/json");
        get.setHeader("Cookie", getJiraSesionCookie());
        response = client.execute(get);
        org.testng.Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Map<String, Object> desPostJira = mapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {});
        List<Map<String,Object>> issues=(List<Map<String,Object>>)desPostJira.get("issues");
        Assert.assertEquals(issues.size(),desPostJira.get("total"));
        Set<String> issueKeys=new HashSet<>();
        for(Map<String,Object>issue:issues){
            issueKeys.add((String)issue.get("key"));
        }
        Assert.assertEquals(2,issueKeys.size());
    }
    @Test
    public void test2() throws URISyntaxException, IOException {
        uriBuilder.setScheme("http").setHost("localhost").setPort(8080).setPath("rest/api/2/search").setCustomQuery("jql=assignee=radle11&maxResults=5");
        get =new HttpGet(uriBuilder.build());
        get.setHeader("Accept","application/json");
        get.setHeader("Content-Type","application/json");
        get.setHeader("Cookie", getJiraSesionCookie());
        response = client.execute(get);
        org.testng.Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        JsonNode jsonNode=mapper.readTree(response.getEntity().getContent());
        System.out.println(jsonNode.get("total"));
      //  System.out.println(jsonNode.get("issues"));

    }
}
