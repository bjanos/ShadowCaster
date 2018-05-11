package app;

import gui.layout.LayoutManager;
import gui.layout.LayoutPoolMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import log.Log;
import log.LogMessage;
import log.LogTypes;

import java.util.Objects;

/**
 * @author Janos Benyovszki
 */
public class Run extends Application implements LayoutPoolMap {

    public static void main(String[] args) {
//        launch(args);

        Log log = new Log();
        log.write(new LogMessage(LogTypes.INFO, "felfedeztuk a galaxist"));
        log.write(new LogMessage(LogTypes.WARNING, "megint feldfedeztuk"));
        log.write(new LogMessage(LogTypes.INFO, "megint feldfedeztuk"));
        log.write(new LogMessage(LogTypes.ERROR, "megint feldfedeztuk"));

    }

    @Override
    public void start(Stage primaryStage) {

        LayoutManager layoutManager = new LayoutManager();

        Pane root = layoutManager.load(FRAME_LOCATION, FRAME_RESOURCE_LOCATION);

        BorderPane borderPane = (BorderPane) root;
        borderPane.setCenter(layoutManager.load(START_LOCATION, START_RESOURCE_LOCATION));

        Scene scene = new Scene(root);

        /*
         * Easiest way to load css with the Maven folder structure.
         * Get css as URL, then convert it to string when adding to scene.
         * */
        var cssPath = Objects.requireNonNull(getClass().getClassLoader().getResource("style/style.css"));
        scene.getStylesheets().add(cssPath.toString());

        primaryStage.setTitle("Shadow Caster");

        var iconPath = Objects.requireNonNull(getClass().getClassLoader().getResource("img/icon.png"));
        primaryStage.getIcons().add(new Image(iconPath.toString()));

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
