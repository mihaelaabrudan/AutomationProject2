package Tests.tests;

import Actions.Dashboard;
import Pages.Actions.Login;
import Pages.Actions.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

import java.time.Duration;

public class TrainingProgram extends BaseTest {

    private Login login = null;
    private Actions.Dashboard dashboard = null;
    private Register register = null;
    private RegisterUser registerUser = null;

    @Test
    public void openTrainingTab(){

        initTest ("Training Program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        registerUser = new RegisterUser();

        login();


    }

    private void login() {
        login.setuserEmail("miha.abrudan99999999@gmail.com");
        login.setuserPassword("1111");
        login.submitButton();

        if(login.errorForbiddenAccesText().equalsIgnoreCase("Access forbidden!")){
            register.registerUser(true);
        }

        /*WebDriverWait waitTime = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navigation__link userName']")));

        Assert.assertTrue(dashboard.getUserEmailFromDashBoard().equalsIgnoreCase("miha.abrudan@gmail.com"));
        */

    }
}
