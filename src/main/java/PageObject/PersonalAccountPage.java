package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {

    //Урл личного кабинета
    public static final String PERSONAL_ACCOUNT_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    //Кнопка "История заказов" - как уникальный локатор для верефикации личного кабинета
    @FindBy(how = How.XPATH, using = ".//a[text()='История заказов']")
    private SelenideElement ordersHistoryButton;
    //Кнопка "Выход"
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logOutButton;
    //Кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;
    //Логотип бургер
    @FindBy(how = How.XPATH, using = ".//*[@id='root']/div/header/nav/div/a")
    private SelenideElement logoButton;

    //Нажать на кнопку "Выход"
    @Step("Click the log out button")
    public void clickTheLogOutButton() {
        logOutButton.click();
    }

    //Нажать на кнопку "Конструктор"
    @Step("Click the constructor button")
    public void clickTheConstructorButton() {
        constructorButton.click();
    }

    //Нажать на логотип бургер
    @Step("Click the logo")
    public void clickTheLogo() {
        logoButton.click();
    }

    //Ждем загрузку страницы
    @Step("Wait after transition on the PA page")
    public void waitAfterTransition() {
        logOutButton.shouldBe(Condition.visible);
    }

    //Ожидание после выхода
    @Step("Wait after log out")
    public void waitAfterLogOut() {
        logOutButton.shouldBe(Condition.disappear);
    }
}
