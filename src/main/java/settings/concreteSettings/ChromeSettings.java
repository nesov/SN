package settings.concreteSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import settings.ISettings;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class ChromeSettings implements ISettings {

    private WebDriver driver = null;

    public ChromeSettings(){}

    @Override
    public void setUp(BrowserType browserType){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver246");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        switch (browserType) {

            case WEB:

                driver = new ChromeDriver(ChromeDriverService.createDefaultService(),options);
                break;

            case MOB_WEB:

                Map<String, Object> deviceMetrics = new HashMap<>();
                deviceMetrics.put("width", 360);
                deviceMetrics.put("height", 640);
                deviceMetrics.put("pixelRatio", 3.0);

                Map<String, Object> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceMetrics", deviceMetrics);
                mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

                options.setExperimentalOption("mobileEmulation", mobileEmulation);


                driver = new ChromeDriver(ChromeDriverService.createDefaultService(),options);
                break;
        }
    }

    @Override
    public void tearDown(){
        this.getDriver().quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
