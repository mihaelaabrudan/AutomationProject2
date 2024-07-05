package Tests.tests;

import Pages.Actions.Login;
import Pages.Actions.Register;
import Pages.Actions.RegisterHA;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.BaseTestHA;

public class RegisterUserHA extends BaseTestHA {

    // Instanță a clasei RegisterHA pentru acțiunile de înregistrare
    private RegisterHA registerHA = null;

    // Metoda de test pentru înregistrarea unui nou utilizator
    @Test
    public void registerUser() {

        // Inițializează testul cu un nume descriptiv
        initTest("Register User");

        // Creează o instanță a clasei RegisterHA folosind driver-ul
        registerHA = new RegisterHA(driver);

        // Face clic pe butonul "Register" pentru a accesa formularul de înregistrare
        registerHA.clickRegisterButton();

        // Verifică dacă textul de semnare "Signing up is easy!" este prezent pe pagina de înregistrare
        Assert.assertTrue(registerHA.getSignUpText().equalsIgnoreCase("Signing up is easy!"),
                "Textul de semnare nu este corect! Așteptat: 'Signing up is easy!'");

        // Execută înregistrarea unui nou utilizator folosind metoda registerUser()
        // Parametrul 'true' indică faptul că trebuie să fie efectuată înregistrarea cu succes
        registerHA.registerUser(true);

        // Verifică dacă textul de bun venit conține numele de utilizator așteptat
        Assert.assertTrue(registerHA.getLoginText().equalsIgnoreCase("Welcome miha.abrudan"),
                "Textul de bun venit nu este corect! Așteptat: 'Welcome miha.abrudan'");
    }
}