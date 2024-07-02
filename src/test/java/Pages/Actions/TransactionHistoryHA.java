package Pages.Actions;

import Pages.WebElements.TransactionHistoryElementsHA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class TransactionHistoryHA {
    private TransactionHistoryElementsHA elements;
    private WebDriverWait wait;
    private ConfigLoader configLoader;

    public TransactionHistoryHA(WebDriver driver) {
        elements = new TransactionHistoryElementsHA(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToAccountsOverview() {
        WebElement accountsOverviewLink = wait.until(ExpectedConditions.elementToBeClickable(elements.accountsOverviewLink()));
        accountsOverviewLink.click();
    }

    public void selectAccount(String accountId) throws InterruptedException {
        // Așteptare de 10 secunde înainte de a selecta contul
        Thread.sleep(10000);

        WebElement accountLink = wait.until(ExpectedConditions.elementToBeClickable(elements.accountLink(accountId)));
        accountLink.click();
    }

    public void selectTransaction(String transactionId) throws InterruptedException  {
        Thread.sleep(10000);
        WebElement transactionLink = wait.until(ExpectedConditions.elementToBeClickable(elements.transactionLink(transactionId)));
        transactionLink.click();
    }

    public boolean isTransactionDescriptionPresent() {
        try {
            WebElement transactionDescription = wait.until(ExpectedConditions.visibilityOf(elements.transactionDescription()));
            return transactionDescription.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTransactionAmountPresent() {
        try {
            WebElement transactionAmount = wait.until(ExpectedConditions.visibilityOf(elements.transactionAmount()));
            return transactionAmount.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}