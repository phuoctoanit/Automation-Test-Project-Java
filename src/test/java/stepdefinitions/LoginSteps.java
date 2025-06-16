package stepdefinitions;

import drivers.WebDriverFactory;
import io.cucumber.java.en.*;
import managers.PageManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.UserFormPage;
import utils.EnvironmentLoader;
import utils.Logger;
import utils.ScenarioContext;

public class LoginSteps extends BaseDefinition{
    private UserFormPage userFormPage;

    public LoginSteps () {
        super();
        userFormPage = pageManager.getUserFormPage();
    }

    @Given("I am on open the user form page")
    public void iAmOnOpenTheUserFormPage() {
//        String baseURL = EnvironmentLoader.get("baseURL");
//        this.userFormPage = pageManager.getUserFormPage();
//        driver = WebDriverFactory.getDriver();
//        driver.get(baseURL);

        Assert.assertEquals(userFormPage.isLoad(), true);
    }

    @When("I enter the following data to the form")
    public void iEnterTheFollowingDataToTheForm() {
    }

    // other steps
    // other steps
}
