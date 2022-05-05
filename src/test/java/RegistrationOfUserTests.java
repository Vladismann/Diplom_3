import PageObject.RegisterPage;
import com.codeborne.selenide.Configuration;
import jdk.jfr.Name;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static PageObject.LoginPage.LOGIN_PAGE_URL;
import static PageObject.RegisterPage.REGISTER_PAGE_URL;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationOfUserTests {

    //Параметризация для кроссбраузерного тестирования
    private final String browser;

    public RegistrationOfUserTests(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "{0} browser")
    public static Object[][] browserForTest() {
        return new Object[][]{
                {"Chrome"},
                {"Edge"},
                {"FireFox"}
        };
    }

    @Before
    public void setUp() {
        closeWebDriver();
        Configuration.browser = browser;
    }

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
