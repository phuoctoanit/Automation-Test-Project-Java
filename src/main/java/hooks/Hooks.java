package hooks;

import io.cucumber.java.*;
import io.qameta.allure.Allure;
import managers.PageManager;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import reporting.AllureEnvironmentWriter;
import utils.EnvironmentLoader;
import drivers.WebDriverFactory;
import utils.Logger;
import utils.ScenarioContext;

public class Hooks {

    private WebDriver driver;
    private PageManager pageManager;

    @Before
    public void setUp(Scenario scenario) {
        Logger.info("--Starting scenario: " + scenario.getName());

        //Get browser and environment from system property
        String browser = System.getProperty("browser", "chrome"); // fallback default
        String env = System.getProperty("env", "qa");

        //Initiation Load environment
        EnvironmentLoader.load(env);

        //Update on Allure reporting
        Allure.parameter("Browser", browser);
        Allure.parameter("Environment", env);
        AllureEnvironmentWriter.writeEnvironmentInfo(browser, env, EnvironmentLoader.get("baseURL"));

        //Initiation driver
        WebDriverFactory.setBrowserName(browser);
        WebDriverFactory.initWebDriver();

        driver = WebDriverFactory.getDriver();
        pageManager = new PageManager(driver);

        ScenarioContext.set("pageManager", pageManager);

        //Open page on starting of scenario
        driver.get(EnvironmentLoader.get("baseURL"));
    }

    @After
    public void tearDown(Scenario scenario) {
        Logger.info("--Complete scenario: " + scenario.getName());
        WebDriverFactory.quitDriver();
    }
}
