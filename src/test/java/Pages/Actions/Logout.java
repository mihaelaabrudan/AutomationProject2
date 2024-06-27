package Pages.Actions;

import Pages.WebElements.LogoutElements;
import org.openqa.selenium.WebDriver;

public class Logout {

    private LogoutElements elements;

    public Logout(WebDriver driver) {
        this.elements = new LogoutElements(driver);
    }

    public void clickLogout() {
        elements.logoutLink().click();
    }
}