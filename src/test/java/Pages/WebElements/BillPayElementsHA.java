package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillPayElementsHA {
    private WebDriver driver;

    public BillPayElementsHA(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement billPayLink() {
        return driver.findElement(By.linkText("Bill Pay"));
    }

    public WebElement payeeNameField() {
        return driver.findElement(By.name("payee.name"));
    }

    public WebElement payeeAddressStreetField() {
        return driver.findElement(By.name("payee.address.street"));
    }

    public WebElement payeeAddressCityField() {
        return driver.findElement(By.name("payee.address.city"));
    }

    public WebElement payeeAddressStateField() {
        return driver.findElement(By.name("payee.address.state"));
    }

    public WebElement payeeAddressZipCodeField() {
        return driver.findElement(By.name("payee.address.zipCode"));
    }

    public WebElement payeePhoneNumberField() {
        return driver.findElement(By.name("payee.phoneNumber"));
    }

    public WebElement payeeAccountNumberField() {
        return driver.findElement(By.name("payee.accountNumber"));
    }

    public WebElement verifyAccountField() {
        return driver.findElement(By.name("verifyAccount"));
    }

    public WebElement amountField() {
        return driver.findElement(By.name("amount"));
    }

    public WebElement fromAccountDropdown() {
        return driver.findElement(By.name("fromAccountId"));
    }

    public WebElement sendPaymentButton() {
        return driver.findElement(By.cssSelector("input.button[value='Send Payment']"));
    }

    public WebElement paymentSuccessMessage() {
        return driver.findElement(By.xpath("//h1[contains(text(),'Payment Complete')]"));
    }

    public WebElement paymentCompleteTitle() {
        return driver.findElement(By.xpath("//h1[contains(text(),'Bill Payment Complete')]"));
    }

    public WebElement payeeNameResult() {
        return driver.findElement(By.id("payeeName"));
    }

    public WebElement amountResult() {
        return driver.findElement(By.id("amount"));
    }

    public WebElement fromAccountIdResult() {
        return driver.findElement(By.id("fromAccountId"));
    }
}