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
    void openLoginModal(){
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


    }

    @Test(priority = 4)
    void logInAs_CM() throws InterruptedException {
        WebElement usernameinput = driver.findElement(By.id("username"));
        WaitHelper.waitingWithPolling(driver, usernameinput);
        usernameinput.click();
        usernameinput.sendKeys("a.kolesnik@synergetica.co");

        WebElement nextButton = driver.findElement(By.xpath("/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/username-signin/div/div[2]/form/div/div[3]/button"));
        WaitHelper.waitingWithPolling(driver,nextButton);
        nextButton.click();

        WebElement pass = driver.findElement(By.id("password"));
        WaitHelper.waitingWithPolling(driver, pass);
        pass.click();
        pass.sendKeys("bYJQfg8L");

        WebElement signInButton = driver.findElement(By.xpath("/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/password-signin/div[2]/form/div/div[5]/button"));
        WaitHelper.waitingWithPolling(driver,signInButton);
        signInButton.click();
        Thread.sleep(5000);

    }

    @Test (priority = 5)
    void logout()throws InterruptedException{

        WebElement sandvich = driver.findElement(By.className("ng2-dropdown-container"));
        WaitHelper.waitingWithPolling(driver, sandvich);
        if(sandvich.isDisplayed()) {
            sandvich.click();
            Assert.assertTrue(true, sandvich.getText()+" is displayed and clicable");
        }else {Assert.assertTrue(false,sandvich.getText()+" is not displayed");}


        WebElement logoutItem = driver.findElement(By.xpath("/html/body/app-synergy/dynamic-settings/root-component/header/div/div[1]/div/div[2]/ng2-dropdown/div/ng2-dropdown-menu/div[1]/div/div/ng2-menu-item/div"));
        WaitHelper.waitingWithPolling(driver, logoutItem);
        if(logoutItem.isDisplayed()) {
            logoutItem.click();
            Assert.assertTrue(true, "Login item is displayed and clicable");
        }else {Assert.assertTrue(false,"Login item is not displayed");}

        Thread.sleep(5000);
    }

}
