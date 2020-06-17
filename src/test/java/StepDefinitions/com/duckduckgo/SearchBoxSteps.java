package StepDefinitions.com.duckduckgo;

import Pages.DuckDuckGoPages.ResultPage;
import Pages.DuckDuckGoPages.SearchPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBoxSteps {
    WebDriver driver= Driver.getDriver();
    SearchPage searchPage;
    ResultPage resultPage;
    @Given("the user goes to duckduckgo")
    public void the_user_goes_to_duckduckgo() {
        driver.get(ConfigReader.getProperty("url"));
        searchPage=new SearchPage(driver);
        resultPage=new ResultPage(driver);
    }

    @When("the user sends the selenium keyword")
    public void the_user_sends_the_selenium_keyword() {
        searchPage.searchBox.sendKeys(ConfigReader.getProperty("searchValue")+ Keys.ENTER);
    }

    @Then("the user clicks search button")
    public void the_user_clicks_search_button() {
//        searchPage.searchButton.click();
    }

    @Then("the user validates if title contains the selenium keyword")
    public void the_user_validates_if_title_contains_the_selenium_keyword() {
        String actualTitle=driver.getTitle();
        String expectedTitle=ConfigReader.getProperty("searchValue");
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Then("the user validates if url contains the selenium keyword")
    public void the_user_validates_if_url_contains_the_selenium_keyword() {
        String actualURL=driver.getCurrentUrl();
        String expectedURL=ConfigReader.getProperty("searchValue");
        Assert.assertTrue(actualURL.contains(expectedURL));
    }

    @Then("the user validates if all results contain the selenium keyword")
    public void the_user_validates_if_all_results_contain_the_selenium_keyword() {
        for (WebElement result:resultPage.results){
            Assert.assertTrue(result.getText().contains(ConfigReader.getProperty("searchValue")));
        }
    }
    @Given("the user search with {string}")
    public void the_user_search_with(String string) {
        searchPage.searchBox.sendKeys(string);
            searchPage.searchButton.click();
    }

    @When("the user validate title contains {string}")
    public void the_user_validate_title_contains(String string) {
        String actualTitle=driver.getTitle();
        String expectedTitle=string;
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @When("the user validate all results contains {string}")
    public void the_user_validate_all_results_contains(String string) {
        for (WebElement result:resultPage.results){
            Assert.assertTrue(result.getText().contains(string));
        }
    }

    @When("the user validate number of result is {int}")
    public void the_user_validate_number_of_result_is(Integer int1) {
        Assert.assertEquals(10, resultPage.results.size());
    }















}
