package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static PageObject.MainPage.MAIN_PAGE_URL;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPage {

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    //Поле ввода почта
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    public SelenideElement emailField;
    //Поле ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    public SelenideElement passwordField;
    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement entryButton;

    //Ввод почты
    @Step("Set email")
    public void setEmail(String email) {
        emailField.setValue(email);
    }

    //Ввод пароля
    @Step("Set password")
    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    //Нажатие на кнопку входа
    @Step("Click entry button")
    public void clickEntryButton() {
        entryButton.click();
    }

    //Вход
    @Step("Entry")
    public void entry(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickEntryButton();
    }

    //Ждем пока кнопка входа исчезнет после успешной регистрации
    @Step("Wait after registration")
    public void waitAfterEntry() {
        entryButton.shouldBe(Condition.hidden);
    }

    //Проверка урла после успешного входа
    @Step("Check the url after entry")
    public boolean checkTheUrlAfterSuccessfulEntry() {
        return url().equals(MAIN_PAGE_URL);
    }

    //Переменные для входа пользователя (постоянный тестовый пользователь)
    public final String EMAIL = "testSelenide@mail.ru";
    public final String PASSWORD = "123456";

}
