import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.ISettings;

public class RemoteTemp {

    ISettings settings;

    @BeforeClass
    public void setUp(){
//        super.setUp_remote_ff_driver();
    }


    @AfterClass
     public void tearDown(){
        settings.tearDown();
    }

    @Test
    void run_test(){


        settings.getDriver().get("https://synergy.net/");

//        String script1 ="alert('asdasdasdasd')";
//
//        String script = "var newWin = window.open(\"https://synergy.net/\", \"hello\", \"width=200\",\"height=200\");"
//                      + "newWin.document.write(\"Привет, мир!\");"
//                      + "newWin.close()";
//
//        WaitHelper.runJScript(driver,script);
    }
}
