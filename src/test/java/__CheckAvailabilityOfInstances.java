import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import utils.BaseTest;

public class __CheckAvailabilityOfInstances extends BaseTest{
//    private static final String PREFIX ="pp00";
    private static final String PREFIX ="pp01";
//    private static final String PREFIX ="pp02";


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

    public void passThroughAllTheIntances(String [] instance) throws ArrayIndexOutOfBoundsException {
        try {
            for (int i = 0; i <= instance.length; i++) {
                driver.get(instance[i]);
                System.out.println(instance[i].toString());
            }
        } catch (Exception ex){}

        System.out.println("DONE...");
    }


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

//    @Test(enabled = false)
//    @Description("prod")
//    public void clearProductionInstancesCaches(){
//        passThroughAllTheIntances(PROD_INSTANCES);
//    }

    @Test
    @Description("Checking availability")
    void checkingAvailability(){
        passThroughAllTheIntances(PROD_INSTANCES);
    }

    @Test
    void getting(){}
}
