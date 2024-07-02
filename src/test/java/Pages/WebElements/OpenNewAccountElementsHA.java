package Pages.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenNewAccountElementsHA {
    private WebDriver driver;

    public OpenNewAccountElementsHA(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement openAccountLink() {
        return driver.findElement(By.linkText("Open New Account"));
    }

    public WebElement accountTypeDropdown() {
        return driver.findElement(By.id("type"));
    }

    public WebElement fromAccountIdDropdown() {
        return driver.findElement(By.id("fromAccountId"));
    }

    public WebElement openAccountButton() {
        return driver.findElement(By.cssSelector("input.button[value='Open New Account']"));
    }

    public WebElement accountOpenedTitle() {
        return driver.findElement(By.cssSelector("h1.title"));
    }

    public WebElement accountOpenedMessage() {
        return driver.findElement(By.xpath("//p[contains(text(), 'Congratulations, your account is now open.')]"));
    }

    public WebElement newAccountId() {
        return driver.findElement(By.id("newAccountId"));
    }

    public WebElement accountsOverviewLink() {
        return driver.findElement(By.linkText("Accounts Overview"));
    }

    public WebElement getAccountOverviewLink(String accountId) {
        return driver.findElement(By.xpath("//a[@href='activity.htm?id=" + accountId + "']"));
    }
}