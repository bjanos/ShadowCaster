package gui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import log.Log;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author Janos Benyovszki
 */
public class FrameController implements LayoutPoolMap, Initializable {

    @FXML
    private BorderPane frame;

    @FXML
    Button dataBtn;

    @FXML
    Button transactionBtn;

    @FXML
    Label footerMsgLabel;

    private LayoutManager layoutManager = new LayoutManager();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataBtn.setUserData("Open the list of transactions");
        transactionBtn.setUserData("Encode / decode");
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

    @FXML
    void onMouseEntered(MouseEvent event) {
        Button source = (Button) event.getSource();
        String userDataText = source.getUserData().toString();
        footerMsgLabel.setText(source.getUserData().toString());
    }

    @FXML
    void onMouseExited(MouseEvent event) {
        footerMsgLabel.setText("Application running");
    }
}
