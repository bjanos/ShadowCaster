import log.LogMessage;
import log.LogTypes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Janos Benyovszki
 */
public class LogMessageTest {

    private LogMessage logMessage;
    private static final LogTypes MESSAGE_TYPE = LogTypes.INFO;
    private static final String MESSAGE = "test message";

    @Before
    public void setUp() {
        logMessage = new LogMessage(MESSAGE_TYPE, MESSAGE);
    }

    @Test
    public void checkMessageType() {
        assertEquals(logMessage.getMessageType(), MESSAGE_TYPE);
    }

    @Test
    public void checkMessage() {
        assertEquals(logMessage.getMessage(), MESSAGE);
    }

    @After
    public void tearDown() {
        logMessage = null;
    }
}
