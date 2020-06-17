package StepDefinitions.com.weborder;

import Pages.WebOrderPages.HomePage;
import Pages.WebOrderPages.OrderPage;
import Utils.BrowserUtils;
import Utils.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class NewOrderSteps {
    WebDriver driver= Driver.getDriver();
    HomePage homePage=new HomePage(driver);
    OrderPage orderPage=new OrderPage(driver);
    @Then("the user enters product info {string} and {string}")
    public void the_user_enters_product_info_and(String product, String quantity) {
       homePage.orderButton.click();
        Select select=new Select(orderPage.productName);
        select.selectByVisibleText(product);
        orderPage.quantity.clear();
        orderPage.quantity.sendKeys(quantity);

    }
    @Then("the user enters address info {string},{string},{string},{string},{string}")
    public void the_user_enter_address_info(String CustomerName, String Street, String City, String State, String Zip) {
        orderPage.customerName.sendKeys(CustomerName);
        orderPage.street.sendKeys(Street);
        orderPage.city.sendKeys(City);
        orderPage.state.sendKeys(State);
        orderPage.zipCode.sendKeys(Zip);

    }
    @Then("the user enters payment info {string}, {string},{string}")
    public void the_user_enter_payment_info(String card, String cardNumber, String exprirationDate) {
       switch(card){
           case "Visa":
               orderPage.visa.click();
               break;
           case "MasterCard":
               orderPage.masterCard.click();
               break;
           case "American Express":
               orderPage.amex.click();
               break;
       }
       orderPage.cardNum.sendKeys(cardNumber);
       orderPage.expirationDate.sendKeys(exprirationDate);
       orderPage.processButton.click();
    }
    @Then("the user validate success message")
    public void the_user_validate_success_message() {
        Assert.assertTrue(orderPage.successMessage.isDisplayed());
    }

    @Then("the user goes to the new order page")
    public void the_user_goes_to_the_new_order_page() {
        homePage.orderButton.click();
    }

    @Then("the user validate the product headers")
    public void the_user_validate_the_product_headers(List<String> dataTable) {
        List<String> actualProductHeaders= BrowserUtils.getElementTexts(orderPage.productDetails);
        Assert.assertEquals(actualProductHeaders,dataTable);
    }
    @Then("the user validate the address headers")
    public void the_user_validate_the_address_headers(List<String> dataTable) {
       List<String> actualAddressHeader=BrowserUtils.getElementTexts(orderPage.addressDetails);
        Assert.assertEquals(actualAddressHeader,dataTable);
    }



}

