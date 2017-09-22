package com.controls.utils;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by alexnesov on 30/03/2017.
 */

public class BaseTest {

    public  WebDriver driver;

    public BaseTest() {}

        @BeforeTest(description="Preparing environment for the test..")
        public void setUp() {
             System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
             driver = new ChromeDriver();
             driver.manage().window().maximize();
             driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
         }

        @AfterTest (description = "Suspending....")
        public void tearDown(){
        driver.quit();
        }

}
