import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseTest;
import utils.WaitHelper;

import java.util.Random;

public class SignUpTests extends BaseTest{

    void openSignUpForm(){
        WebElement hamb = driver.findElement(By.className("navigation-menu-button"));
        WaitHelper.waitingWithPolling(driver,hamb);
        if (hamb.isDisplayed()) {
            hamb.click();
        }
        WebElement signUpOption = driver.findElement(By.xpath("/html/body/app-synergy/dynamic-settings/root-component/div[1]/header/div/div[2]/ng2-dropdown/div/ng2-dropdown-menu/div[1]/div/div/ng2-menu-item[2]/div"));
        WaitHelper.waitingWithPolling(driver, signUpOption);
        if(signUpOption.isDisplayed()){
            signUpOption.click();
        }
    }

    @Override
    @BeforeClass
    public void setUp(){
        super.setUp();
        driver.get("https://antiguayello-pp.synergy.net");
    }

    @Override
    @AfterClass
    public void tearDown() {
        super.tearDown();
    }

    @Test
    @Title("Регистрация нового пользователя")
    public void happySignUpCase() throws Exception{
        Random random = new Random();

        openSignUpForm();
        app.signUpModal()
                .fillOutFirstName("user"+random.nextInt())
                .fillOutLastName("automated"+random.nextInt())
                .fillOutуEmail("automated" + random.nextInt() + "@cuvox.de")
                .fillOutPassword("Admin321")
                .agreeWithPrivacyPolicy();
    }


    @Test
    @Title("Регистрация пользователя с существющими учетными данными")
    public void registrationOfExistingUser() throws Exception{
        openSignUpForm();
        app.signUpModal()
                .fillOutFirstName("USER")
                .fillOutLastName("AUTOMATED")
                .fillOutуEmail("automated@cuvox.de")
                .fillOutPassword("Admin321")
                .agreeWithPrivacyPolicy();

    }

}
