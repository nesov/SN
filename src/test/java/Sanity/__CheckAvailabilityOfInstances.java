package Sanity;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.model.SeverityLevel;
import utils.BaseTest;



public class __CheckAvailabilityOfInstances extends BaseTest{
    private static final String PREFIX ="pp00";
//    private static final String PREFIX ="pp07";


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

    private static final String [] PRE_PROD_INTANCES = {
            "https://"+PREFIX+"-ukrcemfor.synergy.net",
            "https://"+PREFIX+"-localknowledge.synergy.net",
            "https://"+PREFIX+"-digitalfestival.synergy.net",
            "https://"+PREFIX+"-shift.synergy.net",

            "https://"+PREFIX+"-testingstage.synergy.net",
            "https://"+PREFIX+"-item.synergy.net",
            "https://"+PREFIX+"-gdpr.synergy.net",
            "https://"+PREFIX+"-ruby.synergy.net",

            "https://"+PREFIX+"-lts.synergy.net",
            "https://"+PREFIX+".synergy.net",
            "https://"+PREFIX+"-lsa.synergy.net",
            "https://"+PREFIX+"-vendasta.synergy.net",


            "https://"+PREFIX+"-localcomm.synergy.net",
            "https://"+PREFIX+"-tompkins.synergy.net",

            "https://"+PREFIX+"-фadp.synergy.net",
            "https://"+PREFIX+"-mhi.synergy.net",
            "https://www."+PREFIX+"-shemesh.co.il",
            "https://"+PREFIX+"-antiguayello.com"

    };

    @Step ("Reading logs")
    public void analyzeLog(String i){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for(LogEntry entry : logEntries) {
            if (entry.toString().contains("Rendered from Cache!") || logEntries.toString().contains("Rendered by Server!")){
                System.out.println(entry  + " - Rendering OK");
            }

            if (entry.toString().contains("Rendered by Client!")){
                System.out.println(entry + " - Rendering DOES NOT WORK");
            }
        }

    }

    public void passThroughAllTheIntances(String[] instance)  {

        try {
            for (int i = 0; i <= instance.length; i++) {
                driver.get(instance[i]);
                analyzeLog(instance[i]);
            }
        } catch (ArrayIndexOutOfBoundsException ex){
//            ex.printStackTrace();
        }

        System.out.println("DONE...");
    }


    @BeforeTest
    @Override
    public void setUp(){
        super.setUp();
        }

    @AfterTest
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking availability and Server Rendering")
    void checkingAvailability(){
        passThroughAllTheIntances(PROD_INSTANCES);
    }


}

