package Server_rendering_tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import settings.BrowserMode;
import settings.concreteSettings.SettingsFactory;
import settings.BrowserName;
import settings.BrowserType;
import settings.ISettings;
import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;


public class SpotRenderingCheck {



    private ISettings ENVIRONMENT;

    private ArrayList<String> PP;
    private static final String PREFIX ="pp00-";


    private String [] PRE_PROD_INTANCES = {

            "https://"+PREFIX+"shemesh.synergy.net",
            "https://"+PREFIX+"frostburgcity.synergy.net",
            "http://"+PREFIX+"biokon.synergy.net",
            "https://"+PREFIX+"viola.synergy.net",
            "https://"+PREFIX+"lawpower.synergy.net",
            "https://"+PREFIX+"thepharmacyatbergheim.synergy.net",
            "https://"+PREFIX+"siinda.synergy.net",
            "https://"+PREFIX+"libertytax.synergy.net",
            "https://"+PREFIX+"wilcodata.synergy.net",
            "https://"+PREFIX+"envisacarerx.synergy.net",
            "https://"+PREFIX+"premierpharmacysa.synergy.net",
            "https://"+PREFIX+".synergy.net",
            "http://"+PREFIX+"synergetica.synergy.net",
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
            "https://"+PREFIX+"mhi.synergy.net",
            "https://"+PREFIX+"passportcard.synergy.net"

    };

    public ArrayList<String> initArray() throws ArrayIndexOutOfBoundsException{
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(Arrays.asList(PRE_PROD_INTANCES));
        return temp;
    }

    @BeforeClass
    public void setUp() {
        ENVIRONMENT = (new SettingsFactory()).runBrowserSettingsWith(BrowserName.CHROME,BrowserType.WEB, BrowserMode.HEADLESS);
        PP = new ArrayList<>(initArray());
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
    void checking_rendering_on_important_instances_pp00(){
        Utils.passThroughAllTheIntances(PP,ENVIRONMENT);
    }
}
