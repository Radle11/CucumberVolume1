package API.ApacheHttp;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;
import java.text.*;
import java.security.SecureRandom;
import java.util.function.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;

public class codeSignal {

        public static void main(String[] args) throws IOException {
            HttpURLConnection connection=(HttpURLConnection) new URL("https://petstore.swagger.io/v2/pet/1011").openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("accept", "application/json");
            InputStream is=connection.getInputStream();
            ObjectMapper mapper=new ObjectMapper();
            Map<String,Object> des=mapper.readValue(is,new TypeReference<Map<String, Object>>(){});
            for(int i=0;i<des.size();i++){
                if(des.get("status")==null){
                    System.out.printf("Product %s has price %s and no manufacturer%n",des.get("id"),des.get("name"));
                }else{
                    System.out.printf("Product %s has price %s and manufacturer %s%n",des.get("id"),des.get("name"),des.get("status"));
                }
            }
        }
    }