package utils;

import settings.ISettings;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public final class Utils {

    private static final String dir = "res/";

    public static ArrayList<String> readFromPropertyfile(String filename){

        List<String> hosts = new ArrayList<>();


        try {
                FileInputStream fileInput = new FileInputStream(new File(dir + filename));
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

    public static String readtPropertyByKey(String key, String filename){
        String val = null;
        FileInputStream fileInput = null;
        Properties properties = new Properties();

        try {
            fileInput = new FileInputStream(new File(dir + filename));
            properties.load(fileInput);

            val = properties.getProperty(key);
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInput.close();
            } catch (IOException io){

            }
        }
        return val;
    }

    public static void passThroughAllTheIntances(ArrayList<String> list, ISettings settings)  {

        try {
            for (int i = 0; i <= list.size(); i++) {
                settings.getDriver().get(list.get(i));
                LogUtil.analyzeLog(settings);
//                settings.getDriver().navigate().refresh();
            }
        } catch (IndexOutOfBoundsException ex){
//            ex.printStackTrace();
        }

        System.out.println("DONE...");
    }

}
