package log;

/**
 * @author Janos Benyovszki
 * */
public class Log {

    public static final String LOG_LOCATION = System.getProperty("user.home");

    //TODO implement
    /**
     * - connect to file
     * - write to file
     */

    public void write(String toLog){};



    public static void openLogLocation() {


        try {
            Runtime.getRuntime().exec("explorer.exe /select, " + LOG_LOCATION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
