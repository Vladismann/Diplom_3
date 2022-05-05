import PageObject.MainPage;
import com.codeborne.selenide.Configuration;
import jdk.jfr.Name;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static PageObject.MainPage.MAIN_PAGE_URL;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ConstructorTests {

    //Параметризация для кроссбраузерного тестирования
    private final String browser;

    public ConstructorTests(String browser) {
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

    //Проверяем, что после перехода в раздел "Булки" можно добавить элемент из этого раздела в корзину
    @Test
    @Name("Check transition of buns button")
    public void checkTransitionOfBunsButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue("After drag and drop the bun in the order basket must be visible", main.clickBunsButtonCheckTheSign());
    }

    //Проверяем, что после перехода в раздел "Соусы" можно добавить элемент из этого раздела в корзину
    @Test
    @Name("Check transition of sauces button")
    public void checkTransitionOfSaucesButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue("After drag and drop the sauce in the order basket must be visible", main.clickSaucesButtonAndCheckTheSign());
    }

    //Проверяем, что после перехода в раздел "Начинки" можно добавить элемент из этого раздела в корзину
    @Test
    @Name("Check transition of sauces button")
    public void checkTransitionOfFillingButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue("After drag and drop the filling in the order basket must be visible", main.clickFillingButtonAndCheckTheSign());
    }

}
