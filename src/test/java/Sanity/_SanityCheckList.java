package Sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.WaitHelper;

public class _SanityCheckList extends BaseTest{


    @BeforeSuite
    @Override
    public void setUp(){
        super.setUp();
    }

    @AfterSuite
    @Override
    public void tearDown(){
        super.tearDown();
    }

    void getToDomain(){
        driver.get("https://synergy.net");
        Assert.assertTrue(true);
    }


    @Test (priority = 0)
    void openSite(){
        this.getToDomain();
    }


    @Test (priority = 1)
    void openLoginModal()throws  InterruptedException{
        WebElement sandvich = driver.findElement(By.className("ng2-dropdown-container"));


        if(sandvich.isDisplayed()) {
            sandvich.click();
            Assert.assertTrue(true, sandvich.getText()+" is displayed and clicable");
        }else {Assert.assertTrue(false,sandvich.getText()+" is not displayed");}

        WebElement loginItem = driver.findElement(By.xpath("/html/body/app-synergy/dynamic-settings/root-component/header/div/div[1]/div/div[2]/ng2-dropdown/div/ng2-dropdown-menu/div[1]/div/div/ng2-menu-item[1]/div"));
        WaitHelper.waitingWithPolling(driver, loginItem);
        if(loginItem.isDisplayed()) {
            loginItem.click();
            Assert.assertTrue(true, "Login item is displayed and clicable");
        }else {Assert.assertTrue(false,"Login item is not displayed");}


        Thread.sleep(2000);
    }

    @Test(priority = 5)
    void logIn(){
        WebElement usernameinput = driver.findElement(By.id("username"));
        usernameinput.click();
        usernameinput.sendKeys("a.kolesnik@synergetica.co");

        WebElement nextButton = driver.findElement(By.xpath("/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/username-signin/div/div[2]/form/div/div[3]/button"));
        WaitHelper.waitingWithPolling(driver,nextButton);
        nextButton.click();
    }
}
