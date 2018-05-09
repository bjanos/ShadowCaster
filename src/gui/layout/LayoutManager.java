package gui.layout;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LayoutManager {

    private static final String FRAME_LOCATION = "Frame.fxml";
    private static final String FRAME_RESOURCE_LOCATION = "gui/res/Frame";
    private static final String TRANSACTION_LOCATION = "Transactions.fxml";
    private static final String TRANSACTION_RESOURCE_LOCATION = "gui/res/Transactions";
    private static final String START_LOCATION = "Start.fxml";
    private static final String START_RESOURCE_LOCATION = "gui/res/Start";
    private static final String DATA_LOCATION = "Data.fxml";

    private ArrayList<Pane> panePool = new ArrayList<>();

    public LayoutManager() {
/*
        BorderPane frameLayout = (BorderPane) load(FRAME_LOCATION, FRAME_RESOURCE_LOCATION);
        panePool.add(frameLayout);

        GridPane startLayout = (GridPane) load(START_LOCATION, START_RESOURCE_LOCATION);
        panePool.add(startLayout);

        VBox transactionsLayout = (VBox) load(TRANSACTION_LOCATION, TRANSACTION_RESOURCE_LOCATION);
        panePool.add(transactionsLayout);


        AnchorPane dataLayout = (AnchorPane) load(DATA_LOCATION);
        panePool.add(dataLayout);*/

    }

    public ArrayList<Pane> getPanePool() {
        return panePool;
    }



    public Pane load(String paneName) {
        try {
            return (Pane) FXMLLoader.load(getClass().getResource(paneName));

        } catch (IOException e) {
            System.out.println("layout load error");
            e.printStackTrace();
            return null;
        }

    }

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
