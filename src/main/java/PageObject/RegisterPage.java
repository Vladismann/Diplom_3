package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Set name")
    //Ввод имени
    public void setName(String name) {
        nameEmailPasswordFields.get(0).setValue(name);
    }

    @Step("Set email")
    //Ввод почты
    public void setEmail(String email) {
        nameEmailPasswordFields.get(1).setValue(email);
    }

    @Step("Set password")
    //Ввод пароля
    public void setPassword(String password) {
        nameEmailPasswordFields.get(2).setValue(password);
    }

    @Step("Registration")
    //Регистрация
    public void registration(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        registryButton.click();
    }

    @Step("Check incorrect password sign")
    //Проверка надписи некорретного пароля
    public boolean checkIncorrectPasswordSign() {
        return incorrectPasswordSign.isDisplayed();
    }

    //Ждем пока кнопка регистрации исчезнет после успешной регистрации
    @Step("Wait after registration")
    public void waitAfterRegistration() {
        registryButton.shouldBe(Condition.hidden);
    }

    @Step("Check the url after registration")
    //Проверка урла после успешной регистрации
    public boolean checkTheUrlAfterSuccessfulRegistration() {
        return url().equals(LOGIN_PAGE_URL);
    }

}
