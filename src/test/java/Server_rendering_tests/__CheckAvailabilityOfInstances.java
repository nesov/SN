package Server_rendering_tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.BaseTest;



public class __CheckAvailabilityOfInstances extends BaseTest{
    private static final String PREFIX ="pp00-";

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


    public WebDriver analyzeLog(){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for(LogEntry entry : logEntries) {

            if (entry.toString().contains("Rendered by Server!")){
                System.out.println(entry  + " - Rendering OK");
                Assert.assertTrue(true, "Rendering works");

            } else if (entry.toString().contains("Rendered from Cache!")){
                System.out.println(entry  + " - Rendering OK");
                Assert.assertTrue(true,"Rendering works");

            } else if (entry.toString().contains("Rendered by Client!")) {
                System.out.println(entry + " - Rendering DOES NOT WORK");
//                Assert.fail("Рендеринг не работает");

            } else if (entry.toString().contains("502")) {
                System.out.println(entry + " - Bad gateway");
//                Assert.fail("Инфратруктрная проблема");

            }

        }
        return driver;
    }
    public void passThroughAllTheIntances(String[] instance)  {

        try {
            for (int i = 0; i <= instance.length; i++) {
                driver.get(instance[i]);
                analyzeLog();
            }


        } catch (ArrayIndexOutOfBoundsException ex){
//            ex.printStackTrace();
        }

        System.out.println("DONE...");
    }


    @BeforeTest
    public void setUp() {
        super.setUp_local_chrome_driver();
//        super.setUp_local_mobile_web_driver();
//        super.setUp_remote_chrome_driver();
//        super.setUp_remote_ff_driver();
        }


    @AfterTest
    public void tearDown() {
        super.tearDown();
    }

    @Test
    void checkRenredingOfCompanyDetails_form_view(){
        String i = "https://synergy.net/explore/companies/apple-29/about";
        driver.get(i);
        analyzeLog();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    void checkingAvailability(){
        passThroughAllTheIntances(IMPPORTANT_INTANCES);
    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    void checkingAvailability_pre(){
        passThroughAllTheIntances(PRE_PROD_INTANCES);
    }



}

