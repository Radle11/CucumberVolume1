package Pages.Slack;

import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Slack {
    public Slack(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = ("//span[@class='p-ia__sidebar_header__user__name']"))
    public WebElement userName;
    @FindBy(xpath = "//input[@name='domain']")
    public WebElement workspace;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueButton;
    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailInput;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@id='signin_btn']")
    public WebElement signInButton;
    @FindBy(xpath = "//span[.='api_channel']")
    public WebElement api_channel;
    @FindBy(xpath = "//div[@class='ql-editor']")
    public WebElement textArea;



    public void logIn(String slackWorkSpace,String userEmail,String userPassword){
        this.workspace.sendKeys(slackWorkSpace);
        this.continueButton.click();
        this.emailInput.sendKeys(userEmail);
        this.password.sendKeys(userPassword);
        this.signInButton.click();
    }




}
