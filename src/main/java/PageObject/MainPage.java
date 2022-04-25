package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {

    //Урл главной страницы
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    //Кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement accountEntryButton;
    //Кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;
    //Кнопка "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;
    //Заголовок "Булки" для верефикации
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunsSign;
    //Кнопка "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesButton;
    //Заголовок "Соусы" для верефикации
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement saucesSign;
    //Кнопка "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsButton;
    //Заголовок "Начинки" для верефикации
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement fillingsSign;
    //Последний элемент в конструкторе для проверки переходов
    @FindBy(how = How.XPATH, using = "//p[text()='Сыр с астероидной плесенью']")
    private SelenideElement lastIngredient;

    //Нажать на кнопку "Войти в аккаунт"
    @Step("Click the account entry button")
    public void clickAccountEntryButton() {
        accountEntryButton.click();
    }

    //Нажать на кнопку "Личный кабинет"
    @Step("Click the account entry button")
    public void clickPersonalAccountButton() {
        personalAccountButton.click();
    }

    //Нажать на кнопку "Начинки" и проверить отображение заголовка
    @Step("Click the fillings button and check the sign")
    public boolean clickFillingButtonAndCheckTheSign() {
        fillingsButton.click();
        fillingsSign.shouldBe(visible);
        return fillingsButton.isDisplayed();
    }

    //Листаем список вниз и жмем на кнопку "Соусы", чтобы проверить переход и отображение заголовка
    @Step("Click the sauces button and check the sign")
    public boolean clickSaucesButtonAndCheckTheSign() {
        lastIngredient.scrollIntoView(true);
        saucesButton.click();
        return saucesButton.isDisplayed();
    }

    //Листаем список вниз и жмем на кнопку "Булки", чтобы проверить переход и отображение заголовка
    @Step("Click the buns button and check the sign")
    public boolean clickBunsButtonCheckTheSign() {
        lastIngredient.scrollIntoView(true);
        bunsButton.click();
        return bunsButton.isDisplayed();
    }

}
