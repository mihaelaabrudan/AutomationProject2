package Tests;

import Pages.Actions.SimpleActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class SimpleTest  extends BaseTest {


    @Test
    public void firstTest(){
        initTest("Sample test");

        driver.get("http://apptest.go.ro:9999/login");
        //String expectedText = "LOGIN";

        String expectedText = "Login";

        SimpleActions simpleActions = new SimpleActions(driver);
        String loginText = simpleActions.getLoginText();
        //Assert.assertEquals(loginText, expectedText);

        Assert.assertEquals(loginText.toLowerCase(), expectedText.toLowerCase());

        Assert.assertTrue(loginText.equalsIgnoreCase(expectedText));
        /*evaluare intre doua string-uri care returneaza un boolean(True/False)
        .equalsIgnoreCase -> ignora daca textul este scris cu litere mari sau mici
         */

        System.out.println(loginText);
        System.out.println(expectedText);


        //expend basetest, functionalitate de report, functionalitate de login


    }
    @Test
    public void exampleTestReport() {
        initTest("Example Test Report");
        // Implementarea testului

        // Exemplu de aserțiune
        assert homePage != null;
    }


}
