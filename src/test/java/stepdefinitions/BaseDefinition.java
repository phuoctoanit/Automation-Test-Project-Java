package stepdefinitions;

import managers.PageManager;
import org.openqa.selenium.WebDriver;
import drivers.WebDriverFactory;
import utils.Logger;
import utils.ScenarioContext;

public abstract class BaseDefinition {

    protected WebDriver driver;
    protected PageManager pageManager;

    public BaseDefinition() {
        Logger.debug("Constructor parent Def");
        pageManager = (PageManager) ScenarioContext.get("pageManager");
        driver = WebDriverFactory.getDriver();
    }
}
