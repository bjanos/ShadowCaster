package main.java.gui.layout;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Janos Benyovszki
 */
public class LayoutManager {

    public Pane load(String paneName, String paneResLoc) {

        var resourceBundle = ResourceBundle.getBundle(paneResLoc);

        try {
            return (Pane) FXMLLoader.load(getClass().getResource(paneName), resourceBundle);

        } catch (IOException e) {
            System.out.println("layout load error");
            e.printStackTrace();
            return null;
        }

    }


}
