package Pages.Actions;

import Pages.WebElements.TransferFundsElementsHA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundsHA {
    private TransferFundsElementsHA elements;  // Obiect care conține elementele web pentru transferul de fonduri
    private WebDriverWait wait;  // Obiect pentru a aștepta condițiile specifice

    // Constructor care inițializează elementele și obiectul de așteptare
    public TransferFundsHA(WebDriver driver) {
        elements = new TransferFundsElementsHA(driver);  // Inițializează obiectul TransferFundsElementsHA pentru a accesa elementele de pe pagina de transfer de fonduri
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Inițializează WebDriverWait cu un timeout de 10 secunde
    }

    // Navighează la pagina de transfer de fonduri
    public void navigateToTransferFunds() {
        WebElement transferFundsLink = wait.until(ExpectedConditions.elementToBeClickable(elements.transferFundsLink()));  // Așteaptă ca linkul de transfer fonduri să fie disponibil pentru clic
        transferFundsLink.click();  // Face clic pe linkul de transfer de fonduri
    }

    // Introduce detaliile transferului
    public void enterTransferDetails(String amount, String fromAccount, String toAccount) {
        WebElement amountField = wait.until(ExpectedConditions.visibilityOf(elements.amountField()));  // Așteaptă ca câmpul de sumă să fie vizibil
        amountField.clear();  // Șterge valoarea existentă în câmpul de sumă
        amountField.sendKeys(amount);  // Introduce suma de transfer

        Select fromAccountDropdown = new Select(elements.fromAccountDropdown());  // Creează un obiect Select pentru dropdown-ul contului sursă
        fromAccountDropdown.selectByValue(fromAccount);  // Selectează contul sursă pe baza valorii

        Select toAccountDropdown = new Select(elements.toAccountDropdown());  // Creează un obiect Select pentru dropdown-ul contului destinație
        toAccountDropdown.selectByValue(toAccount);  // Selectează contul destinație pe baza valorii
    }

    // Face clic pe butonul de transfer
    public void clickTransferButton() {
        WebElement transferButton = wait.until(ExpectedConditions.elementToBeClickable(elements.transferButton()));  // Așteaptă ca butonul de transfer să fie disponibil pentru clic
        transferButton.click();  // Face clic pe butonul de transfer
    }

    // Verifică dacă mesajul de completare a transferului este prezent
    public boolean isTransferCompleteMessagePresent() {
        try {
            WebElement transferCompleteTitle = wait.until(ExpectedConditions.visibilityOf(elements.transferCompleteTitle()));  // Așteaptă ca titlul mesajului de completare a transferului să fie vizibil
            WebElement amountResult = wait.until(ExpectedConditions.visibilityOf(elements.amountResult()));  // Așteaptă ca suma transferată să fie vizibilă
            WebElement fromAccountIdResult = wait.until(ExpectedConditions.visibilityOf(elements.fromAccountIdResult()));  // Așteaptă ca ID-ul contului sursă să fie vizibil
            WebElement toAccountIdResult = wait.until(ExpectedConditions.visibilityOf(elements.toAccountIdResult()));  // Așteaptă ca ID-ul contului destinație să fie vizibil

            // Verifică dacă toate elementele sunt afișate și dacă titlul mesajului este corect
            return transferCompleteTitle.isDisplayed()
                    && transferCompleteTitle.getText().equals("Transfer Complete!")
                    && amountResult.isDisplayed()
                    && fromAccountIdResult.isDisplayed()
                    && toAccountIdResult.isDisplayed();
        } catch (Exception e) {
            return false;  // Returnează false dacă apare o excepție
        }
    }

    // Obține suma transferată din mesajul de completare a transferului
    public String getTransferAmount() {
        WebElement amountResult = wait.until(ExpectedConditions.visibilityOf(elements.amountResult()));  // Așteaptă ca suma transferată să fie vizibilă
        return amountResult.getText();  // Returnează textul care reprezintă suma transferată
    }

    // Obține ID-ul contului sursă din mesajul de completare a transferului
    public String getFromAccountId() {
        WebElement fromAccountIdResult = wait.until(ExpectedConditions.visibilityOf(elements.fromAccountIdResult()));  // Așteaptă ca ID-ul contului sursă să fie vizibil
        return fromAccountIdResult.getText();  // Returnează textul care reprezintă ID-ul contului sursă
    }

    // Obține ID-ul contului destinație din mesajul de completare a transferului
    public String getToAccountId() {
        WebElement toAccountIdResult = wait.until(ExpectedConditions.visibilityOf(elements.toAccountIdResult()));  // Așteaptă ca ID-ul contului destinație să fie vizibil
        return toAccountIdResult.getText();  // Returnează textul care reprezintă ID-ul contului destinație
    }
}