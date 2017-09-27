import com.controls.utils.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuthTests extends BaseTest {

    @BeforeTest
    @Override
    public void setUp(){
        super.setUp();
        driver.get("https://pp.synergy.net");
    }

    @AfterTest
    @Override
    public void tearDown(){
        super.tearDown();
    }


    @Test
    public void test_3214() throws Exception {

        driver.get("https://pp.synergy.net");

        app.getBottomBar().clickToChat();

        app.getLoginModals()
                .getFirstStepScreen().clickForgotPasswordLink();


    }

    @Test
    public void happyCaseLogin()throws Exception{
        app.getBottomBar().clickToChat();
        app.getLoginModals().getFirstStepScreen()
                .setCursorAndWriteIntoEmailField("a.nesov@synergetica.co").clickToNextBtn()
                .clickAndTypePassword("OPtvb6gh").clickLoginBtn();

        Thread.sleep(5000);
    }




}
