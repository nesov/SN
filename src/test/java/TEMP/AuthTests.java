//import org.testng.Assert;
//import utils.BaseTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class AuthTests extends BaseTest{
//
//    @BeforeTest
//    @Override
//    public void setUp(){
//        super.setUp();
////        driver.get("https://antiguayello-pp.synergy.net");
//    }
//
//    @AfterTest
//    @Override
//    public void tearDown(){
//        super.tearDown();
//    }
//
//
//
//    @Test
//    public void happyCaseLogin()throws Exception{
//        app.open()
//                .bottomBar()
//                .clickToChat();
//        app.loginModals()
//                .getFirstStepScreen()
//                .setCursorAndWriteIntoEmailField("a.nesov@synergetica.co")
//                .clickToNextBtn()
//                .clickAndTypePassword("OPtvb6gh")
//                .clickLoginBtn();
//
//        Assert.assertTrue(true);
//    }
//
//    @Test
//    public void wrongEmailAuth(){
//        app.open()
//                .bottomBar()
//                .clickToMail();
//
//        Assert.assertNotNull(app.loginModals().getFirstStepScreen());
//        Assert.assertTrue(app.loginModals().getFirstStepScreen().isLoginModalShown());
//        app.loginModals()
//                .getFirstStepScreen()
//                .setCursorAndWriteIntoEmailField("unexisting-email@cuvox.de")
//                .clickToNextBtn();
//        Assert.assertFalse(false);
//    }
//
//
//
//}
