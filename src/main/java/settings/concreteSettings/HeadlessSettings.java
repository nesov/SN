package settings.concreteSettings;

import org.openqa.selenium.WebDriver;
import settings.ISettings;

public class HeadlessSettings implements ISettings {

    private WebDriver driver;

    @Override
    public void setUp(BrowserType browserType) {

    }

    @Override
    public void tearDown() {

    }

    @Override
    public WebDriver getDriver() {
        return null;
    }
}
