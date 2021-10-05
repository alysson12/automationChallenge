package pages;

import locators.DemoLocators;
import locators.HomeLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) { super(driver);}

    public DemoPage menuClick(){

        executeMenuClickDemo();
        return new DemoPage(getDriver());

    }

    public String executeMenuClickDemo(){

        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.presenceOfElementLocated(HomeLocators.getBtnDemo()));

        getDriver().findElement(HomeLocators.getBtnDemo()).click();

        ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));

        new WebDriverWait(getDriver(), 15)
                .until(ExpectedConditions.presenceOfElementLocated(DemoLocators.getLabelDemo()));

        return getDriver().findElement(DemoLocators.getLabelDemo()).getText();

    }

}
