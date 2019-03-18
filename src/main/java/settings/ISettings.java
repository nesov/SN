package settings;

import org.openqa.selenium.WebDriver;

public interface ISettings {
    void setUp();
    void tearDown();
    WebDriver getDriver();
}
