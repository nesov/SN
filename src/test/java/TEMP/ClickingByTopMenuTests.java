//package TEMP;
//
//import oldcore.SynergyApp;
//import settings.BrowserName;
//import settings.BrowserType;
//import settings.ISettings;
//import settings.concreteSettings.SettingsFactory;
////import utils.BaseTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.*;
//import org.openqa.selenium.interactions.Actions;
//
///**
// * Created by alexnesov on 21/03/2017.
// */
//
//public class ClickingByTopMenuTests{
//
//    private ISettings env = (new SettingsFactory().runBrowserSettingsWith(BrowserName.CHROME, BrowserType.WEB));
//    private SynergyApp app = new SynergyApp();
//
//
//    void closeModal()throws InterruptedException{
//        WebElement closebtn = env.getDriver().findElement(By.className("btnclose"));
//        Actions mouseAction = new Actions(env.getDriver());
//        mouseAction.click(closebtn);
//        mouseAction.build().perform();
//    }
//
//    void myWait()throws InterruptedException{
//        Thread.sleep(2000);
//    }
//    @BeforeTest
////    @Override
//    public void setUp() {
////        super.setUp();
////        driver.get("https://synergy.net");
//        env.getDriver().get("https://synergy.net");
//    }
//
//    @AfterTest
////    @Override
//    public void tearDown() {
////        super.tearDown();
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
