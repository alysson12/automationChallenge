package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

public class Commons {

    public static void sleep(Integer milisseconds){
        try {
            Thread.sleep(milisseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Properties loadProperties(Properties properties){

        properties = new Properties();
        try {
            properties.load(Commons.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar o arquivo de propriedades! " + e.getMessage(), e);
        }

        return properties;

    }

    public static void startDriver(){

        if (System.getProperty("os.name").equals("Linux")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        }
        else {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        }

    }

    public static void executeScreenshot(WebDriver driver){

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("target/print-evidence/screenshot-" + LocalDateTime.now() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
