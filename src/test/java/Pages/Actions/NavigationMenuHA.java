package Pages.Actions;

import Pages.WebElements.NavigationMenuElementsHA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationMenuHA {

    private NavigationMenuElementsHA elements;  // Obiect care conține elementele web pentru meniul de navigare
    private WebDriverWait wait;  // Obiect pentru a aștepta elementele să fie vizibile sau clicabile
    private WebDriver driver;  // Driverul WebDriver utilizat pentru interacțiunea cu browserul

    // Constructor care inițializează elementele și obiectul WebDriverWait
    public NavigationMenuHA(WebDriver driver) {
        elements = new NavigationMenuElementsHA(driver);  // Inițializează obiectul NavigationMenuElementsHA pentru a accesa elementele din meniul de navigare
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Inițializează WebDriverWait cu un timeout de 10 secunde
        this.driver = driver;  // Salvează referința driver-ului
    }

    // Navighează la pagina "Open New Account" făcând clic pe linkul corespunzător
    public void navigateToOpenNewAccount() {
        WebElement openNewAccountLink = wait.until(ExpectedConditions.elementToBeClickable(elements.openNewAccountLink()));  // Așteaptă până când linkul este clicabil
        openNewAccountLink.click();  // Face clic pe linkul "Open New Account"
    }

    // Verifică dacă antetul "Open New Account" este prezent pe pagina curentă
    public boolean isOpenAccountHeaderPresent() {
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOf(elements.openAccountHeader()));  // Așteaptă până când antetul este vizibil
        return headerElement.isDisplayed();  // Verifică dacă antetul este afișat
    }

    // Obține URL-ul linkului "Open New Account"
    public String getOpenNewAccountLinkUrl() {
        WebElement link = wait.until(ExpectedConditions.visibilityOf(elements.openNewAccountLink()));  // Așteaptă până când linkul este vizibil
        return link.getAttribute("href");  // Returnează URL-ul linkului
    }

    // Navighează la pagina "Accounts Overview" făcând clic pe linkul corespunzător
    public void navigateToAccountsOverview() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(elements.accountsOverviewLink()));  // Așteaptă până când linkul este clicabil
        link.click();  // Face clic pe linkul "Accounts Overview"
    }

    // Verifică dacă antetul "Accounts Overview" este prezent pe pagina curentă
    public boolean isAccountsOverviewHeaderPresent() {
        WebElement header = wait.until(ExpectedConditions.visibilityOf(elements.accountsOverviewHeader()));  // Așteaptă până când antetul este vizibil
        return header.isDisplayed();  // Verifică dacă antetul este afișat
    }

    // Obține URL-ul linkului "Accounts Overview"
    public String getAccountsOverviewLinkUrl() {
        WebElement link = wait.until(ExpectedConditions.visibilityOf(elements.accountsOverviewLink()));  // Așteaptă până când linkul este vizibil
        return link.getAttribute("href");  // Returnează URL-ul linkului
    }

    // Navighează la pagina "Transfer Funds" făcând clic pe linkul corespunzător
    public void navigateToTransferFunds() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(elements.transferFundsLink()));  // Așteaptă până când linkul este clicabil
        link.click();  // Face clic pe linkul "Transfer Funds"
    }

    // Verifică dacă antetul "Transfer Funds" este prezent pe pagina curentă
    public boolean isTransferFundsHeaderPresent() {
        WebElement header = wait.until(ExpectedConditions.visibilityOf(elements.transferFundsHeader()));  // Așteaptă până când antetul este vizibil
        return header.isDisplayed();  // Verifică dacă antetul este afișat
    }

    // Obține URL-ul linkului "Transfer Funds"
    public String getTransferFundsLinkUrl() {
        WebElement link = wait.until(ExpectedConditions.visibilityOf(elements.transferFundsLink()));  // Așteaptă până când linkul este vizibil
        return link.getAttribute("href");  // Returnează URL-ul linkului
    }

    // Navighează la pagina "Bill Pay" făcând clic pe linkul corespunzător
    public void navigateToBillPay() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(elements.billPayLink()));  // Așteaptă până când linkul este clicabil
        link.click();  // Face clic pe linkul "Bill Pay"
    }

    // Verifică dacă antetul "Bill Payment Service" este prezent pe pagina curentă
    public boolean isBillPayHeaderPresent() {
        WebElement header = wait.until(ExpectedConditions.visibilityOf(elements.billPayHeader()));  // Așteaptă până când antetul este vizibil
        return header.isDisplayed();  // Verifică dacă antetul este afișat
    }

    // Obține URL-ul linkului "Bill Pay"
    public String getBillPayLinkUrl() {
        WebElement link = wait.until(ExpectedConditions.visibilityOf(elements.billPayLink()));  // Așteaptă până când linkul este vizibil
        return link.getAttribute("href");  // Returnează URL-ul linkului
    }

    // Navighează la pagina "Find Transactions" făcând clic pe linkul corespunzător
    public void navigateToFindTransactions() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(elements.findTransactionsLink()));  // Așteaptă până când linkul este clicabil
        link.click();  // Face clic pe linkul "Find Transactions"
    }

    // Verifică dacă antetul "Find Transactions" este prezent pe pagina curentă
    public boolean isFindTransactionsHeaderPresent() {
        WebElement header = wait.until(ExpectedConditions.visibilityOf(elements.findTransactionsHeader()));  // Așteaptă până când antetul este vizibil
        return header.isDisplayed();  // Verifică dacă antetul este afișat
    }

    // Obține URL-ul linkului "Find Transactions"
    public String getFindTransactionsLinkUrl() {
        WebElement link = wait.until(ExpectedConditions.visibilityOf(elements.findTransactionsLink()));  // Așteaptă până când linkul este vizibil
        return link.getAttribute("href");  // Returnează URL-ul linkului
    }

    // Navighează la pagina "Update Contact Info" făcând clic pe linkul corespunzător
    public void navigateToUpdateContactInfo() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(elements.updateContactInfoLink()));  // Așteaptă până când linkul este clicabil
        link.click();  // Face clic pe linkul "Update Contact Info"
    }

    // Verifică dacă antetul "Update Profile" este prezent pe pagina curentă
    public boolean isUpdateProfileHeaderPresent() {
        WebElement header = wait.until(ExpectedConditions.visibilityOf(elements.updateProfileHeader()));  // Așteaptă până când antetul este vizibil
        return header.isDisplayed();  // Verifică dacă antetul este afișat
    }

    // Obține URL-ul linkului "Update Contact Info"
    public String getUpdateContactInfoLinkUrl() {
        WebElement link = wait.until(ExpectedConditions.visibilityOf(elements.updateContactInfoLink()));  // Așteaptă până când linkul este vizibil
        return link.getAttribute("href");  // Returnează URL-ul linkului
    }

    // Navighează la pagina "Request Loan" făcând clic pe linkul corespunzător
    public void navigateToRequestLoan() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(elements.requestLoanLink()));  // Așteaptă până când linkul este clicabil
        link.click();  // Face clic pe linkul "Request Loan"
    }

    // Verifică dacă antetul "Apply for a Loan" este prezent pe pagina curentă
    public boolean isRequestLoanHeaderPresent() {
        WebElement header = wait.until(ExpectedConditions.visibilityOf(elements.requestLoanHeader()));  // Așteaptă până când antetul este vizibil
        return header.isDisplayed();  // Verifică dacă antetul este afișat
    }

    // Obține URL-ul linkului "Request Loan"
    public String getRequestLoanLinkUrl() {
        WebElement link = wait.until(ExpectedConditions.visibilityOf(elements.requestLoanLink()));  // Așteaptă până când linkul este vizibil
        return link.getAttribute("href");  // Returnează URL-ul linkului
    }

    // Obține URL-ul curent al paginii
    public String getCurrentUrl() {
        return driver.getCurrentUrl();  // Returnează URL-ul curent al paginii
    }
}