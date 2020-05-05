package Academy;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import resources.Base;
import java.io.IOException;


public class HomeTest extends Base
{
    WebDriver driver;
    static Logger log= LogManager.getLogger(HomeTest.class.getName());
    HomePage home;
    LoginPage login;

    public HomeTest(WebDriver driver) {
        this.driver = driver;
    }
    /*public void initBrowser() throws IOException, InterruptedException
    {
        log.debug("Before Test");
        driver=initializedriver();
        log.info("Driver initialized");
    }*/

    public void openApplicationURL(String url)
    {
        log.info("Open application");
        driver.get(url);
        //driver.get(prop.getProperty("url"));
    }


    public void navigateToUrl() throws InterruptedException
    {
        home=new HomePage(driver);
        log.info("Navigating to Login Page");
        home.navigateToLogin().click();
    }

    //@Test(dataProvider = "getData")
    public void provideLoginDetails(String username,String password) throws InterruptedException
    {
        login=new LoginPage(driver);
        login.getEmail().clear();
        login.getEmail().sendKeys(username);
        login.getPassword().clear();
        login.getPassword().sendKeys(password);
        login.getLogin().click();
        //log.info(text);
    }

    public boolean popupMethod()
    {
        home=new HomePage(driver);
        int size=home.popup().size();
        if(size>0)
        {
            home.popup().get(0).click();
            return true;
        }
        return false;
    }

    public void outputMessage(String val)
    {
        if(val.equals("true"))
            System.out.println("User logged In Successfully");
        else
            System.out.println("Login Failed");
    }
/*
    @DataProvider
    public Object[][] getData()
    {
        Object[][] ob=new Object[2][3];
        ob[0][0]="user1";
        ob[0][1]="pass1";
        ob[0][2]="UnauthorizedUser";
        ob[1][0]="user2";
        ob[1][1]="pass2";
        ob[1][2]="AuthorizedUser";
        return ob;
    }*/

    @AfterTest
    public void close()
    {
        driver.quit();
        log.info("driver closed successfully");
        driver=null;  //to reduce memory usage
    }
}
