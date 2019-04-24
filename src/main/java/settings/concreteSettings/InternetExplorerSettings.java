package settings.concreteSettings;

import org.openqa.selenium.WebDriver;
import settings.BrowserType;
import settings.ISettings;

public class InternetExplorerSettings implements ISettings {

    public void setUp(BrowserType type){}

    public void tearDown(){}


    public WebDriver getDriver() {
        return null;
    }
}
