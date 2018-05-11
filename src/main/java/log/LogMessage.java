package log;

/**
 * @author Janos Benyovszki
 */
public class LogMessage {

    private LogTypes messageType;
    private String message;

    public LogMessage(LogTypes messageType, String message) {
        this.messageType = messageType;
        this.message = message;
    }

    public LogTypes getMessageType() {
        return messageType;
    }

    public String getMessage() {
        return message;
    }
}
