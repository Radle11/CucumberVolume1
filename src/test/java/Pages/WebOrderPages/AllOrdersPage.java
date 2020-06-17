package Pages.WebOrderPages;

import io.cucumber.datatable.internal.difflib.PatchFailedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllOrdersPage {
    public AllOrdersPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//tr[2]//td[position() > 1 and position() < last()]")
    public List<WebElement> newOrder;
}
