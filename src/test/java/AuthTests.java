import utils.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuthTests extends BaseTest {

    @BeforeTest
    @Override
    public void setUp(){
        super.setUp();
        driver.get("https://antiguayello-pp.synergy.net");
    }

    @AfterTest
    @Override
    public void tearDown(){
        super.tearDown();
    }


    @Test
    public void test_3214() throws Exception {

        driver.get("https://pp.synergy.net");

        app.loginModals()
                .getFirstStepScreen()
                .clickForgotPasswordLink();


    }

    @Test
    public void happyCaseLogin()throws Exception{
        app
                .bottomBar()
                .clickToChat();
        app.loginModals()
                .getFirstStepScreen()
                .setCursorAndWriteIntoEmailField("a.nesov@synergetica.co")
                .clickToNextBtn()
                .clickAndTypePassword("OPtvb6gh")
                .clickLoginBtn();
    }




}
