import com.controls.utils.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuthTests extends BaseTest {

    @BeforeTest
    @Override
    public void setUp(){
        super.setUp();
    }

    @AfterTest
    @Override
    public void tearDown(){
        super.tearDown();
    }


    @Test (description = "Happy case")

    public void test_3214(){

        app.getBottomBar().clickToChat();

        app.getLoginModals()
                .getFirstStepScreen();


    }




}
