package tests;

import org.junit.*;
import org.junit.runners.MethodSorters;
import pages.BasePage;
import pages.DemoPage;
import pages.HomePage;
import utils.Commons;

import java.util.Properties;

/**
 * The Test Class
 *
 * @author Alysson Pereira
 * @version 1.0
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCase {

    protected BasePage basePage = new BasePage();
    protected HomePage homePage = new HomePage(basePage.getDriver());
    protected DemoPage demoPage;

    protected static Properties properties = new Properties();

    public static String url = "";

    public static void parametrizeUrl(){

        properties = Commons.loadProperties(properties);
        url = properties.getProperty("urlAccess");

    }

    @BeforeClass
    public static void start(){

        utils.Commons.startDriver();
        parametrizeUrl();

    }

    @Before
    public void accessLoginPage(){ basePage.navigatePage(url); }

    @After
    public void closeNavigator() {
        basePage.closeNavigate();
    }

    @Test
    public void t1_executeClickMenuDemo(){

        String validator = homePage.executeMenuClickDemo();
        Assert.assertEquals(validator, "Demo");

    }

    @Test
    public void t2_executeScrollBottomPage(){

        demoPage = homePage.menuClick();
        demoPage.executeScrollBottomPage();
    }

    @Test
    public void t3_findLockedTopic(){

        demoPage = homePage.menuClick();
        demoPage.findLockedTopic();

    }

}
