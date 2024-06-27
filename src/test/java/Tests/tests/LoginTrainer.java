package Tests.tests;

import Pages.Actions.Dashboard;
import Pages.Actions.Login;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginTrainer extends BaseTest {

 private Login login = null;
 private Dashboard dashboard = null;

 @Test
 public void loginTrainer(){

  initTest("Login trainer");
  login = new Login(driver);
  dashboard = new Dashboard(driver);

  login.setuserEmail("miha.abrudan@gmail.com");
  login.setuserPassword("1111");
  login.submitButton();

  WebDriverWait waitTime = new WebDriverWait(driver, Duration.ofSeconds(10));
  waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navigation__link userName']")));

  Assert.assertTrue(dashboard.getUserEmailFromDashBoard().equalsIgnoreCase("miha.abrudan@gmail.com"));
 }
}
