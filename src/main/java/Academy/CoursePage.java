package Academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.Base;

public class CoursePage extends Base
{
    WebDriver driver;

    By coursename=By.id("search-courses");
    By search=By.id("search-course-button");

    public CoursePage(WebDriver driver)
    {
        this.driver = driver;
    }


    public WebElement setCoursename()
    {
        return driver.findElement(coursename);
    }
    public WebElement setsearch()
    {
        return driver.findElement(search);
    }
}
