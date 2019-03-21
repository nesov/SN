package settings;

import settings.concreteSettings.*;

public class SettingsFactory {


    public ISettings runBrowserSetiingsWith(BrowserName name, BrowserType type){

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
