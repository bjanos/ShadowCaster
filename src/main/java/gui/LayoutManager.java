package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import log.Log;
import log.LogMessage;
import log.LogTypes;

import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author Janos Benyovszki
 */
public class LayoutManager {

    //TODO add method to load css

    private Log log = new Log();

    public Pane load(String paneName, String paneResLoc) {

        var resourceBundle = ResourceBundle.getBundle(paneResLoc);

        try {
            /*
            * Using classloader sets the relative path to target/classes/, then
            * getResources returns the fxml if the path is fxml/[name]
            * */
            return (Pane) FXMLLoader.load(
                    Objects.requireNonNull(getClass().getClassLoader().getResource(paneName)),
                    resourceBundle
            );

        } catch (IOException e) {
            log.write(new LogMessage(LogTypes.ERROR, "Layout could not be loaded: " + e.getMessage()));
            return null;
        }

    }


}
