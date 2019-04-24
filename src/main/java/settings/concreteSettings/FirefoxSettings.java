package settings.concreteSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import settings.BrowserType;
import settings.ISettings;

import java.util.logging.Level;

public class FirefoxSettings implements ISettings {

    private WebDriver driver;

    public FirefoxSettings(){}

    public void setUp(BrowserType type){

        System.setProperty("webdriver.gecko.driver","drivers/geckodriver");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        driver = new FirefoxDriver(GeckoDriverService.createDefaultService(),options);
    }

    public void tearDown(){
        driver.close();
    }
    public WebDriver getDriver() {
        return driver;
    }
}
