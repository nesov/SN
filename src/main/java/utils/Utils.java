package utils;

import settings.ISettings;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public final class Utils {

    public static void takeShot_as_file(){

    }

    public static ArrayList<String> readFromPropertyfile(String path){

        List<String> hosts = new ArrayList<>();

        try {
                File file = new File(path);
                FileInputStream fileInput = new FileInputStream(file);
                Properties properties = new Properties();
                properties.load(fileInput);
                fileInput.close();

                Enumeration enuKeys = properties.keys();

                while (enuKeys.hasMoreElements()) {
                    String key = (String) enuKeys.nextElement();
                    hosts.add(properties.getProperty(key));
                }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (ArrayList<String>) hosts;
    }

    public static void passThroughAllTheIntances(ArrayList list, ISettings settings)  {

        try {
            for (int i = 0; i <= list.size(); i++) {
                settings.getDriver().get((String) list.get(i));
                LogUtil.analyzeLog(settings);
            }
        } catch (IndexOutOfBoundsException ex){
//            ex.printStackTrace();
        }

        System.out.println("DONE...");
    }

}
