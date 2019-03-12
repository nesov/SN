import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseTest;

public class __SanityTests extends BaseTest{
    @BeforeClass
    public void setUp(){
        super.setUp_local_chrome_driver();
    }
    @AfterClass
    public void tearDown(){
        super.tearDown();
    }

    @Test (priority = 0)
    void signUp(){

    }

    @Test (priority = 1)
    void login(){

    }

    @Test(priority = 100)
    void createCompany(){

    }

    @Test(priority = 100)
    void searchForCompany(){

    }


    @Test(priority = 100)
    void createProduct(){

    }

    @Test(priority = 100)
    void searctForProduct(){

    }

    @Test(priority = 100)
    void createPerson(){

    }

    @Test(priority = 100)
    void searchForPerson(){

    }

    @Test(priority = 100)
    void associateAccountWithCompany(){

    }

    @Test(priority = 100)
    void createNews() {

    }

    @Test(priority = 100)
    void searchForNews() {

    }


}
