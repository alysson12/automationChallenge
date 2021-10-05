package locators;

import org.openqa.selenium.By;

public class DemoLocators {

    public static By labelDemo = By.id("site-text-logo");
    public static By iconLocked = By.xpath("//div[@class=\"topic-statuses\"]//span[@title=\"This topic is closed; it no longer accepts new replies\"]");

    public static By getLabelDemo() {
        return labelDemo;
    }

    public static By getIconLocked() {
        return iconLocked;
    }

}
