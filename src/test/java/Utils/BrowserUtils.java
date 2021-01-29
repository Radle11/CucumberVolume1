package Utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static Utils.JavaScriptMethods.highlight;

public class BrowserUtils {
    private static final Logger LOGGER = Logger.getLogger(BrowserUtils.class);
    public static WebDriver DRIVER=Driver.getDriver();
    private static WebDriverWait WAIT =new WebDriverWait(DRIVER, 3);
    protected static By by;


    public By getBy(){return by;}
    public String getLocator(){
        return by.toString().substring(by.toString().indexOf(": ")+2);
    }

    /**
     * getElement() is used to get web element of locator
     * @return
     */
    public static WebElement getWebElement(){
        WebElement element=DRIVER.findElement(by);
        if(element!=null){
            highlight(element,DRIVER);
            LOGGER.info("WebElement found: "+element);
        }else {
            try{
                takeScreenShot();
            }catch (Exception e){
                e.printStackTrace();
            }
            LOGGER.error("WebElement not found: By: "+by);
        }
        return element;
    }

    /**
     * getWebElements() is used to get list of web elements
     * @return
     */
    public static List<WebElement> getWebElements(){
        List<WebElement> webElements;
        try{
            webElements= WAIT.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        }catch (Exception e){
            return Collections.emptyList();
        }
        return DRIVER.findElements(by);
    }

    /**
     * getText() method is used to get web elements text.
     * @return
     */
    public static String getText(){
        return WAIT.until(ExpectedConditions.visibilityOf(getWebElement())).getText();
    }

    /**
     * getALlText() method is used to get all text of web elements
     * @return
     */
    public static List<String> getAllText(){
        return getWebElements().stream().map(WebElement::getText).collect(Collectors.toList());
    }








    /**
     *
     * @param targetTitle
     */
    public static void switchWindowByTitle(String targetTitle) {
        Set<String> ids = DRIVER.getWindowHandles();
        for (String id : ids) {//loop all ids
            if (!DRIVER.getTitle().equals(targetTitle)) {//if title is not equal to targetTitle switch
                DRIVER.switchTo().window(id);
            }
        }
    }

    public static void switchWindowByURL(String url) {
        Set<String> ids = DRIVER.getWindowHandles();
        for (String id : ids) {//loop all ids
            if (!DRIVER.getCurrentUrl().contains(url)) {//if title is not equal to targetTitle switch
                DRIVER.switchTo().window(id);
            }

        }


    }

    public static void closeWindows(String parentId) {
        Set<String> ids = DRIVER.getWindowHandles();
        for (String id : ids) {//loop all ids
            if (!id.equals(parentId)) {
                DRIVER.switchTo().window(id);
                DRIVER.close();
            }

        }
    }

    public static WebElement fluentWait(long totalSecond, long pollingSeccond, By locator) {
        Wait<WebDriver> wait = new FluentWait(DRIVER)
                .withTimeout(Duration.ofSeconds(totalSecond))
                .pollingEvery(Duration.ofSeconds(pollingSeccond))
                .ignoring(Exception.class);

        return wait.until(driver1 -> driver1.findElement(locator));
    }

    public static WebElement visibilityOf(int timeUnit, WebElement element) {
        WebDriverWait wait = new WebDriverWait(DRIVER, timeUnit);
        highlight(element, DRIVER);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement visibilityOfLocator(int timeInSec, By locator) {
        WebDriverWait wait = new WebDriverWait(DRIVER, timeInSec);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static String takeScreenShot() {
        File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\Screenshot\\" +
                System.currentTimeMillis() + ".png";//will give the project location
        File path = new File(destination);
        try {
            FileUtils.copyFile(src, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }


    public static void switchByIndex(int index) {
        DRIVER.switchTo().frame(index);
    }

    public static void switchByLocator(By Locator) {
        DRIVER.switchTo().frame(DRIVER.findElement(Locator));
    }

    public static void switchByElement(WebElement element) {
        DRIVER.switchTo().frame(element);
    }

    public static List<String> getElementTexts(List<WebElement> elemets) {
        List<String> texts = new ArrayList<>();
        for (WebElement element : elemets) {
            texts.add(element.getText().trim());
        }
        return texts;
    }



    public BrowserUtils clickElement() {
        visibilityOf(3,WAIT.until(ExpectedConditions.elementToBeClickable(by))).click();
        return this;
    }

    public static void sendKeys(String input) {
        visibilityOf( 3, WAIT.until(ExpectedConditions.presenceOfElementLocated(by))).sendKeys(input);
    }

}
