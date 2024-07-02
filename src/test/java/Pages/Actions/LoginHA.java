package Pages.Actions;

import Pages.WebElements.LoginElementsHA;
import org.openqa.selenium.WebDriver;
import utile.ConfigLoader;

public class LoginHA {

    private LoginElementsHA elements;
    private ConfigLoader configLoader;

    public LoginHA(WebDriver driver) {
        elements = new LoginElementsHA(driver);
        configLoader = new ConfigLoader("src/test/resources/propietati/dateUser2.properties");
    }

    public void setMyUsername(String myUsername) {
        elements.myUsername().sendKeys(myUsername);
    }

    public void setMyPassword(String myPassword) {
        elements.myPassword().sendKeys(myPassword);
    }

    public void clickLoginButton() {
        elements.loginButton().click();
    }

    public String getWelcomeText() {
        return elements.welcomeText().getText();
    }

    public boolean isWelcomeTextPresent() {
        return elements.isElementPresent(elements.welcomeTextLocator());
    }

    public boolean isErrorTitlePresent() {
        return elements.isElementPresent(elements.errorTitleLocator());
    }

    public boolean isErrorTextPresent() {
        return elements.isElementPresent(elements.errorTextLocator());
    }

    public void loginUser() {
        String myUsername = configLoader.getProperty("myusername");
        String myPassword = configLoader.getProperty("mypassword");

        setMyUsername(myUsername);
        setMyPassword(myPassword);
        clickLoginButton();
    }

    public String getFirstName() {
        return configLoader.getProperty("firstName");
    }

    public String getLastName() {
        return configLoader.getProperty("lastName");
    }

    public String getErrorTitle() {
        return elements.errorTitle().getText();
    }

    public String getErrorText() {
        return elements.errorText().getText();
    }
}