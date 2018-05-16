package gui;

import database.DBManager;
import database.Entry;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import javax.swing.*;
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
    private Label progressLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DBManager dbManager = new DBManager();
        ArrayList<Entry> entries = dbManager.returnAllEntries();


        progressLabel.setText("WORKS");

        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                return null;
            }

            @Override public void run() {
                final long max = 9999;
                for (int i=1; i<=max; i++) {
                    updateProgress(i, max);
                }
            }

            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return super.cancel(mayInterruptIfRunning);
            }
        };

        progressBar.progressProperty().bind(task.progressProperty());
        new Thread(task).start();

    }
}
