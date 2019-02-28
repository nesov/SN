import org.openqa.selenium.WebDriver;
import utils.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class CacheCleanTests extends BaseTest{






    private static final String COMMAND ="/reset_node_cache";

    private static final String [] PROD_INSTANCES = {
            "https://ukrcemfor.synergy.net",
            "https://localknowledge.synergy.net",
            "https://digitalfestival.synergy.net",
            "https://shift.synergy.net",

            "https://testingstage.synergy.net",
            "https://item.synergy.net",
            "https://gdpr.synergy.net",
            "https://ruby.synergy.net",

            "https://lts.synergy.net",
            "https://synergy.net",
            "https://lsa.synergy.net",
            "https://vendasta.synergy.net",

            "http://antiguayello.com",
            "https://localcomm.synergy.net",
            "https://tompkins.synergy.net",
            "http://www.synergetica.co",

            "https://shemesh.synergy.net",
            "https://adp.synergy.net",
            "https://mhi.synergy.net",
     };

    private static final String [] PRE_PROD_INTANCES = {
            "https://ukrcemfor-pp.synergy.net",
            "https://localknowledge-pp.synergy.net",
            "https://digitalfestival-pp.synergy.net",
            "https://shift-pp.synergy.net",

            "https://testingstage-pp.synergy.net",
            "https://item-pp.synergy.net",
            "https://gdpr-pp.synergy.net",
            "https://ruby-pp.synergy.net",

            "https://lts-pp.synergy.net",
            "https://pp.synergy.net",
            "https://lsa-pp.synergy.net",
            "https://vendasta-pp.synergy.net",

            "http://antiguayello-pp.synergy.net",
            "https://localcomm-pp.synergy.net",
            "https://tompkins-pp.synergy.net",

            "https://shemesh-pp.synergy.net",
            "https://adp-pp.synergy.net",
            "https://mhi-pp.synergy.net",

    };

    public void passThroughAllTheIntances(String [] instance) throws ArrayIndexOutOfBoundsException {
        try {
            for (int i = 0; i <= instance.length; i++) {
                driver.get(instance[i] + COMMAND);
                System.out.println(instance[i].toString());
            }
        } catch (Exception ex){}

        System.out.println("DONE...");
    }


    @BeforeTest
    @Override
    public void setUp(){

    }

    @AfterTest
    @Override
    public void tearDown(){

    }

    @Test(enabled = false)
    @Description("Clearing prod caches")
    public void clearProductionInstancesCaches(){
        passThroughAllTheIntances(PROD_INSTANCES);
    }

    @Test
    @Description("Clearing pre-prod caches")
    void clearPreProductionInstanceCaches(){
        passThroughAllTheIntances(PRE_PROD_INTANCES);
    }
}



