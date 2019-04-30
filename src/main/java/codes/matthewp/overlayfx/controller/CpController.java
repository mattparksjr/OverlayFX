package codes.matthewp.overlayfx.controller;


import codes.matthewp.overlayfx.Main;
import codes.matthewp.overlayfx.window.Overlay;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class CpController {

    @FXML
    private TextField pxFromSide;

    @FXML
    private TextField pxFromBottom;

    private static Stage currentPopUp;

    @FXML
    void doSave(ActionEvent event) {
        Main.getSettings().setValue("pxFromBottom", pxFromBottom.getText());
        Main.getSettings().setValue("pxFromSide", pxFromSide.getText());
        Main.getSettings().save();
        getCurrentPopUp().close();
        Overlay.redoPlacement();
    }

    @FXML
    void deReset(ActionEvent event) {
        Main.getOverlayController().setImg1("/img/blank.png");
        Main.getOverlayController().setImg2("/img/blank.png");
        Main.getOverlayController().setImg3("/img/blank.png");
        Main.getOverlayController().setImg4("/img/blank.png");
    }

    @FXML
    void doHelp(ActionEvent event) {
        try {
            Parent about = FXMLLoader.load(getClass().getResource("/fxml/about.fxml"));
            Stage popupWindow = new Stage();
            popupWindow.setScene(new Scene(about));
            popupWindow.setTitle("About");
            popupWindow.show();
            setCurrentPopUp(popupWindow);
            Screen secondaryScreen = Screen.getScreens().get(1);
            Rectangle2D bounds = secondaryScreen.getVisualBounds();
            popupWindow.setX(bounds.getMinX() + (bounds.getWidth() / 4));
            popupWindow.setY(bounds.getHeight() / 4);
        } catch (IOException e) {
            System.out.println("Caught error loading the about popup");
            e.printStackTrace();
        }
    }

    @FXML
    void aboutClose(ActionEvent ae) {
        getCurrentPopUp().close();
    }

    @FXML
    void doExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void doWinAdd(ActionEvent event) {
        Main.getOverlayController().setImg4(Main.getOverlayController().getImg3().getImage().impl_getUrl());
        Main.getOverlayController().setImg3(Main.getOverlayController().getImg2().getImage().impl_getUrl());
        Main.getOverlayController().setImg2(Main.getOverlayController().getImg1().getImage().impl_getUrl());
        Main.getOverlayController().setImg1("/img/check.png");
    }

    @FXML
    void doLossAdd(ActionEvent event) {
        Main.getOverlayController().setImg4(Main.getOverlayController().getImg3().getImage().impl_getUrl());
        Main.getOverlayController().setImg3(Main.getOverlayController().getImg2().getImage().impl_getUrl());
        Main.getOverlayController().setImg2(Main.getOverlayController().getImg1().getImage().impl_getUrl());
        Main.getOverlayController().setImg1("/img/XMARK.png");
    }

    @FXML
    void doSettings(ActionEvent event) {
        try {
            Parent about = FXMLLoader.load(getClass().getResource("/fxml/settings.fxml"));
            Stage popupWindow = new Stage();
            popupWindow.setScene(new Scene(about));
            popupWindow.setTitle("Settings");
            popupWindow.show();
            setCurrentPopUp(popupWindow);
            Screen secondaryScreen = Screen.getScreens().get(1);
            Rectangle2D bounds = secondaryScreen.getVisualBounds();
            popupWindow.setX(bounds.getMinX() + (bounds.getWidth() / 4));
            popupWindow.setY(bounds.getHeight() / 4);
        } catch (IOException e) {
            System.out.println("Caught error loading the about popup");
            e.printStackTrace();
        }
    }

    private static Stage getCurrentPopUp() {
        return currentPopUp;
    }

    private static void setCurrentPopUp(Stage currentPopUp) {
        CpController.currentPopUp = currentPopUp;
    }
}
