package Pages.Actions;

import Pages.WebElements.UpdateContactInfoElementsHA;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class UpdateContactInfoHA {
    private UpdateContactInfoElementsHA elements;
    private ConfigLoader configLoader;
    private WebDriverWait wait;

    public UpdateContactInfoHA(WebDriver driver) {
        elements = new UpdateContactInfoElementsHA(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToUpdateContactInfo() {
        WebElement updateContactLink = wait.until(ExpectedConditions.elementToBeClickable(elements.updateContactInfoLink()));
        updateContactLink.click();
    }


    public void setNewPhoneNumber(String newPhoneNumber) {
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOf(elements.phoneNumberField()));

        // Clear the field until it's empty
        phoneNumberField.click();
        phoneNumberField.sendKeys(Keys.CONTROL + "a");
        phoneNumberField.sendKeys(Keys.DELETE);

        // Ensure the field is empty
        while (!phoneNumberField.getAttribute("value").isEmpty()) {
            phoneNumberField.sendKeys(Keys.CONTROL + "a");
            phoneNumberField.sendKeys(Keys.DELETE);
        }

        // Enter the new phone number
        phoneNumberField.sendKeys(newPhoneNumber);
    }


    public void clickUpdateProfileButton() {
        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(elements.updateProfileButton()));
        updateButton.click();
    }

    public boolean isProfileUpdatedTitlePresent() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOf(elements.profileUpdatedTitle()));
        return titleElement.isDisplayed();
    }

    public String getCurrentPhoneNumber() {
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOf(elements.phoneNumberField()));
        return phoneNumberField.getAttribute("value");
    }

    public void updateContactInfoUser() {
        configLoader = new ConfigLoader("src/test/resources/propietati/dateUpdateContactInfo.properties");
        String newPhoneNumber = configLoader.getProperty("newPhoneNumber");

        navigateToUpdateContactInfo();
        setNewPhoneNumber(newPhoneNumber);
        clickUpdateProfileButton();
    }
}