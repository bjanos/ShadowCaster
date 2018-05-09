import gui.layout.LayoutManager;
import gui.layout.LayoutPoolMap;
import gui.layout.StartController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Run extends Application implements LayoutPoolMap {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        LayoutManager layoutManager = new LayoutManager();
        Parent root = layoutManager.load(FRAME_LOCATION, FRAME_RESOURCE_LOCATION);

        BorderPane borderPane = (BorderPane) root;
        borderPane.setCenter(layoutManager.load(TRANSACTION_LOCATION, TRANSACTION_RESOURCE_LOCATION));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("gui/style/style.css");

        primaryStage.setTitle("ShadowCaster");
        primaryStage.getIcons().add(new Image("gui/res/img/icon.png"));
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.show();

    }
}
