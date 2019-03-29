package Server_rendering_tests.GlobalCheck;


import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.SettingsFactory;
import settings.concreteSettings.BrowserName;
import settings.concreteSettings.BrowserType;
import settings.ISettings;
import utils.Utils;

import java.util.ArrayList;

public class CrossInstanceTests {

    private ArrayList <String> IMPORTANT_INSTANCES,ALL_INSTANCES;
    private ISettings ENVIRONMENT,ENVIRONMENT_MOB;


    @BeforeClass
    public void setUp() {
        IMPORTANT_INSTANCES = Utils.readFromPropertyfile("instances.properties");
        ALL_INSTANCES = Utils.readFromPropertyfile("all_instances.properties");

        SettingsFactory factory = new SettingsFactory();
        ENVIRONMENT = factory.runBrowserSetiingsWith(BrowserName.CHROME,BrowserType.WEB);
        ENVIRONMENT_MOB = factory.runBrowserSetiingsWith(BrowserName.CHROME,BrowserType.MOB_WEB);
    }

    @AfterClass
    public void tearDown() {
        ENVIRONMENT.tearDown();
        ENVIRONMENT_MOB.tearDown();
    }


    @Test(description = "Проверка серверного ренедеринга инстансов\n"+
                        "Браузер - Google Chrome\n"+
                        "Режим представления - WEB")
    @Severity(SeverityLevel.BLOCKER)
    void checking_rendering_on_important_instances(){
        Utils.passThroughAllTheIntances(IMPORTANT_INSTANCES,ENVIRONMENT);
    }


    @Test(description = "Проверка серверного ренедеринга инстансов\n"+
                        "Браузер - Google Chrome\n"+
                        "Режим представления - MOB WEB")
    @Severity(SeverityLevel.BLOCKER)
    void checking_rendering_on_important_instances_mob(){
        Utils.passThroughAllTheIntances(IMPORTANT_INSTANCES,ENVIRONMENT_MOB);
    }


    @Test(dependsOnMethods = "checking_rendering_on_important_instances",
            description = "Проверка серверного рендеринга инстансов на массиве всех элементов\n"+
                          "Браузер - Google Chrome\n"+
                          "Режим представления - WEB")
    @Severity(SeverityLevel.CRITICAL)
    void checking_rendering_on_all_instances(){
        Utils.passThroughAllTheIntances(ALL_INSTANCES,ENVIRONMENT);
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
