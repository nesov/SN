package settings.concreteSettings;

import settings.BrowserMode;
import settings.BrowserName;
import settings.BrowserType;
import settings.ISettings;

public class SettingsFactory {


    public ISettings runBrowserSettingsWith(BrowserName name, BrowserType type, BrowserMode mode) {

        ISettings settings = null;

        try {

            switch (name) {
                case CHROME:
                    settings = new ChromeSettings();
                    settings.setUp(type,mode);
                    break;

                case FIREFOX:
                    settings = new FirefoxSettings();
                    settings.setUp(type,mode);
                    break;

                case INTERNET_EXPLORER:
                    settings = new InternetExplorerSettings();
                    settings.setUp(type,mode);
                    break;
            }

            return settings;

        } catch (IllegalArgumentException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
