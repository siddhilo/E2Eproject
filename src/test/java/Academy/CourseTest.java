package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import resources.Base;

import java.io.IOException;

public class CourseTest extends Base
{
    WebDriver driver;
    static Logger log= LogManager.getLogger(HomeTest.class.getName());
    CoursePage course;

    public CourseTest(WebDriver driver)
    {
        this.driver = driver;
    }
    /*public void initBrowser() throws IOException, InterruptedException
    {
        log.debug("Before Test");
        driver=initializedriver();
        log.info("Driver initialized");
    }*/

    public void searchCourse()
    {
       course=new CoursePage(driver);
        Assert.assertTrue(course.setCoursename().isDisplayed());
       //course.setsearch().click();
    }
}
