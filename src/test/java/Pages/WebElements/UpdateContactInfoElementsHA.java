package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateContactInfoElementsHA {
    private WebDriver driver;

    public UpdateContactInfoElementsHA(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement updateContactInfoLink() {
        return driver.findElement(By.linkText("Update Contact Info"));
    }

    public WebElement phoneNumberField() {
        return driver.findElement(By.id("customer.phoneNumber"));
    }

    public WebElement updateProfileButton() {
        return driver.findElement(By.cssSelector("input[type='button'].button[value='Update Profile']"));
    }

    public WebElement profileUpdatedTitle() {
        return driver.findElement(By.cssSelector("h1.title"));
    }


}