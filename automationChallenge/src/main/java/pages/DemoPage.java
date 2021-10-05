package pages;

import locators.DemoLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Commons;
import java.util.ArrayList;

public class DemoPage extends BasePage{

    public DemoPage(WebDriver driver){ super(driver);}

    public void executeScrollBottomPage(){

        JavascriptExecutor executorJs = (JavascriptExecutor) driver;

        Long lastHeight = (Long) executorJs.executeScript("return document.body.scrollHeight");
        Long newHeight = (Long) executorJs.executeScript("return document.body.scrollHeight");

        while (true){
            executorJs.executeScript("window.scrollBy(0,document.body.scrollHeight)");

            Commons.sleep(1500);

            if (newHeight == lastHeight) {break;}
            newHeight = lastHeight;
        }

    }

    public void findLockedTopic(){

        executeScrollBottomPage();
        JavascriptExecutor executorJs = (JavascriptExecutor) driver;

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(DemoLocators.getIconLocked()));

        ArrayList<WebElement> listElements = (ArrayList<WebElement>) getDriver().findElements(DemoLocators.getIconLocked());

        for (int i=0; i<listElements.size(); i++){

            executorJs.executeScript("arguments[0].scrollIntoView(false);",  listElements.get(i));
            executorJs.executeScript("scrollBy(0,250)");
            Commons.sleep(1500);
            Commons.executeScreenshot(driver);
        }

    }

}
