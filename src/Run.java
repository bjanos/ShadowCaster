import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class Run extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("gui/res/Text");
        Parent root = FXMLLoader.load(getClass().getResource("gui/layout/ShadowCaster.fxml"));
        Scene scene = new Scene(root);

        scene.getStylesheets().add("gui/style/style.css");
        primaryStage.setTitle("ShadowCaster");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        //primaryStage.getIcons().add();
        primaryStage.show();
    }
}
