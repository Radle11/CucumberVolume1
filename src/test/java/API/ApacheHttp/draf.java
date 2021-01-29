package API.ApacheHttp;

import Utils.ConfigReader;
import Utils.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class draf {
    @Test
    public void test1(){
        WebDriver driver= Driver.getDriver();
        driver.get(ConfigReader.getProperty("urlAmazon"));
        List<WebElement> links=driver.findElements(By.xpath("//a[@href]"));
        System.out.println(links.get(0).getAttribute("href"));
    }
}
