package StepDefinitions.com.weborder;

import Pages.WebOrderPages.HomePage;
import Pages.WebOrderPages.LogInPages;
import Pages.WebOrderPages.ProductListPage;
import Utils.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AllProductsSteps {
    WebDriver driver= Driver.getDriver();
    LogInPages logInPages = new LogInPages(driver);
    HomePage homePage = new HomePage(driver);
    ProductListPage productListPage=new ProductListPage(driver);
    @When("the user clicks the all products button")
    public void the_user_clicks_the_all_products_button() {
        homePage.viewAllProducts.click();
    }

    @Then("the user validates the product details")
    public void the_user_validates_the_product_details(DataTable dataTable) {
        while(productListPage.productTables.iterator().hasNext()&&dataTable.asList().iterator().hasNext()){
            Assert.assertEquals(dataTable.asList().iterator().next(),productListPage.productTables.iterator().next().getText().trim());
        }}
}
