package Pages.Actions;

import Pages.WebElements.OpenNewAccountElementsHA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class OpenNewAccountHA {
    private OpenNewAccountElementsHA elements;
    private WebDriverWait wait;
    private WebDriver driver;

    public OpenNewAccountHA(WebDriver driver) {
        elements = new OpenNewAccountElementsHA(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    public void navigateToOpenNewAccount() {
        WebElement openAccountLink = wait.until(ExpectedConditions.elementToBeClickable(elements.openAccountLink()));
        openAccountLink.click();
    }

    public void selectAccountType(String accountType) {
        WebElement accountTypeDropdown = wait.until(ExpectedConditions.visibilityOf(elements.accountTypeDropdown()));
        Select dropdown = new Select(accountTypeDropdown);
        dropdown.selectByVisibleText(accountType);
    }

    public void selectFromAccountId(String accountId) {
        WebElement fromAccountIdDropdown = wait.until(ExpectedConditions.visibilityOf(elements.fromAccountIdDropdown()));
        Select dropdown = new Select(fromAccountIdDropdown);
        dropdown.selectByVisibleText(accountId);
    }

    public void clickOpenNewAccountButton() {
        WebElement openAccountButton = wait.until(ExpectedConditions.elementToBeClickable(elements.openAccountButton()));
        openAccountButton.click();
    }

    public boolean isAccountOpenedTitlePresent() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOf(elements.accountOpenedTitle()));
        return titleElement.isDisplayed();
    }

    public boolean isAccountOpenedMessagePresent() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOf(elements.accountOpenedMessage()));
        return messageElement.isDisplayed();
    }

    public String getNewAccountId() {
        WebElement newAccountIdElement = wait.until(ExpectedConditions.visibilityOf(elements.newAccountId()));
        return newAccountIdElement.getText();
    }
    public void navigateToAccountsOverview() {
        WebElement accountsOverviewLink = wait.until(ExpectedConditions.elementToBeClickable(elements.accountsOverviewLink()));
        accountsOverviewLink.click();
    }


    public boolean isNewAccountPresentInOverview(String newAccountId) {
        WebElement newAccountOverviewElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@href='activity.htm?id=" + newAccountId + "']")
        ));
        return newAccountOverviewElement.isDisplayed();
    }


}