package Pages.Actions;

import Pages.WebElements.OpenNewAccountElementsHA;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utile.ConfigLoader;

import java.time.Duration;

public class OpenNewAccountHA {

    private OpenNewAccountElementsHA elements;  // Obiect care conține elementele web pentru deschiderea unui cont nou
    private WebDriverWait wait;  // Obiect pentru a aștepta elementele să fie vizibile sau clicabile
    private WebDriver driver;  // Driverul WebDriver utilizat pentru interacțiunea cu browserul

    // Constructor care inițializează elementele și obiectul WebDriverWait
    public OpenNewAccountHA(WebDriver driver) {
        elements = new OpenNewAccountElementsHA(driver);  // Inițializează obiectul OpenNewAccountElementsHA pentru a accesa elementele de pe pagina de deschidere a unui cont nou
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));  // Inițializează WebDriverWait cu un timeout de 15 secunde
        this.driver = driver;  // Salvează referința driver-ului
    }

    // Așteaptă ca pagina să se încarce complet verificând starea documentului
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));  // Așteaptă până când documentul este complet încărcat
    }

    // Navighează la pagina "Open New Account" făcând clic pe linkul corespunzător
    public void navigateToOpenNewAccount() {
        waitForPageToLoad();  // Asigură că pagina este complet încărcată
        WebElement openAccountLink = wait.until(ExpectedConditions.elementToBeClickable(elements.openAccountLink()));  // Așteaptă până când linkul este clicabil
        openAccountLink.click();  // Face clic pe linkul "Open New Account"
    }

    // Așteaptă ca dropdown-ul "Account Type" să fie vizibil
    public void waitForAccountTypeDropdown() {
        wait.until(ExpectedConditions.visibilityOf(elements.accountTypeDropdown()));  // Așteaptă până când dropdown-ul este vizibil
    }

    // Așteaptă ca dropdown-ul "From Account ID" să fie vizibil
    public void waitForFromAccountIdDropdown() {
        wait.until(ExpectedConditions.visibilityOf(elements.fromAccountIdDropdown()));  // Așteaptă până când dropdown-ul este vizibil
    }

    // Introduce detaliile pentru deschiderea unui cont nou
    public void enterNewAccountDetails(String accountType, String accountId) {
        waitForAccountTypeDropdown();  // Așteaptă ca dropdown-ul "Account Type" să fie vizibil
        Select accountTypeDropdown = new Select(elements.accountTypeDropdown());  // Creează un obiect Select pentru dropdown-ul "Account Type"
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='type']/option")));  // Așteaptă până când toate opțiunile sunt vizibile

        // Selectează tipul de cont prin textul vizibil
        accountTypeDropdown.selectByVisibleText(accountType);

        waitForFromAccountIdDropdown();  // Așteaptă ca dropdown-ul "From Account ID" să fie vizibil
        Select accountIdDropdown = new Select(elements.fromAccountIdDropdown());  // Creează un obiect Select pentru dropdown-ul "From Account ID"
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='fromAccountId']/option")));  // Așteaptă până când toate opțiunile sunt vizibile

        // Selectează ID-ul contului prin textul vizibil
        accountIdDropdown.selectByVisibleText(accountId);
    }

    // Face clic pe butonul "Open New Account"
    public void clickOpenNewAccountButton() {
        WebElement openAccountButton = wait.until(ExpectedConditions.elementToBeClickable(elements.openAccountButton()));  // Așteaptă până când butonul este clicabil
        openAccountButton.click();  // Face clic pe butonul "Open New Account"
    }

    // Verifică dacă titlul "Account Opened!" este prezent pe pagina curentă
    public boolean isAccountOpenedTitlePresent() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOf(elements.accountOpenedTitle()));  // Așteaptă până când titlul este vizibil
        return titleElement.isDisplayed() && titleElement.getText().equals("Account Opened!");  // Verifică dacă titlul este afișat și conține textul "Account Opened!"
    }

    // Verifică dacă mesajul "Account has been successfully opened" este prezent pe pagina curentă
    public boolean isAccountOpenedMessagePresent() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOf(elements.accountOpenedMessage()));  // Așteaptă până când mesajul este vizibil
        return messageElement.isDisplayed();  // Verifică dacă mesajul este afișat
    }

    // Obține ID-ul noului cont din elementul corespunzător
    public String getNewAccountId() {
        WebElement newAccountIdElement = wait.until(ExpectedConditions.visibilityOf(elements.newAccountId()));  // Așteaptă până când ID-ul noului cont este vizibil
        return newAccountIdElement.getText();  // Returnează textul (ID-ul contului)
    }

    // Navighează la pagina "Accounts Overview" făcând clic pe linkul corespunzător
    public void navigateToAccountsOverview() {
        WebElement accountsOverviewLink = wait.until(ExpectedConditions.elementToBeClickable(elements.accountsOverviewLink()));  // Așteaptă până când linkul este clicabil
        accountsOverviewLink.click();  // Face clic pe linkul "Accounts Overview"
    }

    // Verifică dacă noul cont apare în vizualizarea generală a conturilor
    public boolean isNewAccountPresentInOverview(String newAccountId) {
        WebElement newAccountOverviewElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getAccountOverviewLink(newAccountId)));  // Așteaptă până când elementul pentru noul cont este vizibil
        return newAccountOverviewElement.isDisplayed();  // Verifică dacă noul cont este afișat
    }

    // Creează un locator pentru linkul de vizualizare a contului folosind ID-ul noului cont
    public By getAccountOverviewLink(String newAccountId) {
        return By.xpath("//a[@href='activity.htm?id=" + newAccountId + "']");  // Returnează un locator XPath pentru linkul contului specificat
    }
}