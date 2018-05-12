package gui;

import javafx.concurrent.Task;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * @author Janos Benyovszki
 */
public class Clock extends Task {

    private boolean stopClock = false;


    @Override
    protected Object call() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        while (!stopClock) {
            updateMessage(sdf.format(new GregorianCalendar().getTime()));
        }
        return null;
    }

    public void setStopClock(boolean stopClock) {
        this.stopClock = stopClock;
    }
}
