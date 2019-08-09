package Server_rendering_tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import settings.BrowserType;
import settings.concreteSettings.ChromeSettings;
import settings.ISettings;
import utils.Utils;

import java.util.ArrayList;


public class Check_Server_Rendering_Test_Suite {

    private ArrayList <String> IMPORTANT_INSTANCES;
    private ArrayList <String> ALL_INSTANCES;

    private ISettings settings;
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
        IMPORTANT_INSTANCES = Utils.readFromPropertyfile("instances.properties");
        ALL_INSTANCES = Utils.readFromPropertyfile("all_instances.properties");

        settings =  new ChromeSettings();
        settings.setUp(BrowserType.WEB);
    }

    @AfterClass
    public void tearDown() {
        settings.tearDown();
    }

    @Test(dependsOnMethods = {"checking_rendering_on_important_instances"},description = "Проверка серверного рендеринга инстансов на массиве всех элементов")
    @Severity(SeverityLevel.CRITICAL)
    void checking_rendering_on_all_instances(){
        Utils.passThroughAllTheIntances(ALL_INSTANCES,settings);
    }

    @Test(description = "Проверка серверного ренедеринга на массиве супер важных инстансов")
    @Severity(SeverityLevel.BLOCKER)
    void checking_rendering_on_important_instances(){
        Utils.passThroughAllTheIntances(IMPORTANT_INSTANCES,settings);
    }

}

