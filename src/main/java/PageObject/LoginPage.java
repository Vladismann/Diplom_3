package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    //Поле ввода почты
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

    //Ждем пока кнопка входа исчезнет после успешного входа
    @Step("Wait after login")
    public void waitAfterEntry() {
        entryButton.shouldBe(Condition.hidden);
    }

    //Переменные для входа пользователя (постоянный тестовый пользователь)
    public final String EMAIL = "testSelenide@mail.ru";
    public final String PASSWORD = "123456";

}
