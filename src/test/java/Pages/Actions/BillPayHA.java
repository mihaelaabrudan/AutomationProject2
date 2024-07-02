package Pages.Actions;

import Pages.WebElements.BillPayElementsHA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class BillPayHA {
    private BillPayElementsHA elements;
    private WebDriverWait wait;
    private ConfigLoader configLoader;

    public BillPayHA(WebDriver driver) {
        elements = new BillPayElementsHA(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToBillPay() {
        WebElement billPayLink = wait.until(ExpectedConditions.elementToBeClickable(elements.billPayLink()));
        billPayLink.click();
    }

    public void enterBillPayDetails() {
        configLoader = new ConfigLoader("src/test/resources/propietati/billPayDetails.properties");

        wait.until(ExpectedConditions.visibilityOf(elements.payeeNameField())).sendKeys(configLoader.getProperty("payee.name"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeeAddressStreetField())).sendKeys(configLoader.getProperty("payee.address.street"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeeAddressCityField())).sendKeys(configLoader.getProperty("payee.address.city"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeeAddressStateField())).sendKeys(configLoader.getProperty("payee.address.state"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeeAddressZipCodeField())).sendKeys(configLoader.getProperty("payee.address.zipCode"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeePhoneNumberField())).sendKeys(configLoader.getProperty("payee.phoneNumber"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeeAccountNumberField())).sendKeys(configLoader.getProperty("payee.accountNumber"));
        wait.until(ExpectedConditions.visibilityOf(elements.verifyAccountField())).sendKeys(configLoader.getProperty("verifyAccount"));
        wait.until(ExpectedConditions.visibilityOf(elements.amountField())).sendKeys(configLoader.getProperty("amount"));

        Select fromAccountDropdown = new Select(elements.fromAccountDropdown());
        fromAccountDropdown.selectByValue(configLoader.getProperty("fromAccountId"));
    }

    public void clickSendPaymentButton() {
        WebElement sendPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(elements.sendPaymentButton()));
        sendPaymentButton.click();
    }

    public boolean isPaymentSuccessMessagePresent() {
        try {
            WebElement paymentSuccessMessage = wait.until(ExpectedConditions.visibilityOf(elements.paymentSuccessMessage()));
            return paymentSuccessMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPaymentCompleteTitlePresent() {
        try {
            WebElement paymentCompleteTitle = wait.until(ExpectedConditions.visibilityOf(elements.paymentCompleteTitle()));
            return paymentCompleteTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyPaymentDetails() {
        configLoader = new ConfigLoader("src/test/resources/propietati/billPayDetails.properties");
        String expectedPayeeName = configLoader.getProperty("payee.name");
        String expectedAmount = "$" + configLoader.getProperty("amount");
        String expectedFromAccountId = configLoader.getProperty("fromAccountId");

        try {
            WebElement payeeNameResult = wait.until(ExpectedConditions.visibilityOf(elements.payeeNameResult()));
            WebElement amountResult = wait.until(ExpectedConditions.visibilityOf(elements.amountResult()));
            WebElement fromAccountIdResult = wait.until(ExpectedConditions.visibilityOf(elements.fromAccountIdResult()));

            return payeeNameResult.getText().equals(expectedPayeeName)
                    && amountResult.getText().equals(expectedAmount)
                    && fromAccountIdResult.getText().equals(expectedFromAccountId);
        } catch (Exception e) {
            return false;
        }
    }
}