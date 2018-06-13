package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WaitHelper{
    public static void waitingForFiveSeconds(WebDriver driver, WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitingFor(WebDriver driver,WebElement webElement, int timeOutInseconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInseconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitingWithPolling(WebDriver driver, WebElement webElement){
        WebDriverWait wait = new WebDriverWait (driver,5,1000);
        wait.until(ExpectedConditions.visibilityOf(webElement));

    }

//    public static void waitUntilDocumentReadyState(){
//        JavascriptExecutor executor = new JavascriptExecutor();
//
//    }

}
