package cl.falabella.omniChanel.util;

import cl.falabella.omniChanel.Services.DatosSistema;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import java.util.List;

public class OmniChanelUtils {
    private static final Logger LOGGER = Logger.getLogger(DatosSistema.class);
    WebDriver driver;

    protected boolean isVisible(WebElement webElement) {
        boolean isVisible;
        try {
            isVisible = webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            isVisible = false;
        }
        return isVisible;
    }
    public  void position (WebDriver driver,WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
        act.moveToElement(element).click().perform();
    }
    public void Log(String ms) {
        LOGGER.info(ms);
    }


    public static void scroll(WebDriver driver) throws IOException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public static void scrollUp(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,250)");
    }

}
