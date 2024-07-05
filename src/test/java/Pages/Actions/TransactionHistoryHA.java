package Pages.Actions;

import Pages.WebElements.TransactionHistoryElementsHA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransactionHistoryHA {
    private TransactionHistoryElementsHA elements;  // Obiect care conține elementele web pentru istoricul tranzacțiilor
    private WebDriverWait wait;  // Obiect pentru a aștepta condițiile specifice

    // Constructor care inițializează elementele și obiectul de așteptare
    public TransactionHistoryHA(WebDriver driver) {
        elements = new TransactionHistoryElementsHA(driver);  // Inițializează obiectul TransactionHistoryElementsHA pentru a accesa elementele de pe pagina de istoric al tranzacțiilor
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Inițializează WebDriverWait cu un timeout de 10 secunde
    }

    // Navighează la pagina de "Accounts Overview"
    public void navigateToAccountsOverview() {
        WebElement accountsOverviewLink = wait.until(ExpectedConditions.elementToBeClickable(elements.accountsOverviewLink()));  // Așteaptă ca linkul să fie disponibil pentru clic
        accountsOverviewLink.click();  // Face clic pe linkul "Accounts Overview"
    }

    // Selectează un cont pe baza ID-ului contului
    public void selectAccount(String accountId) throws InterruptedException {
        Thread.sleep(10000);  // Așteaptă 10 secunde pentru a permite încărcarea completă a paginii

        WebElement accountLink = wait.until(ExpectedConditions.elementToBeClickable(elements.accountLink(accountId)));  // Așteaptă ca linkul contului să fie disponibil pentru clic
        accountLink.click();  // Face clic pe linkul contului
    }

    // Selectează o tranzacție pe baza ID-ului tranzacției
    public void selectTransaction(String transactionId) throws InterruptedException {
        Thread.sleep(10000);  // Așteaptă 10 secunde pentru a permite încărcarea completă a paginii

        WebElement transactionLink = wait.until(ExpectedConditions.elementToBeClickable(elements.transactionLink(transactionId)));  // Așteaptă ca linkul tranzacției să fie disponibil pentru clic
        transactionLink.click();  // Face clic pe linkul tranzacției
    }

    // Verifică dacă descrierea tranzacției este prezentă pe pagină
    public boolean isTransactionDescriptionPresent() {
        try {
            WebElement transactionDescription = wait.until(ExpectedConditions.visibilityOf(elements.transactionDescription()));  // Așteaptă ca descrierea tranzacției să fie vizibilă
            return transactionDescription.isDisplayed();  // Verifică dacă descrierea tranzacției este afișată
        } catch (Exception e) {
            return false;  // Returnează false dacă apare o excepție
        }
    }

    // Verifică dacă suma tranzacției este prezentă pe pagină
    public boolean isTransactionAmountPresent() {
        try {
            WebElement transactionAmount = wait.until(ExpectedConditions.visibilityOf(elements.transactionAmount()));  // Așteaptă ca suma tranzacției să fie vizibilă
            return transactionAmount.isDisplayed();  // Verifică dacă suma tranzacției este afișată
        } catch (Exception e) {
            return false;  // Returnează false dacă apare o excepție
        }
    }
}