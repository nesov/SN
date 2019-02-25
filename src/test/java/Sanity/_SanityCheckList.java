package Sanity;

import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
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

    @AfterTest
    void getLogs(){
        driver.manage().logs();
    }

    void getToDomain(){
        driver.get("https://synergy.net");
        Assert.assertTrue(true);
    }

    @Feature("Open instance")
    @Test (priority = 0)
    void openSite(){
        this.getToDomain();
    }

    @Test
    void signUp() throws InterruptedException{
        openSite();
        WebElement sandvich = driver.findElement(By.className("ng2-dropdown-container"));

        if(sandvich.isDisplayed()) {
            sandvich.click();
            Assert.assertTrue(true, sandvich.getText()+" is displayed and clicable");
        }else {Assert.assertTrue(false,sandvich.getText()+" is not displayed");}

        WebElement singUpitem = driver.findElement(By.xpath("/html/body/app-synergy/dynamic-settings/root-component/header/div/div[1]/div/div[2]/ng2-dropdown/div/ng2-dropdown-menu/div[1]/div/div/ng2-menu-item[2]/div"));
        WaitHelper.waitingWithPolling(driver, singUpitem);
        if(singUpitem.isDisplayed()) {
            singUpitem.click();
            Assert.assertTrue(true, "Login item is displayed and clicable");
        }else {Assert.assertTrue(false,"Login item is not displayed");}

        WebElement firstname , lastname, email, password,checkBox;
        firstname = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        lastname = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        password = driver.findElement(By.xpath("//*[@id=\"password\"]"));

        checkBox = driver.findElement(By.className("mat-checkbox-layout"));
        WaitHelper.waitingWithPolling(driver,firstname);
        if(firstname.isDisplayed()){
            firstname.click();
            firstname.sendKeys("Rick");
            Assert.assertTrue(true, "chat item found and clicked");
        }
        WaitHelper.waitingWithPolling(driver,lastname);
        if(lastname.isDisplayed()){
            lastname.click();
            lastname.sendKeys("Morrison");
            Assert.assertTrue(true, "chat item found and clicked");
        }
        WaitHelper.waitingWithPolling(driver,email);
        if(email.isDisplayed()){
            email.click();
            email.sendKeys("syn.qa.dept+3214321@gmail.com");
            Assert.assertTrue(true, "chat item found and clicked");
        }
        WaitHelper.waitingWithPolling(driver,password);
        if(password.isDisplayed()){
            password.click();
            password.sendKeys("synqadeptgmailcom11233");
            Assert.assertTrue(true, "chat item found and clicked");
        }
        WaitHelper.waitingWithPolling(driver,checkBox);
        if(checkBox.isDisplayed()){
            checkBox.click();
        }
        Thread.sleep(2000);

        WebElement submitbtn= driver.findElement(By.xpath("/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/signup-signin/div[2]/form/div/div/div[11]/button"));
        WaitHelper.waitingWithPolling(driver,submitbtn);

        if(submitbtn.isDisplayed())
            submitbtn.click();

        WebElement finishBtn = driver.findElement(By.xpath("/html/body/app-synergy/dynamic-settings/root-component/signin-modal/div/div/div/div[2]/final-signin/div/form/div/div[3]/button"));

        WaitHelper.waitingWithPolling(driver,finishBtn);

        if(finishBtn.isDisplayed())
            finishBtn.click();

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
