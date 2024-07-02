package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterElementsHA {
    private WebDriver driver = null;

    public RegisterElementsHA(WebDriver driver){
        this.driver = driver;
    }

    public WebElement signUpText(){
        return driver.findElement(By.xpath("//h1"));

    }



    public WebElement registerButton(){
        return driver.findElement(By.linkText("Register"));

    }


    public WebElement firstname(){
        return driver.findElement(By.id("customer.firstName"));
    }

    public WebElement lastname(){
        return driver.findElement(By.id("customer.lastName"));
    }

    public WebElement address(){
        return driver.findElement(By.id("customer.address.street"));
    }

    public WebElement city(){
        return driver.findElement(By.id("customer.address.city"));
    }

    public WebElement state(){
        return driver.findElement(By.id("customer.address.state"));
    }

    public WebElement zipCode(){
        return driver.findElement(By.id("customer.address.zipCode"));
    }

    public WebElement phoneNumber(){
        return driver.findElement(By.id("customer.phoneNumber"));
    }

    public WebElement ssn(){
        return driver.findElement(By.id("customer.ssn"));
    }

    public WebElement username(){
        return driver.findElement(By.id("customer.username"));
    }

    public WebElement password(){
        return driver.findElement(By.id("customer.password"));
    }

    public WebElement confirm(){
        return driver.findElement(By.id("repeatedPassword"));
    }

    public WebElement submit(){
        return driver.findElement(By.cssSelector("input[type='submit'].button[value='Register']"));
    }

    public WebElement loginText(){
        return driver.findElement(By.xpath("//h1"));

    }


}
