package Pages.DuckDuckGoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultPage {
    public ResultPage(WebDriver driver){PageFactory.initElements(driver,this);}
    @FindBy(xpath = "//div[@class='result__body links_main links_deep']")
    public List<WebElement> results;
}
