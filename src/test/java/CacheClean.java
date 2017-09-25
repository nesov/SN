import com.controls.utils.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class CacheClean extends BaseTest {

    private static final String COMMAND ="/reset_node_cache";

    private static final String [] INSTANCES = {

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

    @BeforeTest
    @Override
    public void setUp(){
        super.setUp();
    }

    @AfterTest
    @Override
    public void tearDown(){
        super.tearDown();
    }


    @Test
    @Description("Clearing prod caches")
    public void clearProductionInstancesCaches() throws ArrayIndexOutOfBoundsException, InterruptedException {
        try {
                for (int i = 0; i <= INSTANCES.length; i++) {
                    driver.get(INSTANCES[i] + COMMAND);
                    System.out.println(INSTANCES[i].toString());
                }
        } catch (Exception ex){ }
    }
}



