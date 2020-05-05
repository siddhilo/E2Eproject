package Academy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage
{
    WebDriver driver;
    private By navigatetologin=By.cssSelector("a[href*='sign_in'] span");
    private By text=By.cssSelector("[class='text-center'] h2");
    private By toolbar=By.cssSelector("ul[class*='navbar-right']");
    private By popup=By.xpath("//button[text()='NO THANKS']");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement gettitle()
    {
        return driver.findElement(text);
    }

    public WebElement gettool()
    {
        return driver.findElement(toolbar);
    }

    public WebElement navigateToLogin() throws InterruptedException
    {
      //WebDriverWait w=new WebDriverWait(driver,30);
      //w.until(ExpectedConditions.visibilityOfElementLocated(navigatetologin));
       Thread.sleep(3000);
        return driver.findElement(navigatetologin);
       // return
    }

    public List<WebElement> popup()
    {
        return driver.findElements(popup);
    }

}
