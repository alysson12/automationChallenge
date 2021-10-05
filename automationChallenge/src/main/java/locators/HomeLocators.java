package locators;

import org.openqa.selenium.By;

public class HomeLocators {

    public static By btnDemo = By.xpath("/html/body/nav/ul/li[4]/a");

    public static By getBtnDemo() {
        return btnDemo;
    }
}
