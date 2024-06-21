package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElements {
    private WebDriver driver = null;

    public LoginElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement registerButton(){
        return driver.findElement(By.className("navigation__link"));

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


}
