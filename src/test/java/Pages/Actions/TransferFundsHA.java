package Pages.Actions;

import Pages.WebElements.TransferFundsElementsHA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundsHA {
    private TransferFundsElementsHA elements;
    private WebDriverWait wait;

    public TransferFundsHA(WebDriver driver) {
        elements = new TransferFundsElementsHA(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Asigură-te că driver este inițializat corect
    }

    public void navigateToTransferFunds() {
        WebElement transferFundsLink = wait.until(ExpectedConditions.elementToBeClickable(elements.transferFundsLink()));
        transferFundsLink.click();
    }

    public void enterTransferDetails(String amount, String fromAccount, String toAccount) {
        WebElement amountField = wait.until(ExpectedConditions.visibilityOf(elements.amountField()));
        amountField.clear();
        amountField.sendKeys(amount);

        Select fromAccountDropdown = new Select(elements.fromAccountDropdown());
        fromAccountDropdown.selectByValue(fromAccount);

        Select toAccountDropdown = new Select(elements.toAccountDropdown());
        toAccountDropdown.selectByValue(toAccount);
    }

    public void clickTransferButton() {
        WebElement transferButton = wait.until(ExpectedConditions.elementToBeClickable(elements.transferButton()));
        transferButton.click();
    }

    public boolean isTransferCompleteMessagePresent() {
        try {
            WebElement transferCompleteTitle = wait.until(ExpectedConditions.visibilityOf(elements.transferCompleteTitle()));
            WebElement amountResult = wait.until(ExpectedConditions.visibilityOf(elements.amountResult()));
            WebElement fromAccountIdResult = wait.until(ExpectedConditions.visibilityOf(elements.fromAccountIdResult()));
            WebElement toAccountIdResult = wait.until(ExpectedConditions.visibilityOf(elements.toAccountIdResult()));

            return transferCompleteTitle.isDisplayed()
                    && transferCompleteTitle.getText().equals("Transfer Complete!")
                    && amountResult.isDisplayed()
                    && fromAccountIdResult.isDisplayed()
                    && toAccountIdResult.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getTransferAmount() {
        WebElement amountResult = wait.until(ExpectedConditions.visibilityOf(elements.amountResult()));
        return amountResult.getText();
    }

    public String getFromAccountId() {
        WebElement fromAccountIdResult = wait.until(ExpectedConditions.visibilityOf(elements.fromAccountIdResult()));
        return fromAccountIdResult.getText();
    }

    public String getToAccountId() {
        WebElement toAccountIdResult = wait.until(ExpectedConditions.visibilityOf(elements.toAccountIdResult()));
        return toAccountIdResult.getText();
    }
}