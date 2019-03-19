package settings;

import org.openqa.selenium.WebDriver;

public interface ISettings {
    void setUp(BrowserType browserType);
    void tearDown();
    WebDriver getDriver();
}
