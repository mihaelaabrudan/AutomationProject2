package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginElements {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginElements(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement registerButton(){
        return driver.findElement(By.className("navigation__link"));

    }



    public WebElement loginButton(){
        return driver.findElement(By.cssSelector(".navigation__link.login"));

    }

    public WebElement LoginText(){
        return driver.findElement(By.id("userNameDisplay"));

    }

    public WebElement userEmail(){
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement userPassword(){
        return driver.findElement(By.id("userPassword"));
    }

    public WebElement submitButton(){
        return driver.findElement(By.id("submitButton"));
    }

    public WebElement errorForbiddenAccess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorForbiddenAccess")));
        return driver.findElement(By.id("errorForbiddenAccess"));
    }




}
