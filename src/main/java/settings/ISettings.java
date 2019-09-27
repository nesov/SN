package settings;

import org.openqa.selenium.WebDriver;

public interface ISettings {
    void setUp(BrowserType browserType, BrowserMode browserMode);
    void tearDown();
    WebDriver getDriver();
}
