/*package Tests.tests;

import Pages.Actions.Dashboard;
import Pages.Actions.Login;
import Pages.Actions.Logout;
import Pages.Actions.Register;
import Pages.Actions.TrainingLink;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

import java.time.Duration;

public class TrainingProgram extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private RegisterUser registerUser = null;
    private TrainingLink trainingLink = null;
    private Logout logout = null;

    @Test
    public void openTrainingTab(){

        initTest ("Training Program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        registerUser = new RegisterUser();
        trainingLink = new TrainingLink(driver);
        logout = new Logout(driver);

        login();

        // After login or registration, click on the "Training" link
        trainingLink.clickTraining();

        // Click on the "Logout" link
        logout.clickLogout();




    }

    private void login() {
        login.setuserEmail("miha.abrudan99@gmail.com");
        login.setuserPassword("SuperSecretPassword!");
        login.submitButton();






        // Wait and check for error message
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorForbiddenAccess")));

        if(login.errorForbiddenAccessText().equalsIgnoreCase("Access forbidden!")){
            login.clickRegisterButton();
            register.registerUser(true);

            login.clickLoginButton();
            login.setuserEmail("mihaela.abrudan99@gmail.com");
            login.setuserPassword("SuperSecretPassword!");
            login.submitButton();



        }

        WebDriverWait waitTime = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navigation__link userName']")));
        Assert.assertTrue(dashboard.getUserEmailFromDashBoard().equalsIgnoreCase("mihaela.abrudan99@gmail.com"));

        // After login or registration, click on the "Training" link
        trainingLink.clickTraining();

        // Click on the "Logout" link
        logout.clickLogout();




    }
}

 */
package Tests.tests;

import Pages.Actions.Dashboard;
import Pages.Actions.Login;
import Pages.Actions.Logout;
import Pages.Actions.Register;
import Pages.Actions.TrainingLink;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

import java.time.Duration;

public class TrainingProgram extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private RegisterUser registerUser = null;
    private TrainingLink trainingLink = null;
    private Logout logout = null;

    @Test
    public void openTrainingTab() {
        initTest("Training Program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        registerUser = new RegisterUser();
        trainingLink = new TrainingLink(driver);
        logout = new Logout(driver);

        login();

        // After login or registration, click on the "Training" link
        trainingLink.clickTraining();

        // Click on the "Logout" link
        logout.clickLogout();
    }

    private void login() {
        login.setuserEmail("mihaela.abrudan99@gmail.com");
        login.setuserPassword("SuperSecretPassword!");
        login.submitButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            //Așteptați să apară fie mesajul de eroare, fie linkul de la tabloul de bord al utilizatorului
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.id("errorForbiddenAccess")),
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navigation__link userName']"))
            ));
        } catch (Exception e) {

            // Gestionează cazul în care niciun element nu apare
            System.out.println("Nici mesajul de eroare, nici adresa de mail nu au apărut în 10 secunde.");
        }

        if (isErrorPresent()) {
            login.clickRegisterButton();
            register.registerUser(true);

            login.clickLoginButton();
            login.setuserEmail("mihaela.abrudan99@gmail.com");
            login.setuserPassword("SuperSecretPassword!");
            login.submitButton();
        }

        WebDriverWait waitTime = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navigation__link userName']")));
        Assert.assertTrue(dashboard.getUserEmailFromDashBoard().equalsIgnoreCase("mihaela.abrudan99@gmail.com"));
    }

    private boolean isErrorPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorForbiddenAccess")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
