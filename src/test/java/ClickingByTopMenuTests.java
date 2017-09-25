import com.controls.utils.BaseTest;
import app.SynergyApp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;

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
        Thread.sleep(1000);
    }

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

    @Test
    void test_2()throws InterruptedException {
        app.getBottomBar().clickToAppMode();
        myWait();
        closeModal();
    }

    @Test
    void test_3() throws InterruptedException{
        app.getBottomBar().clickToChat();
        myWait();
        closeModal();
    }

    @Test
    void test_4()throws InterruptedException{
        app.getBottomBar().clickToMail();
        myWait();
        closeModal();
    }

    @Test
    void test_5(){
        app.getBottomBar().clickToExplore();
    }


    @Test
    void test_6()throws InterruptedException{
        app.getTopMenu().clickToCompanies();
        app.getSearchBar().typeTextIntoSearch("QA Busines");

        myWait();


    }


}
