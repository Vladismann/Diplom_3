import PageObject.RegisterPage;
import jdk.jfr.Name;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static PageObject.RegisterPage.REGISTER_PAGE_URL;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationOfUserTests {

    //Переменные для регистрации пользователя
    private final String NAME = "test" + RandomStringUtils.randomAlphabetic(3);
    private final String EMAIL = "test" + RandomStringUtils.randomAlphabetic(3) + "@mail.ru";
    private final String PASSWORD = "123456";
    private final String INCORRECT_PASSWORD = "12345";

    //При успешной реистрации
    @Test
    @Name("Correct registration")
    public void checkTheCorrectRegistration() {
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.registration(NAME, EMAIL, PASSWORD);
        registerPage.waitAfterRegistration();
        assertTrue("After registration user must be redirected on the login page!", registerPage.checkTheUrlAfterSuccessfulRegistration());

    }

    //Регистрация с коротким паролем, отображение ошибки
    @Test
    @Name("Registration with short password")
    public void checkTheRegistrationWithIncorrectPassword() {
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.registration(NAME, EMAIL, INCORRECT_PASSWORD);
        assertTrue("The incorrect password sign must be visible", registerPage.checkIncorrectPasswordSign());
    }
}
