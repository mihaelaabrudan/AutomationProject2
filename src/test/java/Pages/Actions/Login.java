package Pages.Actions;


import Pages.WebElements.LoginElements;
import org.openqa.selenium.WebDriver;

public class Login {
    private LoginElements element;

    public Login (WebDriver driver){

        this.element = new LoginElements(driver);
    }

    public void clickRegisterButton(){
        element.registerButton().click();
    }

    public void clickLoginButton(){
        element.loginButton().click();
    }



    public void setuserEmail(String userEmail){
        element.userEmail().sendKeys(userEmail);

    }

    public void setuserPassword(String userPassword){
        element.userPassword().sendKeys(userPassword);

    }
    public void submitButton(){
        element.submitButton().click();

    }

    public String errorForbiddenAccessText(){
        return element.errorForbiddenAccess().getText();
    }



}
