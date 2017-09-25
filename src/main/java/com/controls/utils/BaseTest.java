package com.controls.utils;
import java.util.concurrent.TimeUnit;
import app.SynergyApp;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Created by alexnesov on 30/03/2017.
 */

 public abstract class BaseTest {

    public WebDriver driver;
    
    public SynergyApp app;

    public BaseTest() {}

        @BeforeTest(description="Preparing environment for the test..")
        public void setUp() {
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            app = PageFactory.initElements(driver,  SynergyApp.class);
         }

        @AfterTest (description = "Suspending....")
        public void tearDown(){
            WebDriverPool.DEFAULT.dismissAll();
        }
}



