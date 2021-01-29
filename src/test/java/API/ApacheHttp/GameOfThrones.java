package API.ApacheHttp;

import API.POJO.GameOfThrones.Data;
import API.POJO.GameOfThrones.GOTpojo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.IntStream;

public class GameOfThrones {
    HttpClient client;
    URIBuilder uri;
    HttpGet get;
    HttpResponse response;
    ObjectMapper mapper;
    GOTpojo gotDS;

    @BeforeMethod
    public void setBeforeMethod() throws URISyntaxException, IOException {
        client = HttpClientBuilder.create().build();
        uri = new URIBuilder();
        uri.setScheme("https").setHost("api.got.show").setPath("api/map/characters");
        get = new HttpGet(uri.build());
        get.setHeader("Accept", "application/json");
        get.setHeader("Content-Type", "application/json");
        response = client.execute(get);
        mapper = new ObjectMapper();
        gotDS = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .readValue(response.getEntity().getContent(), new TypeReference<GOTpojo>() {
                });
    }

    @Test
    public void getAllCharacters() {
        List<String> maleCharacters = new ArrayList<>();
        gotDS.getData().stream().filter(ch -> ch.isMale() == true).forEach(character -> maleCharacters.add(character.getName()));
        List<String> femaleCharacters = new ArrayList<>();
        gotDS.getData().stream().filter(ch -> ch.isMale() != true).forEach(character -> femaleCharacters.add(character.getName()));
        List<String> allCharacters = new ArrayList<>();
        gotDS.getData().stream().forEach(character -> allCharacters.add(character.getName()));
        Set<String> houses = new HashSet<>();
        gotDS.getData().stream().forEach(h -> houses.add(h.getHouse()));
//        System.out.println(houses);
//        System.out.println(maleCharacters);
    }

    @Test
    public void getHouseGender() throws URISyntaxException, IOException {
        Map<String, Map<String, Set<String>>> charactersByGender = new HashMap<>();
        Map<String, Set<String>> byGender = new HashMap<>();
        byGender.put("Male", new HashSet<String>());
        byGender.put("Female", new HashSet<String>());
        gotDS.getData().stream().forEach(ch -> charactersByGender.put(ch.getHouse(), byGender));
        gotDS.getData().forEach(data -> {
            if (data.isMale() == true) {
                charactersByGender.get(data.getHouse()).get("Male").add(data.getName());
            } else if (!data.isMale() == true) {
                charactersByGender.get(data.getHouse()).get("Female").add(data.getName());
            }
        });
//        System.out.println(charactersByGender.get("House Hightower").get("Male").size());
//        System.out.println(charactersByGender.get("House Frey").get("Female").size());
    }

    @Test
    public void getBookCharacter() {
        Map<String, Integer> countOfBooksForEachCharacter = new LinkedHashMap<>();
        gotDS.getData().stream().forEach(character -> countOfBooksForEachCharacter.put(character.getName(), character.getBooks().size()));
        //System.out.println(countOfBooksForEachCharacter);
        Map<String, List<String>> countOfCharactersForEachBook = new LinkedHashMap<>();
        Set<String> books = new HashSet<>();
        gotDS.getData().stream().forEach(ch -> books.addAll(ch.getBooks()));
        List<String> b = new ArrayList<>(books);
        b.stream().forEach(book -> countOfCharactersForEachBook.put(book, new ArrayList<>()));
        for (int k = 0; k < b.size(); k++) {
            for (int i = 0; i < gotDS.getData().size(); i++) {
                for (int z = 0; z < gotDS.getData().get(i).getBooks().size(); z++) {
                    if (gotDS.getData().get(i).getBooks().get(z).equals(b.get(k))) {
                        countOfCharactersForEachBook.get(b.get(k)).add(gotDS.getData().get(i).getName());
                    }
                }
            }
        }
        System.out.println(countOfCharactersForEachBook.size());
        System.out.println(countOfCharactersForEachBook);
       // System.out.println(countOfCharactersForEachBook.get("The World of Ice and Fire").size());
    }



}
