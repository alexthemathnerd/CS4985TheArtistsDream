package edu.westga.devops.theartistsdreamclient.view.popups;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

/**
 * Handles loading Popups
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class PopupLoader {

    /**
     * Loads the given fxml as a popup. To show the popup call .show() or .showAndWait() on the returned Stage.
     * <p>
     * Using this method to load a popup makes the popup not resizeable and with no border.
     *
     * @param title      the title of the popup
     * @param fxml       the fxml url for the popup
     * @param controller the controller for the popup
     * @param parent     the parent window of the popup
     * @return the loaded Stage to show the FXML popup
     * @throws IOException happens if there is an error in the controller of fxml.
     * @precondition none
     * @postcondition none
     */
    public static Stage loadPopup(String title, URL fxml, Object controller, Parent parent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxml);
        loader.setController(controller);
        Pane pane = loader.load();
        Stage popup = new Stage();
        Scene scene = new Scene(pane);
        ColorAdjust adj = new ColorAdjust(0, 0, -0.5, 0);
        parent.setEffect(adj);

        scene.setFill(Color.TRANSPARENT);
        popup.initOwner(parent.getScene().getWindow());
        popup.initStyle(StageStyle.TRANSPARENT);
        popup.setTitle(title);
        popup.setScene(scene);
        popup.setResizable(false);
        popup.initModality(Modality.APPLICATION_MODAL);

        return popup;
    }
}