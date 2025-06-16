package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Logger;

public class UserFormPage extends BasePage {

    private WebElement firstNameEle;
    private WebElement lastNameEle;

    public UserFormPage(WebDriver driver) {
        super(driver);
    }

    public void inputFormData(String data) {
        Logger.info("Inputting form data....");
        firstNameEle = driver.findElement(By.id("firstName"));
        this.firstNameEle.sendKeys(data);
    }

    public boolean isLoad() {
        return driver.findElement(By.id("firstName")).isDisplayed();
    }
}
