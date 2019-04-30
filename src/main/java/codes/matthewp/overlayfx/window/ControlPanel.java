package codes.matthewp.overlayfx.window;

import codes.matthewp.overlayfx.Main;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlPanel {

    public void showCP() {
        try {
            Parent controlPanel = FXMLLoader.load(getClass().getResource("/fxml/cp.fxml"));

            Stage screen2CP = new Stage();
            screen2CP.setTitle("OverlayFX Control Panel");
            screen2CP.setScene(new Scene(controlPanel));
            screen2CP.getIcons().add(new Image("https://i.imgur.com/0btvFWW.png"));
            screen2CP.show();
            Screen secondaryScreen = Screen.getScreens().get(1);
            Rectangle2D bounds = secondaryScreen.getVisualBounds();
            screen2CP.setX(bounds.getMinX() + (bounds.getWidth() / 4));
            screen2CP.setY(bounds.getHeight() / 4);
        }catch (IOException ex) {
            System.out.println("IOException caught while handling the cp");
            ex.printStackTrace();
        }
    }
}
