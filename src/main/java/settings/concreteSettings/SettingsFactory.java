package settings.concreteSettings;

import settings.BrowserName;
import settings.BrowserType;
import settings.ISettings;

public class SettingsFactory {


    public ISettings runBrowserSettingsWith(BrowserName name, BrowserType type){

        ISettings settings = null;

        try {

            switch (name) {
                case CHROME:
                    settings = new ChromeSettings();
                    settings.setUp(type);
                    break;

                case FIREFOX:
                    settings = new FirefoxSettings();
                    settings.setUp(type);
                    break;

                case INTERNET_EXPLORER:
                    settings = new InternetExplorerSettings();
                    settings.setUp(type);
                    break;
            }

            return settings;

        } catch (IllegalArgumentException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
