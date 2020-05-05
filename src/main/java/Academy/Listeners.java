package Academy;

import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;

import java.io.IOException;

public class Listeners extends Base implements ITestListener
{
    @Override
    public void onTestFailure(ITestResult result)
    {
        try
        {
            getScreenshot(result.getName());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
