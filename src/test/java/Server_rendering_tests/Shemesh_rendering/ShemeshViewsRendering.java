package Server_rendering_tests.Shemesh_rendering;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.ISettings;
import settings.SettingsFactory;
import settings.concreteSettings.BrowserName;
import settings.concreteSettings.BrowserType;
import utils.Utils;

import java.util.ArrayList;

@Test
public class ShemeshViewsRendering {

    private ISettings ENVIRONMENT;
    private ArrayList<String> INSTANCES;

    @BeforeClass
    void setup(){
        INSTANCES = Utils.readFromPropertyfile("shemesh.properties");
        ENVIRONMENT = (new SettingsFactory()).runBrowserSetiingsWith(BrowserName.CHROME, BrowserType.WEB);

    }
    @AfterClass
    void tearDown(){
        ENVIRONMENT.tearDown();
    }

    @Test
    void run(){
        Utils.passThroughAllTheIntances(INSTANCES,ENVIRONMENT);
    }



    void landing(){}

    void search(){}
    void all(){}


    void business(){}
    void residental(){}
    void gemachim(){}
    void community_info(){}


    void events(){}
    void event_details(){}


    void deals(){}
    void deal_details(){}


    void highlights(){}
    void highlight_details_with_multiple_items(){}
    void highlight_details_with_single_item(){}





}
