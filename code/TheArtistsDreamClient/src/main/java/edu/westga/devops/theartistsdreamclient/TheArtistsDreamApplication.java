package edu.westga.devops.theartistsdreamclient;

import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Handle Setting up The Artist's Dream Application.
 *
 * @author Alexander Schmidt
 */
public class TheArtistsDreamApplication extends Application {
    public static final String ICON_PATH = "icon.png";

    public static final String LOGIN_FXML = "view/Login.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(TheArtistsDreamApplication.class.getResource(LOGIN_FXML));
        loader.load();
        Scene scene = new Scene(loader.getRoot());
        primaryStage.setTitle("The Artist's Dream");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(TheArtistsDreamApplication.class.getResourceAsStream(ICON_PATH)));
        primaryStage.show();
    }

    /**
     * Entry Point to running The Artist's Dream Application
     *
     * @param args the args for running the application
     */
    public static void main(String[] args) {
        setupSingletons();
        launch(args);
    }

    private static void setupSingletons() {
        setupLocalTagManager();
    }

    private static void setupLocalTagManager() {
        TagManager tagManager = new LocalTagManager();
        tagManager.addTag("Pop");
        tagManager.addTag("Pop");
        tagManager.addTag("Pop");
        tagManager.addTag("Pop");
        tagManager.addTag("Pop");
        tagManager.addTag("Pop");
        tagManager.addTag("Green");
        tagManager.addTag("Green");
        tagManager.addTag("Green");
        tagManager.addTag("Green");
        tagManager.addTag("Oil");
        tagManager.addTag("Oil");
        tagManager.addTag("Oil");
        tagManager.addTag("Oil");
        tagManager.addTag("Sad");
        tagManager.addTag("Sad");
        tagManager.addTag("Sad");
        tagManager.addTag("Happy");
        tagManager.addTag("Happy");
        tagManager.addTag("Happy");
        tagManager.addTag("Nature");
        tagManager.addTag("Pets");
        tagManager.addTag("Portrait");
        tagManager.addTag("Nature");
        tagManager.addTag("Landscapes");
        tagManager.addTag("A");
        tagManager.addTag("3D");
        TagManager.setTagManager(tagManager);
    }
}