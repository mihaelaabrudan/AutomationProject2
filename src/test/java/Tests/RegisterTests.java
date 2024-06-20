package Tests;

import Pages.pages.HomePage;
import Pages.pages.RegisterPage;
import utile.BaseTest;
import org.testng.annotations.Test;

import java.util.Scanner;


public class RegisterTests extends BaseTest {
    protected HomePage homePage;

    @Test
    public void testSuccessfulSignUp() {
        initTest("testSuccessfulSignUp"); // Initialize ExtentTest
        // Creează o instanță a clasei HomePage
        HomePage homePage = new HomePage(driver);
        // Click pe link-ul 'Register' și navighează la RegisterPage
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.setfirstName("Mihaela");
        registerPage.setlastName("Abrudan");
        registerPage.setphoneNumber("0748291083");
        registerPage.setemail("mihaela.abrudan99@gmail.com");
        registerPage.setPassword("SuperSecretPassword!");
        registerPage.setcity("Cluj-Napoca");
        //registerPage.checkCustomer();

        // Citirea input-ului de la utilizator
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceți tipul de utilizator (customer/trainer): ");
        String userType = scanner.nextLine();


        // Bifează checkbox-ul corespunzător
        if (userType.equalsIgnoreCase("customer")) {
            System.out.println("Ați ales opțiunea: customer");
            registerPage.checkCustomer();
        } else if (userType.equalsIgnoreCase("trainer")) {
            System.out.println("Ați ales opțiunea: trainer");
            registerPage.checkTrainer();
        } else {
            System.out.println("Tip de utilizator necunoscut.");
        }
        //scanner.close();

        registerPage.submitForm();
    }


}
