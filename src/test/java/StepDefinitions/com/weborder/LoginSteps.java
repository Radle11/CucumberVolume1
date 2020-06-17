package StepDefinitions.com.weborder;

import Pages.WebOrderPages.HomePage;
import Pages.WebOrderPages.LogInPages;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    WebDriver driver = Driver.getDriver();
    LogInPages logInPages = new LogInPages(driver);
    HomePage homePage = new HomePage(driver);
    @Given("the demoUser enters username,password and click login button")
    public void the_demoUser_enters_username_password_and_click_login_button() {
        driver.get(ConfigReader.getProperty("webOrderUrl"));
        logInPages.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
    }

    @Then("the demoUser validate the home page")
    public void the_demoUser_validate_the_home_page() {
        Assert.assertEquals("Web Orders", driver.getTitle());
        Assert.assertEquals("Welcome, Tester! | Logout", homePage.welcomeText.getText().trim());
        Assert.assertTrue(homePage.logOutButton.isDisplayed());
        homePage.logOutButton.click();
    }

    @Given("the demoUser enters {string},{string} and click login button")
    public void the_demoUser_enters_and_click_login_button(String string, String string2) {
        logInPages.login(string, string2);
    }

    @Given("the demoUser validate the {string}")
    public void the_demoUser_validate_the(String string) {Assert.assertEquals(string, logInPages.error.getText()); }
}
