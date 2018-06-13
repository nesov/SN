package utils;

import app.SynergyApp;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

import java.util.concurrent.TimeUnit;

/**
 * Created by alexnesov on 30/03/2017.
 */

 public abstract class BaseTest {

    public WebDriver driver;

    public SynergyApp app;

    public void setUp() {
        if(driver!=null)
            driver = null;

//        System.setProperty("webdriver.chrome.driver","drivers/chromedriver232");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver240");
        driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        app = PageFactory.initElements(driver, SynergyApp.class);
    }

    public void tearDown(){
        WebDriverPool.DEFAULT.dismissAll();
    }
}



