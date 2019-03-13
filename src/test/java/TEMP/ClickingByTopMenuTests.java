//import utils.BaseTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.*;
//import org.openqa.selenium.interactions.Actions;
//
///**
// * Created by alexnesov on 21/03/2017.
// */
//
//public class ClickingByTopMenuTests extends BaseTest{
//
//    void closeModal()throws InterruptedException{
//        WebElement closebtn = driver.findElement(By.className("btnclose"));
//        Actions mouseAction = new Actions(driver);
//        mouseAction.click(closebtn);
//        mouseAction.build().perform();
//    }
//
//    void myWait()throws InterruptedException{
//        Thread.sleep(2000);
//    }
//    @BeforeTest
//    @Override
//    public void setUp() {
//        super.setUp();
//        driver.get("https://synergy.net");
//    }
//
//    @AfterTest
//    @Override
//    public void tearDown() {
//        super.tearDown();
//    }
//
//    @Test
//    void test_1() throws InterruptedException {
//
//        if (app != null){
//            app.topMenu()
//                    .clickToEvents()
//                    .clickToLogo()
//                    .clickToNews()
//                    .clickToCompanies()
//                    .clickToPeople()
//                    .clickToProducts();
//        }
//    }
//    @Test
//    void test_2()throws InterruptedException {
//        app.bottomBar()
//                .clickToAppMode();
//        myWait();
//        closeModal();
//    }
//    @Test
//    void test_3() throws InterruptedException{
//        app.bottomBar()
//                .clickToChat();
//        myWait();
//        closeModal();
//    }
//    @Test
//    void test_4()throws InterruptedException{
//        app.bottomBar()
//                .clickToMail();
//        myWait();
//        closeModal();
//
//    }
//
//    @Test
//    void test_5(){
//        app.bottomBar().clickToExplore();
//    }
//
//    @Test
//    void test_6()throws InterruptedException{
//        app.topMenu()
//                .clickToCompanies();
//        app.searchBar()
//                .typeTextIntoSearch("QA Busines");
//        myWait();
//    }
//
//
//}
