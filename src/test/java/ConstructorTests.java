import PageObject.MainPage;
import jdk.jfr.Name;
import org.junit.Test;

import static PageObject.MainPage.MAIN_PAGE_URL;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ConstructorTests {

    //Проверяем переход кнопки "Булки"
    @Test
    @Name("Check transition of buns button")
    public void checkTransitionOfBunsButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue("After transition the buns sign must be visible", main.clickBunsButtonCheckTheSign());
    }

    //Проверяем переход кнопки "Соусы"
    @Test
    @Name("Check transition of sauces button")
    public void checkTransitionOfSaucesButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue("After transition the sauces sign must be visible", main.clickSaucesButtonAndCheckTheSign());
    }

    //Проверяем переход кнопки "Начинки"
    @Test
    @Name("Check transition of sauces button")
    public void checkTransitionOfFillingButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue("After transition the sauces sign must be visible", main.clickFillingButtonAndCheckTheSign());
    }

}
