package Pages.Actions;

import Pages.WebElements.RegisterElements;
import Pages.WebElements.RegisterElementsHA;
import org.openqa.selenium.WebDriver;
import utile.ConfigLoader;

public class RegisterHA {

    private RegisterElementsHA elementss = null;
    private ConfigLoader configLoader;

    public RegisterHA(WebDriver driver) {
        elementss = new RegisterElementsHA(driver);

    }

    public String getSignUpText(){
        return elementss.signUpText().getText();
    }

    public void clickRegisterButton(){
        elementss.registerButton().click();
    }


    public void setfirstname(String firstname) {
        elementss.firstname().sendKeys(firstname);

    }

    public void setlastname(String lastname) {
        elementss.lastname().sendKeys(lastname);

    }

    public void setaddress(String address) {
        elementss.address().sendKeys(address);
    }

    public void setcity(String city) {
        elementss.city().sendKeys(city);

    }

    public void setstate(String state) {
        elementss.state().sendKeys(state);

    }

    public void setzipCode(String zipCode) {
        elementss.zipCode().sendKeys(zipCode);

    }

    public void setphoneNumber(String phoneNumber) {
        elementss.phoneNumber().sendKeys(phoneNumber);

    }

    public void setssn(String ssn) {
        elementss.ssn().sendKeys(ssn);

    }

    public void setusername(String username) {
        elementss.username().sendKeys(username);

    }

    public void setpassword(String password) {
        elementss.password().sendKeys(password);

    }

    public void setconfirm(String confirm) {
        elementss.confirm().sendKeys(confirm);

    }

    public void submit() {
        elementss.submit().click();

    }

    public String getLoginText(){
        return elementss.loginText().getText();
    }



    public void registerUser(boolean isTrainer) {

        configLoader = new ConfigLoader("src/test/resources/propietati/dateUser2.properties");
        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String address = configLoader.getProperty("address");
        String city = configLoader.getProperty("city");
        String state = configLoader.getProperty("state");
        String zipCode = configLoader.getProperty("zipCode");
        String phoneNumber = configLoader.getProperty("phoneNumber");
        String ssn = configLoader.getProperty("ssn");
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String confirm = configLoader.getProperty("confirm");

        setfirstname(firstName);
        setlastname(lastName);
        setaddress(address);
        setcity(city);
        setstate(state);
        setzipCode(zipCode);
        setphoneNumber(phoneNumber);
        setssn(ssn);
        setusername(username);
        setpassword(password);
        setconfirm(confirm);
        submit();
    }




}