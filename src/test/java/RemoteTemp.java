import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseTest;

public class RemoteTemp extends BaseTest {

    @BeforeClass
    public void setUp(){
        super.setUp_remote_chrome_driver();
    }


    @AfterClass
     public void tearDown(){
        super.tearDown();
    }

    @Test
    void run_test(){
        driver.get("https://synergy.net/");
    }
}
