package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JScriptRunner {

    public static void runJScript(WebDriver driver, String jscript){
        ((JavascriptExecutor) driver).executeScript(jscript);

    }
}
