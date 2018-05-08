import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class Run extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        ResourceBundle mainResource = ResourceBundle.getBundle("gui/res/Main");
        ResourceBundle transactionsResource = ResourceBundle.getBundle("gui/res/Transactions");
        VBox transactions = FXMLLoader.load(getClass().getResource("gui/layout/Transactions.fxml"), transactionsResource);

        Parent root = FXMLLoader.load(getClass().getResource("gui/layout/Frame.fxml"), mainResource);

        BorderPane borderPane = (BorderPane) root;
        borderPane.setCenter(transactions);

        Scene scene = new Scene(root);

        scene.getStylesheets().add("gui/style/style.css");
        primaryStage.setTitle("ShadowCaster");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        //primaryStage.getIcons().add();
        primaryStage.show();
    }
}
