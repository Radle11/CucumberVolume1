package Pages.WebOrderPages;

import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPages {
    public LogInPages(WebDriver driver){PageFactory.initElements(driver, this);}
    @FindBy(xpath = "//input[@name='ctl00$MainContent$username']")
    public WebElement userName;
    @FindBy(xpath = "//input[@name='ctl00$MainContent$password']")
    public WebElement password;
    @FindBy(xpath = "//input[@name='ctl00$MainContent$login_button']")
    public WebElement loginButton;
    @FindBy (className = "error")
    public WebElement error;



    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }
}
