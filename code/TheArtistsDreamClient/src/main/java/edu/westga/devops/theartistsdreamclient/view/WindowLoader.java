package edu.westga.devops.theartistsdreamclient.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class WindowLoader {



	/**
     * Change scene.
     *
     * @param currentStage the current stage
     * @param fxmlOfNewWindow the fxml of new window
     * @param controller the controller
     * @param newWindowTitle the new window title
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void changeScene(Stage currentStage, String fxmlOfNewWindow, Object controller, String newWindowTitle)
            throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(WindowLoader.class.getResource(fxmlOfNewWindow));
        loader.setController(controller);
        loader.load();

        Scene scene = new Scene(loader.getRoot());
        currentStage.setScene(scene);
        currentStage.setTitle(newWindowTitle);
    }

}


