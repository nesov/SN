package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import settings.ISettings;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * Created by alexnesov on 30/03/2017.
 */

 public abstract class BaseTest implements ISettings{

    private static final String HUB_HOST = "http://192.168.3.167:4444/wd/hub";

    private boolean isMobile;






//    public void setUp_local_mobile_web_driver(){
//        System.setProperty("webdriver.chrome.driver","drivers/chromedriver246");
//
//        LoggingPreferences logPrefs = new LoggingPreferences();
//        logPrefs.enable(LogType.BROWSER, Level.ALL);
//
//        Map<String, Object> deviceMetrics = new HashMap<>();
//        deviceMetrics.put("width", 360);
//        deviceMetrics.put("height", 640);
//        deviceMetrics.put("pixelRatio", 3.0);
//
//        Map<String, Object> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceMetrics", deviceMetrics);
//        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
//
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
//        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//
//        driver = new ChromeDriver(chromeOptions);
//
//    }

//    public void setUp_remote_ff_driver(){
//
//        LoggingPreferences logPrefs = new LoggingPreferences();
//        logPrefs.enable(LogType.BROWSER, Level.ALL);
//
//        FirefoxOptions options = new FirefoxOptions();
//        options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//
//        try {
//
//            driver = new RemoteWebDriver(new URL(HUB_HOST),options);
//
//        } catch (MalformedURLException ex){
//
//            ex.printStackTrace();
//
//        }
//
//    }

//    public void setUp_remote_chrome_driver(){
//
//        LoggingPreferences logPrefs = new LoggingPreferences();
//        logPrefs.enable(LogType.BROWSER, Level.ALL);
//
//        ChromeOptions caps = new ChromeOptions();
//        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//
//        try{
//
//            driver = new RemoteWebDriver(new URL(HUB_HOST),caps);
//
//        } catch (MalformedURLException ex){
//
//            ex.printStackTrace();
//
//        }
//
//    }


    public abstract void setUp();
    public abstract void tearDown();





}



