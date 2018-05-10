package gui.layout;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
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
        BorderPane borderPane = (BorderPane) ((Button) event.getSource()).getScene().getRoot();
        borderPane.setCenter(screenToLoad);

        /*
        * Need to remove stylesheet first and add it again, otherwise
        * the custom color of the textarea text is considered only
        * when out of focus. Weird...
        * */
        borderPane.getScene().getStylesheets().removeAll();
        borderPane.getScene().getStylesheets().add("gui/style/style.css");


    }
}
