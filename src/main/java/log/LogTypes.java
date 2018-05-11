package log;

/**
 * Types of log messages used in sending requests to Log
 * and in writing them to file.
 *
 * @author Janos Benyovszki
 */
public enum LogTypes {
    ERROR("ERROR"),
    INFO("INFO"),
    WARNING("WARNING");

    private String text;

    LogTypes(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
