package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferFundsElementsHA {
    private WebDriver driver;

    public TransferFundsElementsHA(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement transferFundsLink() {
        return driver.findElement(By.linkText("Transfer Funds"));
    }

    public WebElement amountField() {
        return driver.findElement(By.id("amount"));
    }

    public WebElement fromAccountDropdown() {
        return driver.findElement(By.id("fromAccountId"));
    }

    public WebElement toAccountDropdown() {
        return driver.findElement(By.id("toAccountId"));
    }

    public WebElement transferButton() {
        return driver.findElement(By.cssSelector("input[type='submit'].button[value='Transfer']"));
    }

    public WebElement transferCompleteTitle() {
        return driver.findElement(By.cssSelector("h1.title"));
    }

    public WebElement amountResult() {
        return driver.findElement(By.id("amountResult"));
    }

    public WebElement fromAccountIdResult() {
        return driver.findElement(By.id("fromAccountIdResult"));
    }

    public WebElement toAccountIdResult() {
        return driver.findElement(By.id("toAccountIdResult"));
    }
}