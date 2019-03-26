package Server_rendering_tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import settings.SettingsFactory;
import settings.concreteSettings.BrowserName;
import settings.concreteSettings.BrowserType;
import settings.concreteSettings.ChromeSettings;
import settings.ISettings;
import utils.Utils;

import java.util.ArrayList;


public class Check_Server_Rendering_MOB_WEB_Test_Suite {

//    private ArrayList <String> IMPORTANT_INSTANCES;
//    private ArrayList <String> ALL_INSTANCES;

    private ISettings ENVIRONMENT;

    private ArrayList<String> PP22;
    private static final String PREFIX ="pp22-";


    private String [] PRE_PROD_INTANCES = {
            "https://"+PREFIX+"lawpower.synergy.net",
            "https://"+PREFIX+"thepharmacyatbergheim.synergy.net",
            "http://"+PREFIX+"synergetica.synergy.net",
            "https://"+PREFIX+"shemesh.synergy.net",
            "https://"+PREFIX+"frostburgcity.synergy.net",
            "http://"+PREFIX+"biokon.synergy.net",
            "https://"+PREFIX+"viola.synergy.net",
            "https://"+PREFIX+"siinda.synergy.net",
            "https://"+PREFIX+"libertytax.synergy.net",
            "https://"+PREFIX+"wilcodata.synergy.net",
            "https://"+PREFIX+"envisacarerx.synergy.net",
            "https://"+PREFIX+"premierpharmacysa.synergy.net",
            "https://"+PREFIX+"alsma.synergy.net",
            "https://"+PREFIX+"ukrcemfor.synergy.net",
            "https://"+PREFIX+"localknowledge.synergy.net",
            "https://"+PREFIX+"digitalfestival.synergy.net",
            "https://"+PREFIX+"shift.synergy.net",
            "https://"+PREFIX+"testingstage.synergy.net",
            "https://"+PREFIX+"item.synergy.net",
            "https://"+PREFIX+"gdpr.synergy.net",
            "https://"+PREFIX+"ruby.synergy.net",
            "https://"+PREFIX+"lts.synergy.net",
            "https://"+PREFIX+"lsa.synergy.net",
            "https://"+PREFIX+"vendasta.synergy.net",
            "http://"+PREFIX+"antiguayello.synergy.net",
            "https://"+PREFIX+"localcomm.synergy.net",
            "https://"+PREFIX+"tompkins.synergy.net",
            "https://"+PREFIX+"adp.synergy.net",
            "https://"+PREFIX+"mhi.synergy.net"

    };

    public void initArray(){
        PP22 = new ArrayList<>();


        PP22.add(PRE_PROD_INTANCES[0]);
        PP22.add(PRE_PROD_INTANCES[1]);
        PP22.add(PRE_PROD_INTANCES[2]);
        PP22.add(PRE_PROD_INTANCES[3]);
        PP22.add(PRE_PROD_INTANCES[4]);
        PP22.add(PRE_PROD_INTANCES[5]);
        PP22.add(PRE_PROD_INTANCES[6]);
        PP22.add(PRE_PROD_INTANCES[7]);
        PP22.add(PRE_PROD_INTANCES[8]);
        PP22.add(PRE_PROD_INTANCES[9]);
        PP22.add(PRE_PROD_INTANCES[10]);
        PP22.add(PRE_PROD_INTANCES[11]);
        PP22.add(PRE_PROD_INTANCES[12]);
        PP22.add(PRE_PROD_INTANCES[13]);
        PP22.add(PRE_PROD_INTANCES[14]);
        PP22.add(PRE_PROD_INTANCES[15]);
        PP22.add(PRE_PROD_INTANCES[16]);
        PP22.add(PRE_PROD_INTANCES[17]);
        PP22.add(PRE_PROD_INTANCES[18]);
        PP22.add(PRE_PROD_INTANCES[19]);


    }

    @BeforeClass
    public void setUp() {

        ENVIRONMENT = (new SettingsFactory()).runBrowserSetiingsWith(BrowserName.CHROME,BrowserType.WEB);

        initArray();

    }

    @AfterClass
    public void tearDown() {
        ENVIRONMENT.tearDown();
    }

//    @Test(dependsOnMethods = {"checking_rendering_on_important_instances"},description = "Проверка серверного рендеринга инстансов на массиве всех элементов")
//    @Severity(SeverityLevel.CRITICAL)
//    void checking_rendering_on_all_instances(){
//        Utils.passThroughAllTheIntances(ALL_INSTANCES,ENVIRONMENT);
//    }
//
//    @Test(description = "Проверка серверного ренедеринга на массиве супер важных инстансов")
//    @Severity(SeverityLevel.BLOCKER)
//    void checking_rendering_on_important_instances(){
//        Utils.passThroughAllTheIntances(IMPORTANT_INSTANCES,ENVIRONMENT);
//    }

    @Test(description = "Проверка серверного ренедеринга на массиве супер важных инстансов")
    @Severity(SeverityLevel.BLOCKER)
    void checking_rendering_on_important_instances_pp22(){
        Utils.passThroughAllTheIntances(PP22,ENVIRONMENT);
    }
}
