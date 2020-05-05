package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class NavigationTest extends Base
{
    static Logger log=LogManager.getLogger(NavigationTest.class.getName());
    HomePage home;
    @BeforeTest
    public void init() throws IOException, InterruptedException
    {
        log.debug("Before Test");
        driver=initializedriver();
        log.info("Driver initialized");
        driver.get(prop.getProperty("url"));
        Thread.sleep(3000);
        log.info("Navigating to URL");
        home=new HomePage(driver);
    }
    @Test
    public void navigateTitle() throws IOException
    {

        Assert.assertEquals(home.gettitle().getText(), "FEATURED COURSES");
        log.info("Title displayed successfully");
    }

    @Test
    public void navigatetoolbar() throws IOException
    {
        Assert.assertTrue(home.gettool().isDisplayed());
        log.info("Toolbar displayed");
    }

    @AfterTest
    public void close()
    {
        driver.close();
        log.info("driver closed successfully");
        driver=null;  //to reduce memory usage
    }
}
