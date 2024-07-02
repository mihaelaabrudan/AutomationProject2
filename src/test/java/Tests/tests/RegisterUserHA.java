package Tests.tests;

import Pages.Actions.Login;
import Pages.Actions.Register;
import Pages.Actions.RegisterHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.BaseTestHA;

public class RegisterUserHA extends BaseTestHA {

    // private Login login = null;
    private RegisterHA registerHA = null;

    @Test
    public void registerUser() {

        initTest("Register User");


        // login = new Login(driver);
        registerHA = new RegisterHA(driver);


        registerHA.clickRegisterButton();
        Assert.assertTrue(registerHA.getSignUpText().equalsIgnoreCase("Signing up is easy!"));


        registerHA.registerUser(true);
        Assert.assertTrue(registerHA.getLoginText().equalsIgnoreCase("Welcome mihaabrudan"));
    }


}