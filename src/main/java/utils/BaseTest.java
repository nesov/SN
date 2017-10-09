package utils;

import app.SynergyApp;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Created by alexnesov on 30/03/2017.
 */

 public abstract class BaseTest {

    public WebDriver driver;

    public SynergyApp app;

    public void setUp() {


//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("localhost:1111");

//        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability();
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver232");
        driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
        app = PageFactory.initElements(driver, SynergyApp.class);
    }

    public void tearDown(){
        WebDriverPool.DEFAULT.dismissAll();
    }
}



