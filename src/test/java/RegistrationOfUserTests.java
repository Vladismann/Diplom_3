import PageObject.RegisterPage;
import jdk.jfr.Name;
import org.junit.Test;

import static PageObject.LoginPage.LOGIN_PAGE_URL;
import static PageObject.RegisterPage.REGISTER_PAGE_URL;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationOfUserTests {

    //При успешной регистрации переход на страницу входа
    @Test
    @Name("Correct registration")
    public void checkTheCorrectRegistration() {
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.registration(registerPage.NAME, registerPage.EMAIL, registerPage.PASSWORD);
        registerPage.waitAfterRegistration();
        assertEquals("After successful registration user must be redirected on the login page!",
                url(), LOGIN_PAGE_URL);
    }

    //Регистрация с коротким паролем, отображение ошибки
    @Test
    @Name("Registration with short password")
    public void checkTheRegistrationWithIncorrectPassword() {
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.registration(registerPage.NAME, registerPage.EMAIL, registerPage.INCORRECT_PASSWORD);
        assertTrue("The incorrect password sign must be visible", registerPage.checkIncorrectPasswordSign());
    }
}
