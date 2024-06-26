package Pages.Actions;

import Pages.WebElements.RegisterElements;
import org.openqa.selenium.WebDriver;

public class Register {

    private RegisterElements elements = null;

    public Register(WebDriver driver){
        elements = new RegisterElements(driver);

    }

    public String getSignUpText(){
        return elements.signuUpText().getText();
    }

    public void setfirstname(String firstname){
        elements.firstname().sendKeys(firstname);

    }

    public void setlastname(String lastname){
        elements.lastname().sendKeys(lastname);

    }

    public void setphoneNumber(String phoneNumber){
        elements.phoneNumber().sendKeys(phoneNumber);

    }

    public void setemail(String email){
        elements.email().sendKeys(email);

    }
    public void setpassword(String password){
        elements.password().sendKeys(password);

    }

    public void setcity(String city){
        elements.city().sendKeys(city);

    }

    public void customer(){
        elements.customer().click();

    }

    public void trainer(){
        elements.trainer().click();

    }


    public void clickSubmitButton(){
        elements.submit().click();

    }


}
