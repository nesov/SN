package settings.concreteSettings;

import org.openqa.selenium.WebDriver;
import settings.BrowserMode;
import settings.BrowserType;
import settings.ISettings;

public class HeadlessSettings implements ISettings {

    private WebDriver driver;

    @Override
    public void setUp(BrowserType browserType, BrowserMode browserMode) {

    }

    @Override
    public void tearDown() {

    }

    @Override
    public WebDriver getDriver() {
        return null;
    }
}
