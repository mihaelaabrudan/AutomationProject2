package Tests.tests;

import Pages.Actions.LoginHA;
import Pages.Actions.UpdateContactInfoHA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;
import utile.ConfigLoader;

import java.time.Duration;

public class UpdateContactInfoTest extends BaseTestHA {

    private LoginHA loginHA;
    private UpdateContactInfoHA updateContactInfoHA;

    @Test
    public void updateContactInfo() {
        initTest("Update Contact Info");
        loginHA = new LoginHA(driver);
        updateContactInfoHA = new UpdateContactInfoHA(driver);

        // Definește WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginHA.loginUser();

        // Navighează la secțiunea "Update Contact Info"
        updateContactInfoHA.updateContactInfoUser();

        // Obține așteptările din fișierul properties
        String expectedPhoneNumber = new ConfigLoader("src/test/resources/propietati/dateUpdateContactInfo.properties").getProperty("newPhoneNumber");

        // Obține valorile câmpurilor
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.phoneNumber")));

        // Verifică valorile câmpurilor
        Assert.assertEquals(phoneNumberField.getAttribute("value"), expectedPhoneNumber, "Numărul de telefon nu a fost actualizat corect!");
    }
}