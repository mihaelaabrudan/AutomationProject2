package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionHistoryElementsHA {
    private WebDriver driver;

    public TransactionHistoryElementsHA(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement accountsOverviewLink() {
        return driver.findElement(By.linkText("Accounts Overview"));
    }

    public WebElement accountLink(String accountId) {
        return driver.findElement(By.xpath("//a[@href='activity.htm?id=" + accountId + "']"));
    }

    public WebElement transactionLink(String transactionId) {
        return driver.findElement(By.xpath("//a[@href='transaction.htm?id=" + transactionId + "']"));
    }

    public WebElement transactionDescription() {
        return driver.findElement(By.xpath("//td[text()='Bill Payment to Alexandra Pop']"));
    }

    public WebElement transactionAmount() {
        return driver.findElement(By.xpath("//td[text()='$2.00']"));
    }
}