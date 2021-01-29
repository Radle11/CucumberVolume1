package Pages.DuckDuckGoPages;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BrowserUtils {
    public BrowserUtils searchBox() {
        by = By.name("a");
        return this;
    }

    public BrowserUtils searchButton() {
        by = By.xpath("//input[@id='search_button_homepage']");
        return this;

    }
}
