package Pages.DuckDuckGoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    public SearchPage(WebDriver driver){PageFactory.initElements(driver,this);}
    @FindBy(name = "q")
    public WebElement searchBox;
    @FindBy(xpath = "//input[@id='search_button_homepage']")
    public WebElement searchButton;

}
