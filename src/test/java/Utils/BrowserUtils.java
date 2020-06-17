package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void switchWindowByTitle(WebDriver driver, String targetTitle) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {//loop all ids
            if (!driver.getTitle().equals(targetTitle)) {//if title is not equal to targetTitle switch
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchWindowByURL(WebDriver driver, String url) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {//loop all ids
            if (!driver.getCurrentUrl().contains(url)) {//if title is not equal to targetTitle switch
                driver.switchTo().window(id);
            }

        }

    }

    public static void closeWindows(WebDriver driver, String parentId) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {//loop all ids
            if (!id.equals(parentId)) {
                driver.switchTo().window(id);
                driver.close();
            }

        }
    }

    public static WebElement fluentWait(WebDriver driver, long totalSecond, long pollingSeccond, By locator) {
        Wait<WebDriver> wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(totalSecond))
                .pollingEvery(Duration.ofSeconds(pollingSeccond))
                .ignoring(Exception.class);
        return wait.until(driver1 -> driver1.findElement(locator));
    }

    public static WebElement visibilityOf(WebDriver driver, int timeUnit, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeUnit);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement visibilityOfLocator(WebDriver driver, int timeInSec, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSec);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static String takeScreenShot() {
        File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\Screenshot\\" + System.currentTimeMillis() + ".png";//will give the project location
        File path = new File(destination);
        try {
            FileUtils.copyFile(src, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static void switchByIndex(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public static void switchByLocator(WebDriver driver, By Locator) {
        driver.switchTo().frame(driver.findElement(Locator));
    }

    public static void switchByElement(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    public static List<String> getElementTexts(List<WebElement> elemets) {
        List<String> texts = new ArrayList<>();
        for (WebElement element : elemets) {
            texts.add(element.getText().trim());
        }
        return texts;
    }

}
