package utils;
import java.util.concurrent.TimeUnit;
import app.SynergyApp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Created by alexnesov on 30/03/2017.
 */

 public abstract class BaseTest {

    public WebDriver driver;

    public SynergyApp app;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver232");
        driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
        app = PageFactory.initElements(driver, SynergyApp.class);
    }

    public void tearDown(){
        WebDriverPool.DEFAULT.dismissAll();
    }
}



