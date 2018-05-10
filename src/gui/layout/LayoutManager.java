package gui.layout;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Janos Benyovszki
 */
public class LayoutManager {

    //TODO enum class instead of Strings - multiple strings can be mixed now

    private static final String FRAME_LOCATION = "Frame.fxml";
    private static final String FRAME_RESOURCE_LOCATION = "gui/res/Frame";
    private static final String TRANSACTION_LOCATION = "Transactions.fxml";
    private static final String TRANSACTION_RESOURCE_LOCATION = "gui/res/Transactions";
    private static final String START_LOCATION = "Start.fxml";
    private static final String START_RESOURCE_LOCATION = "gui/res/Start";
    private static final String DATA_LOCATION = "Data.fxml";

    private ArrayList<Pane> panePool = new ArrayList<>();

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
