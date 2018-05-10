package gui.layout;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * @author Janos Benyovszki
 * */
public class StartController implements LayoutPoolMap {

    private LayoutManager layoutManager = new LayoutManager();

    @FXML
    void showTransactions(ActionEvent event) {
        setCenter(event, TRANSACTION_LOCATION, TRANSACTION_RESOURCE_LOCATION);

        printButtonName(event);
    }

    @FXML
    void showData(ActionEvent event) {

        setCenter(event, DATA_LOCATION, DATA_RESOURCE_LOCATION);

        printButtonName(event);
    }

    public void initialize() {
    }

    private void printButtonName(Event event) {
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }

    /**
     * Sets the center pane of the main BorderPane.
     *
     * @param event    event that initiated the action
     * @param pane     pane to set
     * @param resource resource of the pane to set
     */
    private void setCenter(Event event, String pane, String resource) {
        var screenToLoad = layoutManager.load(pane, resource);
        Scene scene = ((Button) event.getSource()).getScene();
        BorderPane borderPane = (BorderPane) ((Button) event.getSource()).getScene().getRoot();

        borderPane.setCenter(screenToLoad);


    }
}
