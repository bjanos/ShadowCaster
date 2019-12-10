import gui.LayoutManager;
import gui.LayoutPoolMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * @author Janos Benyovszki
 */
public class Run extends Application implements LayoutPoolMap {

    @Override
    public void start(Stage primaryStage) {

        LayoutManager layoutManager = new LayoutManager();

        Pane root = layoutManager.load(FRAME_LOCATION, FRAME_RESOURCE_LOCATION);

        Scene scene = new Scene(root);

        /*
         * Easiest way to load css with the Maven folder structure.
         * Get css as URL, then convert it to string when adding to scene.
         * */
        var cssPath = Objects.requireNonNull(getClass().getClassLoader().getResource("style/style.css"));
        scene.getStylesheets().add(cssPath.toString());

        primaryStage.setTitle("Shadow Caster 1.0");

        var iconPath = Objects.requireNonNull(getClass().getClassLoader().getResource("img/icon.png"));
        primaryStage.getIcons().add(new Image(iconPath.toString()));

        primaryStage.setScene(scene);
        primaryStage.show();
        setup();

    }

    private void setup() {

        //TODO complete setup to check db connection


    }
}
