package API.ApacheHttp;

import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AmazonHrefSteps {
    WebDriver driver;
    List<WebElement> links;
    @When("user navigates to Amazon.com")
    public void user_navigates_to_Amazon_com() {
        driver= Driver.getDriver();
        driver.navigate().to(ConfigReader.getProperty("urlAmazon"));
    }

    @Then("print out all links")
    public void print_out_all_links() {

  links=driver.findElements(By.xpath("//a[@href]"));
        System.out.println("Amazon.com links amount: "+links.size());
        links.stream().forEach(link-> System.out.println(link.getAttribute("href")));

    }

    @Then("print out all working links")
    public void print_out_all_working_links() throws URISyntaxException, IOException, ConnectException {
        System.out.println("Status 200_OK:");
        for(WebElement link: links) {
            try {
                int statusCode = given().get(link.getAttribute("href")).statusCode();
                if (statusCode == 200) {
                    System.out.println(link.getAttribute("href"));
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
}
