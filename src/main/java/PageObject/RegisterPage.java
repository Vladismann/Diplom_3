package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static PageObject.LoginPage.LOGIN_PAGE_URL;
import static com.codeborne.selenide.WebDriverRunner.url;

public class RegisterPage {

    //Урл страницы регистрации
    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    //Поля: имя, почта, пароль (индекс имени = 0, индекс почты = 1, индекс пароля = 2)
    @FindBy(how = How.XPATH, using = ".//input[@class='text input__textfield text_type_main-default']")
    public ElementsCollection nameEmailPasswordFields;
    //Кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registryButton;
    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement entryButton;
    //Надпись "Некорректный пароль"
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordSign;

    //Ввод имени
    @Step("Set name")
    public void setName(String name) {
        nameEmailPasswordFields.get(0).setValue(name);
    }

    //Ввод почты
    @Step("Set email")
    public void setEmail(String email) {
        nameEmailPasswordFields.get(1).setValue(email);
    }

    //Ввод пароля
    @Step("Set password")
    public void setPassword(String password) {
        nameEmailPasswordFields.get(2).setValue(password);
    }

    //Нажатие на кнопку регистрации
    @Step("Click registry button")
    public void clickRegistrationButton() {
        registryButton.click();
    }

    //Регистрация
    @Step("Registration")
    public void registration(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationButton();
    }

    //Проверка надписи некорретного пароля
    @Step("Check incorrect password sign")
    public boolean checkIncorrectPasswordSign() {
        return incorrectPasswordSign.isDisplayed();
    }

    //Ждем пока кнопка регистрации исчезнет после успешной регистрации
    @Step("Wait after registration")
    public void waitAfterRegistration() {
        registryButton.shouldBe(Condition.hidden);
    }

    //Проверка урла после успешной регистрации
    @Step("Check the url after registration")
    public boolean checkTheUrlAfterSuccessfulRegistration() {
        return url().equals(LOGIN_PAGE_URL);
    }

    //Нажать на кнопку "Войти"
    @Step("Click the entry button")
    public void clickTheEntryButton() {
        entryButton.scrollTo().click();
    }

    //Переменные для регистрации пользователя
    public final String NAME = "test" + RandomStringUtils.randomAlphabetic(3);
    public final String EMAIL = "test" + RandomStringUtils.randomAlphabetic(3) + "@mail.ru";
    public final String PASSWORD = "123456";
    public final String INCORRECT_PASSWORD = "12345";

}
