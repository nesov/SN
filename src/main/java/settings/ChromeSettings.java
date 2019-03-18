package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import utils.BaseTest;

import java.util.logging.Level;

public class ChromeSettings extends BaseTest implements ISettings {

    private WebDriver driver = null;

    public void ChromeSettings(){ }

    @Override
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver246");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        ChromeDriverService service = (ChromeDriverService.createDefaultService());

        if(driver==null)
            driver = new ChromeDriver(service,options);

    }

    @Override
    public void tearDown(){
        if(driver!= null) driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
