import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.WaitHelper;

public class RemoteTemp extends BaseTest {

    @BeforeClass
    public void setUp(){
        super.setUp_remote_ff_driver();
    }


    @AfterClass
     public void tearDown(){
        super.tearDown();
    }

    @Test
    void run_test(){


        driver.get("https://synergy.net/");

//        String script1 ="alert('asdasdasdasd')";
//
//        String script = "var newWin = window.open(\"https://synergy.net/\", \"hello\", \"width=200\",\"height=200\");"
//                      + "newWin.document.write(\"Привет, мир!\");"
//                      + "newWin.close()";
//
//        WaitHelper.runJScript(driver,script);
    }
}
