package utils;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import settings.ISettings;

public class LogUtil {

    public static void analyzeLog(ISettings settings){

        LogEntries logEntries = settings.getDriver().manage().logs().get(LogType.BROWSER);


        for(LogEntry entry : logEntries) {
            if (entry.toString().contains("Rendered by Server!")){
                System.out.println("Rendering OK - "+entry );

            } else if (entry.toString().contains("Rendered from Cache!")){
                System.out.println("Rendering OK - "+ entry );

            } else if (entry.toString().contains("Rendered by Client!")) {
                System.out.println("Rendering DOES NOT WORK - "+entry);

            } else if (entry.toString().contains("502")) {
                System.out.println("Bad gateway -"+entry);
            }
        }
    }
}
