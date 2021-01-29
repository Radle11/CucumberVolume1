package Utils;

import io.cucumber.java.Scenario;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The JavaScriptMethods contains methods for interacting with UI objects during
 * run-time within the selenium scripts.
 * Inherits <b>ElementReadyStatus</b> class.
 * These are all common JavaScript method for most objects. Interaction with the object will
 * NOT occur until the object has been <b>VERIFIED</b> to be present, visible and/or enabled on
 * the page.
 *
 * @author Eldar
 * @since 2020-01-01
 */
public class JavaScriptMethods {
    private static final Logger LOGGER = Logger.getLogger(JavaScriptMethods.class);

    /**
     * clearWhenExist
     * @param driver
     * @param element
     */
    public static void clearWhenExists(WebDriver driver, WebElement element){
        try{
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].value = '';", element);
            LOGGER.info("Clear input \nWebElement: "+element);
        }catch (Exception e){
            LOGGER.error("Clear Input Failed",e);
        }
    }
    public static void click(WebDriver driver, WebElement element){
        try {
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", element);
            LOGGER.info("Clicked "+element.getText()+"\nWebElement: "+element);
        }catch (Exception e){
            LOGGER.error("Failed to click",e);
        }
    }
    public static void enterValue(WebDriver driver, WebElement element,String stringValue){
        try {
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].value='"+stringValue+"';", element);
            LOGGER.info("WebElement: "+element);
        }catch (Exception e){
            LOGGER.error("Failed to enter value",e);
        }
    }

    public static void highlight(WebElement element, WebDriver driver) {

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style','background: ; border: 5px solid red;');", element);
            Thread.sleep(3000);
            LOGGER.info("Highlight: TRUE. Highlighting will be enabled.");


        } catch (Exception e) {
            LOGGER.error("Highlighting will be disabled.", e);
        }
    }

}
