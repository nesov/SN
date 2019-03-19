package Server_rendering_tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.*;
import settings.BrowserType;
import settings.ChromeSettings;
import settings.ISettings;
import utils.LogUtil;


public class Check_Server_Rendering_Test_Suite {

    private ISettings settings;
    private static final String PREFIX ="pp00-";

    @Step("Rendering reading array of synergy domain")
    private void passThroughAllTheIntances(String[] instance)  {

        try {
            for (int i = 0; i <= instance.length; i++) {
                settings.getDriver().get(instance[i]);
                LogUtil.analyzeLog(settings);
            }
        } catch (ArrayIndexOutOfBoundsException ex){
//            ex.printStackTrace();
        }


    }

    private static final String [] PROD_INSTANCES = {
            "https://lawpower.com",
            "https://www.thepharmacyatbergheim.com",
            "http://www.synergetica.co",
            "https://shemesh.co.il",
            "https://frostburgcity.org",
            "http://www.biokon.com.ua",
            "https://viola.synergy.net",
            "https://siinda.synergy.net",
            "https://libertytax.synergy.net",
            "https://wilcodata.synergy.net",
            "https://envisacarerx.synergy.net",
            "https://premierpharmacysa.synergy.net",
            "https://alsma.synergy.net",
            "https://ukrcemfor.synergy.net",
            "https://localknowledge.synergy.net",
            "https://digitalfestival.synergy.net",
            "https://shift.synergy.net",
            "https://testingstage.synergy.net",
            "https://item.synergy.net",
            "https://gdpr.synergy.net",
            "https://ruby.synergy.net",
            "https://lts.synergy.net",
            "https://lsa.synergy.net",
            "https://vendasta.synergy.net",
            "http://antiguayello.com",
            "https://localcomm.synergy.net",
            "https://tompkins.synergy.net",
            "https://adp.synergy.net",
            "https://mhi.synergy.net"
    };
    private static final String [] IMPPORTANT_INTANCES = {
            "https://shemesh.co.il",
            "https://frostburgcity.org",
            "http://www.biokon.com.ua",
            "https://viola.synergy.net",
            "https://libertytax.synergy.net",

            "https://lawpower.com",

            "https://www.thepharmacyatbergheim.com",
            "https://wilcodata.synergy.net",
            "https://envisacarerx.synergy.net",
            "https://premierpharmacysa.synergy.net",

            "http://www.synergetica.co",
            "https://synergy.net",

            "https://siinda.synergy.net",
    };

    private static final String [] PRE_PROD_INTANCES = {
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

    @BeforeClass
    public void setUp() {
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
        passThroughAllTheIntances(PROD_INSTANCES);
    }

    @Test(description = "Проверка серверного ренедеринга на массиве супер важных инстансов")
    @Severity(SeverityLevel.BLOCKER)
    void checking_rendering_on_important_instances(){
        passThroughAllTheIntances(IMPPORTANT_INTANCES);
    }


    @Test(enabled = false)
    @Severity(SeverityLevel.MINOR)
    void checking_rendering_on_PP_instances(){
        passThroughAllTheIntances(PRE_PROD_INTANCES);
    }

}

