package settings;

import org.openqa.selenium.WebDriver;
import settings.concreteSettings.BrowserType;

public interface ISettings {
    void setUp(BrowserType browserType);
    void tearDown();
    WebDriver getDriver();
}
