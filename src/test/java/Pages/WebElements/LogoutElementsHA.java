package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutElementsHA {
    private WebDriver driver;

    public LogoutElementsHA(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement logoutButton() {
        return driver.findElement(By.linkText("Log Out"));
    }

    public By logoutButtonLocator() {
        return By.linkText("Log Out");
    }
}