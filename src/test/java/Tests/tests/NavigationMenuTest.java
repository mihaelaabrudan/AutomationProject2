package Tests.tests;

import Pages.Actions.LoginHA;
import Pages.Actions.NavigationMenuHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTestHA;

public class NavigationMenuTest extends BaseTestHA {
    private LoginHA loginHA;
    private NavigationMenuHA navigationMenuHA;

    @Test
    public void testNavigationMenu() {
        initTest("Navigation Menu Test");
        loginHA = new LoginHA(driver);
        navigationMenuHA = new NavigationMenuHA(driver);

        // Autentificare
        loginHA.loginUser();

        // Navighează la "Open New Account"
        navigationMenuHA.navigateToOpenNewAccount();
        // Verifică dacă pagina corespunzătoare este afișată și dacă apare textul specificat
        boolean isHeaderPresent = navigationMenuHA.isOpenAccountHeaderPresent();
        Assert.assertTrue(isHeaderPresent, "Textul 'Open New Account' nu este prezent!");
        // Verifică dacă URL-ul se regăsește pe pagina deschisă
        String openNewAccountUrl = navigationMenuHA.getOpenNewAccountLinkUrl();
        String currentUrl = navigationMenuHA.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(openNewAccountUrl), "URL-ul paginii nu conține 'openaccount.htm'!");

        /// Navighează la secțiunea "Accounts Overview"
        navigationMenuHA.navigateToAccountsOverview();
        // Verifică dacă textul "Accounts Overview" este prezent
        Assert.assertTrue(navigationMenuHA.isAccountsOverviewHeaderPresent(), "Textul 'Accounts Overview' nu este prezent!");
        // Verifică dacă URL-ul se regăsește pe pagina deschisă
        String accountsOverviewUrl = navigationMenuHA.getAccountsOverviewLinkUrl();
        currentUrl = navigationMenuHA.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(accountsOverviewUrl), "URL-ul paginii nu conține 'overview.htm'!");

        // Navighează la secțiunea "Transfer Funds"
        navigationMenuHA.navigateToTransferFunds();
        // Verifică dacă textul "Transfer Funds" este prezent
        Assert.assertTrue(navigationMenuHA.isTransferFundsHeaderPresent(), "Textul 'Transfer Funds' nu este prezent!");
        // Verifică dacă URL-ul se regăsește pe pagina deschisă
        String transferFundsUrl = navigationMenuHA.getTransferFundsLinkUrl();
        currentUrl = navigationMenuHA.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(transferFundsUrl), "URL-ul paginii nu conține 'transfer.htm'!");

        // Navighează la secțiunea "Bill Pay"
        navigationMenuHA.navigateToBillPay();
        // Verifică dacă textul "Bill Payment Service" este prezent
        Assert.assertTrue(navigationMenuHA.isBillPayHeaderPresent(), "Textul 'Bill Payment Service' nu este prezent!");
        // Verifică dacă URL-ul se regăsește pe pagina deschisă
        String billPayUrl = navigationMenuHA.getBillPayLinkUrl();
        currentUrl = navigationMenuHA.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(billPayUrl), "URL-ul paginii nu conține 'billpay.htm'!");

        // Navighează la secțiunea "Find Transactions"
        navigationMenuHA.navigateToFindTransactions();
        // Verifică dacă textul "Find Transactions" este prezent
        Assert.assertTrue(navigationMenuHA.isFindTransactionsHeaderPresent(), "Textul 'Find Transactions' nu este prezent!");
        // Verifică dacă URL-ul se regăsește pe pagina deschisă
        String findTransactionsUrl = navigationMenuHA.getFindTransactionsLinkUrl();
        currentUrl = navigationMenuHA.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(findTransactionsUrl), "URL-ul paginii nu conține 'findtrans.htm'!");

        // Navighează la secțiunea "Update Contact Info"
        navigationMenuHA.navigateToUpdateContactInfo();
        // Verifică dacă textul "Update Contact Info" este prezent
        Assert.assertTrue(navigationMenuHA.isUpdateProfileHeaderPresent(), "Textul 'Update Profile' nu este prezent!");
        // Verifică dacă URL-ul se regăsește pe pagina deschisă
        String findUpdateContactUrl = navigationMenuHA.getUpdateContactInfoLinkUrl();
        currentUrl = navigationMenuHA.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(findUpdateContactUrl), "URL-ul paginii nu conține 'findtrans.htm'!");

        // Navighează la secțiunea "Request Loan"
        navigationMenuHA.navigateToRequestLoan();
        // Verifică dacă textul "Request Loan" este prezent
        Assert.assertTrue(navigationMenuHA.isRequestLoanHeaderPresent(), "Textul 'Apply for a Loan' nu este prezent!");
        // Verifică dacă URL-ul se regăsește pe pagina deschisă
        String findRequestLoanUrl = navigationMenuHA.getRequestLoanLinkUrl();
        currentUrl = navigationMenuHA.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(findRequestLoanUrl), "URL-ul paginii nu conține 'findtrans.htm'!");

        // Navighează la secțiunea "Request Loan"
        navigationMenuHA.navigateToRequestLoan();
        // Verifică dacă textul "Apply for a Loan" este prezent
        Assert.assertTrue(navigationMenuHA.isRequestLoanHeaderPresent(), "Textul 'Apply for a Loan' nu este prezent!");
        // Verifică dacă URL-ul se regăsește pe pagina deschisă
        String requestLoanUrl = navigationMenuHA.getRequestLoanLinkUrl();
        currentUrl = navigationMenuHA.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(requestLoanUrl), "URL-ul paginii nu conține 'requestloan.htm'!");


    }

}