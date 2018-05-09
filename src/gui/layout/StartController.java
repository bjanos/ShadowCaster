package gui.layout;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StartController implements LayoutPoolMap {

    LayoutManager layoutManager = new LayoutManager();

    @FXML
    void showTransactions(ActionEvent event) {
        var transactions = layoutManager.load(TRANSACTION_LOCATION, TRANSACTION_RESOURCE_LOCATION);
        Scene scene = ((Button)event.getSource()).getScene();
        List list = scene.getStylesheets();
        BorderPane borderPane = (BorderPane) ((Button)event.getSource()).getScene().getRoot();

        borderPane.setCenter(transactions);

        printButtonName(event);
    }

    @FXML
    void showData(ActionEvent event) {
        printButtonName(event);
    }

    public void initialize() {
    }

    private void printButtonName(Event event) {
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
    }
}
