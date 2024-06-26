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


        login = new Login(driver);
        register = new Register(driver);

        login.clickRegisterButton();
        Assert.assertTrue(register.getSignUpText().equalsIgnoreCase("Sign up"));

        register.registerUser(true);





       // login.setuserEmail("miha.abrudan@gmail.com");
      //  login.setuserPassword("1111");
       // login.submitButton();
       // Assert.assertTrue(login.getLoginText().equalsIgnoreCase("miha.abrudan@gmail.com"));



    }


}
