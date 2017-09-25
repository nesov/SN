package com.controls.utils;
import java.util.concurrent.TimeUnit;
import app.SynergyApp;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by alexnesov on 30/03/2017.
 */

public class BaseTest {

    public WebDriver driver;

    public SynergyApp app;

    public BaseTest() {}

        @BeforeTest(description="Preparing environment for the test..")
        public void setUp() {
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            app = PageFactory.initElements(driver,  SynergyApp.class);
//            driver.get("https://pp.synergy.net");
         }

        @AfterTest (description = "Suspending....")
        public void tearDown(){
            driver.quit();
        }
}



