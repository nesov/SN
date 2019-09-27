package settings.concreteSettings;

import org.openqa.selenium.WebDriver;
import settings.BrowserMode;
import settings.BrowserType;
import settings.ISettings;

public class InternetExplorerSettings implements ISettings {

    public void setUp(BrowserType type, BrowserMode browserMode){}

    public void tearDown(){}


    public WebDriver getDriver() {
        return null;
    }
}
