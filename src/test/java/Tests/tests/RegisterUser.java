package Tests.tests;

import Pages.Actions.Login;
import Pages.Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class RegisterUser extends BaseTest {

    private Login login = null;
    private Register register = null;

 @Test
    public void registerUser(){

        initTest("Register User");

        driver.get("http://apptest.go.ro:9999/login");
        login = new Login(driver);
        register = new Register(driver);

        login.clickRegisterButton();
        Assert.assertTrue(register.getSignUpText().equalsIgnoreCase("Sign up"));
        register.setfirstname("Mihaela");
        register.setlastname("Abrudan");
        register.setphoneNumber("00000123");
        register.setemail("miha.abrudan@gmail.com");
        register.setcity("Cluj-Napoca");
        register.setpassword("1111");
        register.customer();
        register.clickSubmitButton();




        login.setuserEmail("miha.abrudan@gmail.com");
        login.setuserPassword("1111");
        login.submitButton();
        Assert.assertTrue(login.getLoginText().equalsIgnoreCase("miha.abrudan@gmail.com"));



    }


}
