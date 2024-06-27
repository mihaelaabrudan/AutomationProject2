package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutElements {
    private WebDriver driver;

    public LogoutElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement logoutLink() {
        return driver.findElement(By.cssSelector(".navigation__link.logout"));
    }
}