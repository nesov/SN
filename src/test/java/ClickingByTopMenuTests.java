import utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by alexnesov on 21/03/2017.
 */

public class ClickingByTopMenuTests extends BaseTest{

    void closeModal()throws InterruptedException{
        WebElement closebtn = driver.findElement(By.className("btnclose"));
        Actions mouseAction = new Actions(driver);
        mouseAction.click(closebtn);
        mouseAction.build().perform();
    }

    void myWait()throws InterruptedException{
        Thread.sleep(2000);
    }
    @Step("Откываем Синержи")
    @BeforeTest
    @Override
    public void setUp() {
        super.setUp();
        driver.get("https://pp.synergy.net");
    }

    @AfterTest
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Title("Проход по пунктам топ меню")
    @Test
    void test_1() throws InterruptedException {

        if (app != null){
            app.getTopMenu()
                    .clickToEvents()
                    .clickToLogo()
                    .clickToNews()
                    .clickToCompanies()
                    .clickToPeople()
                    .clickToProducts();
        }
    }
    @Title("Откытие дииалога переключния режима приложения")
    @Test
    void test_2()throws InterruptedException {
        app.getBottomBar().clickToAppMode();
        myWait();
        closeModal();
    }
    @Title("Переход в Chat")
    @Test
    void test_3() throws InterruptedException{
        app.getBottomBar().clickToChat();
        myWait();
        closeModal();
    }
    @Title ("Переход в Mail")
    @Test
    void test_4()throws InterruptedException{
        app.getBottomBar().clickToMail();
        myWait();
        closeModal();
    }

    @Title("Переход на Explore")
    @Test
    void test_5(){
        app.getBottomBar().clickToExplore();
    }

    @Title("Поиск по компаниям")
    @Test
    void test_6()throws InterruptedException{
        app.getTopMenu().clickToCompanies();
        app.getSearchBar().typeTextIntoSearch("QA Busines");

        myWait();
    }


}
