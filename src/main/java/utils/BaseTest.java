package utils;

import app.SynergyApp;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * Created by alexnesov on 30/03/2017.
 */

 public abstract class BaseTest {

    public WebDriver driver;

    public SynergyApp app;

    public  void setUp() {

////        System.setProperty("webdriver.chrome.driver","drivers/chromedriver232");
////         System.setProperty("webdriver.chrome.driver","drivers/chromedriver240");
////
////
////
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver240");
//        driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());

//        driver.manage().window().fullscreen();
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        driver = new ChromeDriver(caps);
//        driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        app = PageFactory.initElements(driver, SynergyApp.class);


    }

    public void tearDown(){
        driver.close();
//        WebDriverPool.DEFAULT.dismissDriver(driver);
//        WebDriverPool.DEFAULT.dismissAll();
    }


}



