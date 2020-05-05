package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


@CucumberOptions(features="src/test/java/features" , glue="Stepdefinition")
public class Testrunner extends AbstractTestNGCucumberTests
{

}
