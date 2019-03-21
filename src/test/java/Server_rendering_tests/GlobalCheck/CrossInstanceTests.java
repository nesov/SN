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

    private ArrayList <String> IMPORTANT_INSTANCES;
    private ArrayList <String> ALL_INSTANCES;

    public ISettings ENVIRONMENT,ENVIRONMENT_MOB;
    private static final String PREFIX ="pp00-";

//    private static final String [] IMPPORTANT_INTANCES = {
//            "https://shemesh.co.il",
//            "https://frostburgcity.org",
//            "http://www.biokon.com.ua",
//            "https://viola.synergy.net",
//            "https://libertytax.synergy.net",
//
//            "https://lawpower.com",
//
//            "https://www.thepharmacyatbergheim.com",
//            "https://wilcodata.synergy.net",
//            "https://envisacarerx.synergy.net",
//            "https://premierpharmacysa.synergy.net",
//
//            "http://www.synergetica.co",
//            "https://synergy.net",
//
//            "https://siinda.synergy.net"
//    };

    //    private static final String [] PRE_PROD_INTANCES = {
//            "https://"+PREFIX+"lawpower.synergy.net",
//
//            "https://"+PREFIX+"thepharmacyatbergheim.synergy.net",
//            "http://"+PREFIX+"synergetica.synergy.net",
//            "https://"+PREFIX+"shemesh.synergy.net",
//            "https://"+PREFIX+"frostburgcity.synergy.net",
//            "http://"+PREFIX+"biokon.synergy.net",
//            "https://"+PREFIX+"viola.synergy.net",
//            "https://"+PREFIX+"siinda.synergy.net",
//            "https://"+PREFIX+"libertytax.synergy.net",
//            "https://"+PREFIX+"wilcodata.synergy.net",
//            "https://"+PREFIX+"envisacarerx.synergy.net",
//            "https://"+PREFIX+"premierpharmacysa.synergy.net",
//            "https://"+PREFIX+"alsma.synergy.net",
//            "https://"+PREFIX+"ukrcemfor.synergy.net",
//            "https://"+PREFIX+"localknowledge.synergy.net",
//            "https://"+PREFIX+"digitalfestival.synergy.net",
//            "https://"+PREFIX+"shift.synergy.net",
//            "https://"+PREFIX+"testingstage.synergy.net",
//            "https://"+PREFIX+"item.synergy.net",
//            "https://"+PREFIX+"gdpr.synergy.net",
//            "https://"+PREFIX+"ruby.synergy.net",
//            "https://"+PREFIX+"lts.synergy.net",
//            "https://"+PREFIX+"lsa.synergy.net",
//            "https://"+PREFIX+"vendasta.synergy.net",
//            "http://"+PREFIX+"antiguayello.synergy.net",
//            "https://"+PREFIX+"localcomm.synergy.net",
//            "https://"+PREFIX+"tompkins.synergy.net",
//            "https://"+PREFIX+"adp.synergy.net",
//            "https://"+PREFIX+"mhi.synergy.net"
//
//    };

    @BeforeClass
    public void setUp() {
        IMPORTANT_INSTANCES = Utils.readFromPropertyfile("res/instances.properties");
        ALL_INSTANCES = Utils.readFromPropertyfile("res/all_instances.properties");

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
