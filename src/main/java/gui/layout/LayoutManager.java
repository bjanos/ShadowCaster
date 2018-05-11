package gui.layout;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * @author Janos Benyovszki
 */
public class LayoutManager {

    public Pane load(String paneName, String paneResLoc) {

        var resourceBundle = ResourceBundle.getBundle(paneResLoc);

        try {
            /*
            * Using classloader sets the relative path to target/classes/, then
            * getResources returns the fxml if the path is fxml/[name]
            * */
            return (Pane) FXMLLoader.load(getClass().getClassLoader().getResource(paneName), resourceBundle);

        } catch (IOException e) {
            System.out.println("layout load error");
            e.printStackTrace();
            return null;
        }

    }


}
