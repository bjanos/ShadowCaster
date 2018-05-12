package gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import log.Log;

import java.util.Objects;

/**
 * @author Janos Benyovszki
 */
public class FrameController implements LayoutPoolMap {

    @FXML
    private BorderPane frame;

    @FXML
    private Label footerTimeLabel;

    private LayoutManager layoutManager = new LayoutManager();

    private Clock clock = new Clock();


    public void initialize() {
//        footerTimeLabel.textProperty().bind(clock.messageProperty());
    }


    @FXML
    private void showTransactions(ActionEvent event) {
        setCenter(event, TRANSACTION_LOCATION, TRANSACTION_RESOURCE_LOCATION);
    }

    @FXML
    private void showData(ActionEvent event) {
        setCenter(event, DATA_LOCATION, DATA_RESOURCE_LOCATION);
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
        var source = event.getSource();

        /*
         * If start buttons are clicked frame is not initialised. This way it is.
         * */
        if (source instanceof Button && frame == null) {
            frame = (BorderPane) ((Button) event.getSource()).getScene().getRoot();
        }

        frame.setCenter(screenToLoad);

        /*
         * Need to remove stylesheet first and add it again, otherwise
         * the custom color of the textarea text is considered only
         * when out of focus. Weird...
         * */
        frame.getScene().getStylesheets().removeAll();
        var cssPath = Objects.requireNonNull(getClass().getClassLoader()
                .getResource("style/style.css"));
        frame.getScene().getStylesheets().add(cssPath.toString());


    }

    @FXML
    private void openLogLocation() {
        Log.openLogLocation();
    }


    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);

    }
}