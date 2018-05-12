package log;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Janos Benyovszki
 */
public class Log {

    private static final String LOG_LOCATION = System.getProperty("user.home") + "\\ShadowCaster\\";
    private static final String LOG_FILE = LOG_LOCATION + "shadow_caster_log.txt";

    //TODO implement

    /**
     * - connect to file
     * - write to file
     **/
    public Log() {

        if (Files.notExists(Paths.get(LOG_FILE))) {
            createLogFolder();
        }
    }

    private void createLogFolder() {
        File logFile = new File(LOG_FILE);
        File logFolder = new File(logFile.getParent());

        if (Files.notExists(logFolder.toPath())) {
            //TODO handle return value of mkdir
            logFolder.mkdir();
        }

        if (Files.notExists(logFile.toPath())) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void write(LogMessage logMessage) {
        Calendar calendar = new GregorianCalendar();
        Date now = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String message = String.format(
                "%-18s %-10s %s\n",
                dateFormat.format(now),
                logMessage.getMessageType().getText(),
                logMessage.getMessage()
        );


        try (Writer writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.append(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void openLogLocation() {
        try {
            Runtime.getRuntime().exec("explorer.exe /select, " + LOG_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
