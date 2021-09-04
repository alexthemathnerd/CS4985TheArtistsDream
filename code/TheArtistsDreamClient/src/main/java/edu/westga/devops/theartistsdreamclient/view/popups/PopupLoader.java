package edu.westga.devops.theartistsdreamclient.view.popups;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

/**
 * Handles loading Popups
 */
public class PopupLoader {

    /**
     *  Loads the given fxml as a popup. To show the popup call .show() or .showAndWait() on the returned Stage.
     *
     *  Using this method to load a popup makes the popup not resizeable and with no border.
     *
     * @param fxml the fxml url for the popup
     * @param controller the controller for the popup
     * @return the loaded Stage to show the FXML popup.
     * @throws IOException happens if there is an error in the controller of fxml.
     */
    public static Stage loadPopup(String title, URL fxml, String css, Object controller, Window owner) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxml);
        loader.setController(controller);
        Pane pane = loader.load();
        Stage popup = new Stage();
        Scene scene = new Scene(pane);
        scene.getStylesheets().add(css);
        popup.initOwner(owner);
        scene.setFill(Color.TRANSPARENT);
        popup.initStyle(StageStyle.TRANSPARENT);
        popup.setTitle(title);
        popup.setScene(scene);
        popup.setResizable(false);
        popup.initModality(Modality.APPLICATION_MODAL);
        return popup;
    }

}
