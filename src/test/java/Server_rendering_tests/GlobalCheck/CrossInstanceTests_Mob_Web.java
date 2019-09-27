package Server_rendering_tests.GlobalCheck;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.BrowserMode;
import settings.ISettings;
import settings.concreteSettings.SettingsFactory;
import settings.BrowserName;
import settings.BrowserType;
import utils.Utils;

import java.util.ArrayList;

public class CrossInstanceTests_Mob_Web {

    private ArrayList<String> IMPORTANT_INSTANCES,ALL_INSTANCES;
    private ISettings ENVIRONMENT_MOB;

    @BeforeClass
    public void setUp() {
        IMPORTANT_INSTANCES = Utils.readFromPropertyfile("instances.properties");
        ALL_INSTANCES = Utils.readFromPropertyfile("all_instances.properties");
        ENVIRONMENT_MOB = (new SettingsFactory()).runBrowserSettingsWith(BrowserName.CHROME,BrowserType.MOB_WEB, BrowserMode.HEADLESS);
    }


    @AfterClass
    public void tearDown() {
        ENVIRONMENT_MOB.tearDown();
    }


    @Test(description = "Проверка серверного ренедеринга инстансов\n"+
            "Браузер - Google Chrome\n"+
            "Режим представления - MOB WEB")
    @Severity(SeverityLevel.BLOCKER)
    void checking_rendering_on_important_instances_mob(){
        Utils.passThroughAllTheIntances(IMPORTANT_INSTANCES,ENVIRONMENT_MOB);
    }


    @Test(dependsOnMethods = "checking_rendering_on_important_instances_mob",
            description = "Проверка серверного рендеринга инстансов на массиве всех элементов"+
                    "Браузер - Google Chrome\n"+
                    "Режим представления - MOB WEB")
    @Severity(SeverityLevel.CRITICAL)
     void checking_rendering_on_all_instances_mob(){
        Utils.passThroughAllTheIntances(ALL_INSTANCES,ENVIRONMENT_MOB);
    }

}
