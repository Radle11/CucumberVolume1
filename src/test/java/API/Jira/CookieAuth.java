package API.Jira;

import Utils.ConfigReader;
import Utils.PayLoadUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

import static Utils.PayLoadUtils.getJiraSesionCookie;

public class CookieAuth {
    HttpClient client;
    URIBuilder uriBuilder;
    HttpPost post;
    HttpResponse response;
    ObjectMapper mapper;
    HttpEntity entity;
    HttpGet get;
    @BeforeMethod
    public void setBeforeMethod() throws URISyntaxException, IOException {
        client = HttpClientBuilder.create().build();
        uriBuilder = new URIBuilder();
        mapper = new ObjectMapper();
    }

    @org.testng.annotations.Test
    public void getCookieAuth() throws URISyntaxException, IOException {
        //http://localhost:8080/rest/auth/1/session
        uriBuilder.setScheme("http").setHost("localhost").setPort(8080).setPath("rest/auth/1/session");
        post = new HttpPost(uriBuilder.build());
        post.setHeader(HttpHeaders.ACCEPT, "application/json");
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        entity = null;
        try {
            entity = new StringEntity(PayLoadUtils.getCookieAuthPayLoad(ConfigReader.getProperty("jiraUserName"),ConfigReader.getProperty("jiraUserPassword")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setEntity(entity);
        response = client.execute(post);
        org.testng.Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Map<String, Object> desJira = mapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
       Map<String,String>session= (Map<String,String>)desJira.get("session");
        String name=session.get("name");
        System.out.println(name);
        String value=session.get("value");
        System.out.println(value);
    }

    @org.testng.annotations.Test
    public void createIssue() throws IOException, URISyntaxException {
        uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http").setHost("localhost").setPort(8080).setPath("rest/api/2/issue");
        post = new HttpPost(uriBuilder.build());
        post.setHeader(HttpHeaders.ACCEPT, "application/json");
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        post.setHeader("Cookie", getJiraSesionCookie());
        entity=new StringEntity(PayLoadUtils.getJiraIssuePayLoad("Creating a bug2 from API","Bug2 created through API",
                "Bug"));
        post.setEntity(entity);
        response = client.execute(post);
        org.testng.Assert.assertEquals(response.getStatusLine().getStatusCode(),HttpStatus.SC_CREATED);
        Map<String, String> desPostJira = mapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, String>>() {});
//       for(String key:desPostJira.keySet()){
//           System.out.printf("%s: %s\n",key,desPostJira.get(key));
//       }
        desPostJira.keySet().stream().forEach(key->System.out.printf("%s: %s\n",key,desPostJira.get(key)));


    }
}
