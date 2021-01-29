package StepDefinitions.APIpractice;

import Pages.Slack.Slack;
import Utils.ConfigReader;
import Utils.Driver;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SlackSteps {
    WebDriver driver= Driver.getDriver();
    Slack slack=new Slack(driver);
    WebElement message;
    Response response;
    WebDriverWait wait=new WebDriverWait(driver,5);
    @When("user sends a message via POST request")
    public void user_sends_a_message_via_POST_request() {
        //https://slack.com/api/chat.postMessage
//         response= given().contentType(ContentType.JSON).accept(ContentType.JSON)
//                .header("Authorization",ConfigReader.getProperty("tockenSlack"))
//                .body("{\n" +
//                        "  \"channel\": \""+ ConfigReader.getProperty("api_channel") +"\",\n" +
//                        "  \"text\": \""+ConfigReader.getProperty("messageSlack")+"\"\n" +
//                        "}").when().post(ConfigReader.getProperty("urlSlackPost"));
    }

    @Then("verify message via GET request")
    public void verify_message_via_GET_request() {
//        response=given().contentType(ContentType.JSON).accept(ContentType.JSON)
//                .header("Authorization",ConfigReader.getProperty("tockenSlack"))
//                .when().get(ConfigReader.getProperty("urlSlackGet"));
//        Map<String, List<Map<String,Object>>> bodyInfo = response.getBody().as(new TypeRef<Map<String, List<Map<String,Object>>>>() {});
//        bodyInfo.get("messages").stream().forEach(text->Assert.assertEquals(ConfigReader.getProperty("messageSlack"),text.get("text")));
    }

    @Then("Verify the message with Selenium Webdriver in UI")
    public void verify_the_message_with_Selenium_Webdriver_in_UI() {
        driver.get(ConfigReader.getProperty("urlSlackGet"));
        slack.logIn(ConfigReader.getProperty("slackWorkSpace"),ConfigReader.getProperty("userEmail"),ConfigReader.getProperty("userPassword"));
           // message = driver.findElement(By.xpath("//span[.='" + ConfigReader.getProperty("messageSlack") + "']"));
            //Assert.assertEquals(message.getText(), ConfigReader.getProperty("messageSlack"));
    }

    @When("user sends message with Selenium Webdriver in UI")
    public void user_sends_message_with_Selenium_Webdriver_in_UI() {
        wait.until(ExpectedConditions.visibilityOf(slack.textArea)).sendKeys(ConfigReader.getProperty("messageSlack")+ Keys.ENTER);
    }

    @When("Delete message from slack via POST request")
    public void delete_message_from_slack_via_POST_request() {
//https://slack.com/api/chat.delete?channel=C0164SXRETU&ts=1593291409.019700

    }

    @Then("Verify the message is gone via GET request")
    public void verify_the_message_is_gone_via_GET_request() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Verify the message is gone via Selenium Webdriver in UI")
    public void verify_the_message_is_gone_via_Selenium_Webdriver_in_UI() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
