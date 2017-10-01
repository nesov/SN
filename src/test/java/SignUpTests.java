import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import utils.BaseTest;

public class SignUpTests extends BaseTest{

    void openSignUpForm(){
        WebElement hamb = driver.findElement(By.xpath("/html/body/app-synergy/dynamic-settings/root-component/div[1]/header/div/div[2]/ng2-dropdown/div/ng2-dropdown-button/button/span/i"));
        if (hamb.isDisplayed()) {
            hamb.click();
        }

        WebElement signUpOption = driver.findElement(By.xpath("/html/body/app-synergy/dynamic-settings/root-component/div[1]/header/div/div[2]/ng2-dropdown/div/ng2-dropdown-menu/div[1]/div/div/ng2-menu-item[2]/div"));
        if(signUpOption.isDisplayed()){
            signUpOption.click();
        }
    }

    @Override
    @BeforeTest
    public void setUp(){
        super.setUp();
        driver.get("https://dev.synergy.net");
    }

    @Override
    @AfterTest
    public void tearDown() {
        super.tearDown();
    }

    @Test
    @Description("Регистрация нового пользователя")
    public void happySignUpCase() throws Exception{
        openSignUpForm();
        app.getSignUpModal()
                .fillOutFirstName("USER")
                .fillOutLastName("AUTOMATED")
                .fillOutуEmail("automated@cuvox.de")
                .fillOutPassword("Admin321")
                .agreeWithPrivacyPolicy()
                .clickContinueBtn();

        Thread.sleep(10000);
    }


}
