package Stepdefinition;

import Academy.CourseTest;
import Academy.HomePage;
import Academy.HomeTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import resources.Base;

@RunWith(Cucumber.class)
public class stepdefinition extends Base
{
    HomeTest hom;
    CourseTest course;

    @Given("^User initiates chrome browser$")
    public void user_initiates_chrome_browser() throws Throwable {
        //log.debug("Before Test");
        driver=initializedriver();
        hom=new HomeTest(driver);
        course=new CourseTest(driver);
        //log.info("Driver initialized");
    }

    @When("^User provides username: (.+) and password: (.+) and clicks on login$")
    public void user_provides_username_and_password_and_clicks_on_login(String username, String password) throws Throwable {
        hom.provideLoginDetails(username,password);
    }

    @Then("^User is successfully logged in (.+)$")
    public void user_is_successfully_logged_in(String value) throws Throwable {
        if(value.equals("true"))
            course.searchCourse();
        else
            System.out.println("Invalid credentials");
    }

    @And("^User opens application url :\"([^\"]*)\"$")
    public void user_opens_application_url_something(String strArg1) throws Throwable {
        hom.openApplicationURL(strArg1);
    }

    @And("^Navigates to LoginPage$")
    public void navigates_to_loginpage() throws Throwable {
        if(hom.popupMethod())
        {
            System.out.println("Popup displayed");
        }
        hom.navigateToUrl();
    }

    @And("^closes the browser$")
    public void closes_the_browser() throws Throwable {
        driver.quit();
    }

}
