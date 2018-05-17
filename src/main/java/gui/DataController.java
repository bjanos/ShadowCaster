package gui;

import database.DBManager;
import database.Entry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Janos Benyovszki
 */
public class DataController implements Initializable {

    @FXML
    private ProgressBar progressBar;

    @FXML
    private TableView<Entry> tableView;

    @FXML
    private TableColumn<Entry, String> dateColumn;

    @FXML
    private TableColumn<Entry, String> typeColumn;

    @FXML
    private TableColumn<Entry, String> inputColumn;


    @FXML
    private Label progressLabel;

    private ObservableList<Entry> data;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listEntries();
    }

    private void listEntries() {
        Task task = new Task() {
            @Override
            protected Object call() {
                ArrayList<Entry> entries = new DBManager().returnAllEntries();

                ObservableList<Entry> list = FXCollections.observableArrayList(entries);

                for (Entry e : list) {
                    System.out.printf(
                            "%s %s %s\n",
                            e.getType(),
                            e.getInputText(),
                            e.getDate());
                }

                data = FXCollections.observableArrayList(entries);

                return null;
            }
        };

        tableView.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();


    }


}
