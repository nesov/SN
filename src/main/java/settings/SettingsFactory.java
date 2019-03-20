package settings;

import settings.concreteSettings.*;

public class SettingsFactory {


    public ISettings factoryMethod(BrowserType type, BrowserName name){

        ISettings settings = null;

        try{

            if(type.equals(BrowserType.WEB) && name.equals(BrowserName.CHROME)){
               settings = initChromeSettings(type);
            }
            if(type.equals(BrowserType.MOB_WEB) && name.equals(BrowserName.CHROME)){
                settings = initChromeSettings(type);
            }

            if(type.equals(BrowserType.WEB) && name.equals(BrowserName.FIREFOX)){
                settings = initFirefoxSettings(type);
            }
            if(type.equals(BrowserType.MOB_WEB) && name.equals(BrowserName.FIREFOX)){
                settings = initFirefoxSettings(type);
            }

            if(type.equals(BrowserType.MOB_WEB) && name.equals(BrowserName.FIREFOX)){
                settings = initInternetExplorerSettings(type);
            }

            return settings;

        } catch (IllegalArgumentException ex){
            ex.printStackTrace();
            return  null;
        }


    }

    private ISettings initChromeSettings(BrowserType type){
        ISettings chromesettings = null;

        chromesettings = new ChromeSettings();
        chromesettings.setUp(type);

        return chromesettings;
    }

    private ISettings initFirefoxSettings(BrowserType type){
        ISettings ffsettings = null;

        ffsettings = new FirefoxSettings();
        ffsettings.setUp(type);
        return ffsettings;
    }

    private ISettings initInternetExplorerSettings(BrowserType type){
        ISettings iesettings = null;

        iesettings = new InternetExplorerSettings();
        iesettings.setUp(type);
        return  iesettings;
    }

}
