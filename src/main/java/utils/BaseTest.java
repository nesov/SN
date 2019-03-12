package utils;

import app.SynergyApp;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * Created by alexnesov on 30/03/2017.
 */

 public abstract class BaseTest {

    public WebDriver driver;



    public SynergyApp app;

    public  void setUp_local_chrome_driver() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver246");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);

        ChromeOptions caps = new ChromeOptions();
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        ChromeDriverService service = (ChromeDriverService.createDefaultService());

        driver = new ChromeDriver(service,caps);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//        app = PageFactory.initElements(driver, SynergyApp.class);
    }


    public void setUp_local_mobile_web_driver(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver246");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);

        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        driver = new ChromeDriver(chromeOptions);

    }

    public void setUp_remote_chrome_driver(){


        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);



        ChromeOptions caps = new ChromeOptions();
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        try{

            driver = new RemoteWebDriver(new URL("http://192.168.3.167:4444/wd/hub"),caps);

        } catch (MalformedURLException ex){
            ex.printStackTrace();
        }

    }

    public void tearDown(){
        driver.close();
    }


}



