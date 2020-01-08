package Server_rendering_tests.GlobalCheck;


//import com.automation.remarks.testng.UniversalVideoListener;
//import com.automation.remarks.video.annotations.Video;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.BrowserMode;
import settings.concreteSettings.SettingsFactory;
import settings.BrowserName;
import settings.BrowserType;
import settings.ISettings;
import utils.Utils;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


//@Listeners(UniversalVideoListener.class)
public class CrossInstanceTests {

//    private static Logger log = Logger.getLogger(CrossInstanceTests.class.getName());


    private ArrayList <String> IMPORTANT_INSTANCES,ALL_INSTANCES;
    private ISettings ENVIRONMENT;


    @BeforeClass
    public void setUp() {
        IMPORTANT_INSTANCES = Utils.readFromPropertyfile("instances.properties");
        ALL_INSTANCES = Utils.readFromPropertyfile("all_instances.properties");

        ENVIRONMENT = (new SettingsFactory()).runBrowserSettingsWith(BrowserName.CHROME,BrowserType.WEB, BrowserMode.HEADLESS);
    }

    @AfterClass
    public void tearDown() {
        ENVIRONMENT.tearDown();
    }


    @Test(description = "Проверка серверного ренедеринга инстансов\n"+
                        "Браузер - Google Chrome\n"+
                        "Режим представления - WEB")
//    @Video (name = "Проверка серверного ренедеринга инстансов")
    @Severity(SeverityLevel.BLOCKER)
    void checking_rendering_on_important_instances(){
        Utils.passThroughAllTheIntances(IMPORTANT_INSTANCES,ENVIRONMENT);

    }

    @Test(dependsOnMethods = "checking_rendering_on_important_instances",
            description = "Проверка серверного рендеринга инстансов на массиве всех элементов\n"+
                          "Браузер - Google Chrome\n"+
                          "Режим представления - WEB")
    @Severity(SeverityLevel.CRITICAL)
    void checking_rendering_on_all_instances(){
        Utils.passThroughAllTheIntances(ALL_INSTANCES,ENVIRONMENT);
    }

}


