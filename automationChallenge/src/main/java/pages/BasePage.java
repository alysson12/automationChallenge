package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public BasePage(){
        this.driver = new FirefoxDriver();
    }

    public void navigatePage(String url){
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void closeNavigate(){
        getDriver().close();
    }
}
