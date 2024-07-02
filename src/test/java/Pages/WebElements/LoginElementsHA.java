package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElementsHA {
    private WebDriver driver;

    public LoginElementsHA(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement myUsername() {
        return driver.findElement(By.cssSelector("input[type='text'].input[name='username']"));
    }

    public WebElement myPassword() {
        return driver.findElement(By.cssSelector("input[type='password'].input[name='password']"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.cssSelector("input[type='submit'].button[value='Log In']"));
    }

    public WebElement welcomeText() {
        return driver.findElement(By.cssSelector("p.smallText"));
    }

    public WebElement errorTitle() {
        return driver.findElement(By.cssSelector("h1.title"));
    }

    public WebElement errorText() {
        return driver.findElement(By.cssSelector("p.error"));
    }

    public By welcomeTextLocator() {
        return By.cssSelector("p.smallText");
    }

    public By errorTitleLocator() {
        return By.cssSelector("h1.title");
    }

    public By errorTextLocator() {
        return By.cssSelector("p.error");
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
}