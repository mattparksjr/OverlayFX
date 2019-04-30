package codes.matthewp.overlayfx.window;

import codes.matthewp.overlayfx.Main;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Overlay {

    private static Stage cStage;

    public void showOverlay(Stage stage) {
        Parent root = null;
        cStage = stage;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/overlay.fxml"));
            root = loader.load();
            Main.setOverlayController(loader.getController());
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setAlwaysOnTop(true);
            scene.setFill(null);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.getIcons().add(new Image("https://i.imgur.com/0btvFWW.png"));
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX(primaryScreenBounds.getMinX() + Main.getSettings().getInt("pxFromSide"));
            stage.setY(primaryScreenBounds.getMaxY() - Main.getSettings().getInt("pxFromBottom"));
            stage.setWidth(primaryScreenBounds.getWidth());
            stage.setHeight(primaryScreenBounds.getHeight());
            stage.show();
        } catch (IOException e) {
            System.out.println("IOException caught while loading the overlay.");
            e.printStackTrace();
        }
    }

    public static void redoPlacement() {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        cStage.setX(primaryScreenBounds.getMinX() + Main.getSettings().getInt("pxFromSide"));
        cStage.setY(primaryScreenBounds.getMaxY() - Main.getSettings().getInt("pxFromBottom"));
    }
}
