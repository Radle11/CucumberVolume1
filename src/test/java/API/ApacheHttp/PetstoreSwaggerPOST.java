package API.ApacheHttp;

import Utils.PayLoadUtils;
import com.github.javafaker.Faker;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class PetstoreSwaggerPOST {
    @Test
    public void postPet() throws URISyntaxException, IOException {
        for (int i=1;i<11025;i++){
            HttpClient client= HttpClientBuilder.create().build();
            URIBuilder uriBuilder=new URIBuilder();
            //https://petstore.swagger.io/v2/pet
            uriBuilder.setScheme("http").setHost("petstore.swagger.io").setPath("v2/pet");
            HttpPost post=new HttpPost(uriBuilder.build());
            post.setHeader("Content-Type","application/json");
            post.setHeader("Accept","application/json");
            Faker faker=new Faker();
            HttpEntity entity=new StringEntity(PayLoadUtils.getPetPayLoad(i,faker.dog().name(), faker.dog().breed()));
            post.setEntity(entity);
            System.out.println(i+" "+faker.cat().name()+" "+faker.cat().breed());
            Assert.assertEquals(HttpStatus.SC_OK, client.execute(post).getStatusLine().getStatusCode());
        }
    }
}
