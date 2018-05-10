import main.java.gui.layout.LayoutManager;
import main.java.gui.layout.LayoutPoolMap;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Janos Benyovszki
 */
public class Run extends Application implements LayoutPoolMap {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        LayoutManager layoutManager = new LayoutManager();
        Parent root = layoutManager.load(FRAME_LOCATION, FRAME_RESOURCE_LOCATION);


        BorderPane borderPane = (BorderPane) root;


        borderPane.setCenter(layoutManager.load(START_LOCATION, START_RESOURCE_LOCATION));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("main/java/gui/style/style.css");

        primaryStage.setTitle("Shadow Caster");
        primaryStage.getIcons().add(new Image("main/resources/img/icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
