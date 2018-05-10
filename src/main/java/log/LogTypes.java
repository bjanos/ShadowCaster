package log;

/**
 * Types of log messages used in sending requests to Log
 * and in writing them to file.
 *
 * @author Janos Benyovszki
 */
enum LogTypes {
    ERROR("Error"),
    INFO("Information"),
    WARNING("Warning");

    private String text;

    LogTypes(String text) {
        this.text = text;
    }
}
