package codes.matthewp.overlayfx;

import codes.matthewp.overlayfx.controller.OverlayController;
import codes.matthewp.overlayfx.data.SettingsFile;
import codes.matthewp.overlayfx.window.ControlPanel;
import codes.matthewp.overlayfx.window.Overlay;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    private Overlay overlay;
    private ControlPanel cp;

    private static OverlayController overlayController;
    private static SettingsFile settings;

    @Override
    public void init() {
        settings = new SettingsFile();
        overlay = new Overlay();
        cp = new ControlPanel();
    }

    @Override
    public void start(Stage stage) {
        overlay.showOverlay(stage);
        cp.showCP();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setOverlayController(OverlayController overlayController) {
        Main.overlayController = overlayController;
    }

    public static SettingsFile getSettings() {
        return settings;
    }

    public static OverlayController getOverlayController() {
        return overlayController;
    }
}
