package managers;

import org.openqa.selenium.WebDriver;
import pages.UserFormPage;

public class PageManager {
    //private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private UserFormPage userFormPage;
    private WebDriver driver;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public UserFormPage getUserFormPage() {
        if(this.userFormPage == null) {
            this.userFormPage = new UserFormPage(this.driver);
        }
        return userFormPage;
    }
}
