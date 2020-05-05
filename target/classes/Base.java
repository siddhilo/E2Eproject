package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base
{
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializedriver() throws IOException
    {
        prop=new Properties();
        FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        prop.load(fi);
        String browserName=prop.getProperty("browser")  ;
       // String browserName=System.getProperty("browser");
        if(browserName.contains("chrome")) //if equals() -used to compare values of objects
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
            ChromeOptions option=new ChromeOptions();
            if(browserName.contains("headless"))
                option.addArguments("headless","user-agent=mrbean");
            driver=new ChromeDriver(option);
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","");
            driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("IE"))
        {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            capabilities.setCapability("nativeEvents",false);
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
            driver=new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        return driver;
    }

    public void getScreenshot(String nameofFile) throws IOException
    {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\SIDDHI SURANGE\\Documents\\Project\\Failedscreenshots\\"+nameofFile+"screenshot.png"));
    }
}
