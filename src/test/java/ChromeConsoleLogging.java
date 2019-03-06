//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriverService;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.logging.LogEntries;
//import org.openqa.selenium.logging.LogEntry;
//import org.openqa.selenium.logging.LogType;
//import org.openqa.selenium.logging.LoggingPreferences;
//import org.openqa.selenium.remote.CapabilityType;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.Date;
//import java.util.logging.Level;
//
//public class ChromeConsoleLogging {
//    private WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//
//        System.setProperty("webdriver.chrome.driver","drivers/chromedriver246");
//
//        LoggingPreferences logPrefs = new LoggingPreferences();
//        logPrefs.enable(LogType.SERVER, Level.ALL);
//
//        ChromeOptions caps = new ChromeOptions();
//        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//
//        ChromeDriverService service = (ChromeDriverService.createDefaultService());
//
//        driver = new ChromeDriver(service,caps);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//
//    public void analyzeLog() {
//        LogEntries logEntries = driver.manage().logs().get(LogType.SERVER);
//        for (LogEntry entry : logEntries) {
//
//            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
////            //do something useful with the data
//        }
//    }
//    @Test
//    public void testMethod() {
//        driver.get("https://synergy.net");
//        //do something on page
//        analyzeLog();
//    }
//
//
//
//}