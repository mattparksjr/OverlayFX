package codes.matthewp.overlayfx.controller;

import codes.matthewp.overlayfx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class OverlayController {

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img1;

    public void setImg4(String img) {
        img4.setImage(new Image(img));
    }

    public ImageView getImg3() {
        return img3;
    }

    public void setImg3(String img) {
        img3.setImage(new Image(img));
    }

    public ImageView getImg2() {
        return img2;
    }

    public void setImg2(String img) {
        img2.setImage(new Image(img));
    }

    public ImageView getImg1() {
        return img1;
    }

    public void setImg1(String img) {
        img1.setImage(new Image(img));
    }

}
