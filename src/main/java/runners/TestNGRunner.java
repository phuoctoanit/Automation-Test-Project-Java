package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.Allure;
import org.apache.commons.logging.Log;
import org.testng.annotations.*;
import utils.EnvironmentLoader;
import drivers.WebDriverFactory;
import utils.Logger;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
)

public class TestNGRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        Logger.info("Override Scenarios");
        return super.scenarios();
    }
    //private String baseUrl = null;

//    /**
//     *
//     * @param env
//     */
//    @BeforeSuite(alwaysRun = true)
//    @Parameters({"env"})
//    public void initEnvironment(String env) {
//        System.setProperty("env", env); // 👈 Critical
//        EnvironmentLoader.load(env);
//        baseUrl = EnvironmentLoader.get("baseURL");
//        Logger.info("Testing on environment: " + env + ", URL: " + baseUrl);
//    }

//    /**
//     * Initiation driver at before class driver
//     * @param browser
//     */
//    @BeforeClass(alwaysRun = true)
//    @Parameters("browser")
//    public void setUp(String browser) {
//        Logger.info("Before Scenario: Initiation web browser: " + browser);
//        System.setProperty("browser", browser);
//        WebDriverFactory.setBrowserName(browser);
//        WebDriverFactory.initWebDriver();
//
//        Logger.info("Checking driver at before class: " + WebDriverFactory.getDriver());
//
//        //String browser = System.getProperty("browser", "chrome"); // fallback default
//        String env = System.getProperty("env", "qa");
//        Logger.debug("DEBUG >>> BROWSER = " + browser);
//        Logger.debug("DEBUG >>> ENV = " + env);
//
//        Allure.parameter("Browser", browser);
//        Allure.parameter("Environment", env);
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDown() {
//        Logger.info("Before Scenario: Tear down web driver");
//        WebDriverFactory.quitDriver();
//    }
}
