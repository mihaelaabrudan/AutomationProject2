package Pages.Actions;

import Pages.WebElements.BillPayElementsHA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class BillPayHA {
    private BillPayElementsHA elements;  // Obiect care conține elementele web pentru pagina de Bill Pay
    private WebDriverWait wait;  // Obiect WebDriverWait pentru gestionarea așteptărilor explicite
    private ConfigLoader configLoader;  // Obiect ConfigLoader pentru încărcarea datelor de test din fișierul de configurare

    public BillPayHA(WebDriver driver) {
        elements = new BillPayElementsHA(driver);  // Inițializarea elementelor pentru pagina de Bill Pay
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Inițializarea WebDriverWait cu un timeout de 10 secunde
    }

    // Navighează către pagina de Bill Pay făcând click pe linkul corespunzător
    public void navigateToBillPay() {
        WebElement billPayLink = wait.until(ExpectedConditions.elementToBeClickable(elements.billPayLink()));  // Așteaptă ca linkul să fie clicabil
        billPayLink.click();  // Face click pe linkul de Bill Pay
    }

    // Introduce detaliile necesare pentru a efectua un plată de factură
    public void enterBillPayDetails() {
        configLoader = new ConfigLoader("src/test/resources/propietati/billPayDetails.properties");  // Încarcă detaliile de plată din fișierul de configurare

        // Completează câmpurile de input cu datele din fișierul de configurare
        wait.until(ExpectedConditions.visibilityOf(elements.payeeNameField())).sendKeys(configLoader.getProperty("payee.name"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeeAddressStreetField())).sendKeys(configLoader.getProperty("payee.address.street"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeeAddressCityField())).sendKeys(configLoader.getProperty("payee.address.city"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeeAddressStateField())).sendKeys(configLoader.getProperty("payee.address.state"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeeAddressZipCodeField())).sendKeys(configLoader.getProperty("payee.address.zipCode"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeePhoneNumberField())).sendKeys(configLoader.getProperty("payee.phoneNumber"));
        wait.until(ExpectedConditions.visibilityOf(elements.payeeAccountNumberField())).sendKeys(configLoader.getProperty("payee.accountNumber"));
        wait.until(ExpectedConditions.visibilityOf(elements.verifyAccountField())).sendKeys(configLoader.getProperty("verifyAccount"));
        wait.until(ExpectedConditions.visibilityOf(elements.amountField())).sendKeys(configLoader.getProperty("amount"));

        // Selectează contul din care se efectuează plata din dropdown
        Select fromAccountDropdown = new Select(elements.fromAccountDropdown());
        fromAccountDropdown.selectByValue(configLoader.getProperty("fromAccountId"));
    }

    // Face click pe butonul de trimitere a plății
    public void clickSendPaymentButton() {
        WebElement sendPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(elements.sendPaymentButton()));  // Așteaptă ca butonul să fie clicabil
        sendPaymentButton.click();  // Face click pe butonul de trimitere a plății
    }

    // Verifică dacă titlul de confirmare a plății este prezent pe pagină
    public boolean isPaymentCompleteTitlePresent() {
        try {
            WebElement paymentCompleteTitle = wait.until(ExpectedConditions.visibilityOf(elements.paymentCompleteTitle()));  // Așteaptă ca titlul să fie vizibil
            return paymentCompleteTitle.isDisplayed();  // Verifică dacă titlul este afișat
        } catch (Exception e) {
            return false;  // Returnează false dacă apare o excepție (titlul nu este prezent)
        }
    }

    // Verifică dacă detaliile plății afișate pe pagină sunt corecte
    public boolean verifyPaymentDetails() {
        configLoader = new ConfigLoader("src/test/resources/propietati/billPayDetails.properties");  // Încarcă detaliile de plată din fișierul de configurare
        String expectedPayeeName = configLoader.getProperty("payee.name");
        String expectedAmount = "$" + configLoader.getProperty("amount");
        String expectedFromAccountId = configLoader.getProperty("fromAccountId");

        try {
            // Verifică dacă detaliile plății afișate pe pagină corespund cu cele așteptate
            WebElement payeeNameResult = wait.until(ExpectedConditions.visibilityOf(elements.payeeNameResult()));
            WebElement amountResult = wait.until(ExpectedConditions.visibilityOf(elements.amountResult()));
            WebElement fromAccountIdResult = wait.until(ExpectedConditions.visibilityOf(elements.fromAccountIdResult()));

            return payeeNameResult.getText().equals(expectedPayeeName)
                    && amountResult.getText().equals(expectedAmount)
                    && fromAccountIdResult.getText().equals(expectedFromAccountId);
        } catch (Exception e) {
            return false;  // Returnează false dacă apare o excepție (detaliile nu sunt corecte)
        }
    }
}