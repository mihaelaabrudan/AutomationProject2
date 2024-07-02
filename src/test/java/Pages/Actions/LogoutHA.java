package Pages.Actions;

import Pages.WebElements.LogoutElementsHA;
import org.openqa.selenium.WebDriver;

public class LogoutHA {

    private LogoutElementsHA elements;

    public LogoutHA(WebDriver driver) {
        elements = new LogoutElementsHA(driver);
    }

    public void clickLogoutButton() {
        elements.logoutButton().click();
    }

    public boolean isLogoutButtonPresent() {
        return elements.logoutButton().isDisplayed();
    }
}