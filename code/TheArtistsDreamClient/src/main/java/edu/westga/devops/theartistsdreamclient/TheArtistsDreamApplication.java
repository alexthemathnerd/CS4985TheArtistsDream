package edu.westga.devops.theartistsdreamclient;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.model.network.NetworkArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.network.NetworkTagManager;
import edu.westga.devops.theartistsdreamclient.model.network.NetworkUserManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Handle Setting up The Artist's Dream Application.
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class TheArtistsDreamApplication extends Application {

    public static final String ICON_PATH = "icon.png";
    public static final String LOGIN_FXML = "view/Login.fxml";
    public static final Logger LOGGER = Logger.getLogger("The Artist's Dream Client");

    /**
     * Entry Point to running The Artist's Dream Application
     *
     * @param args the args for running the application
     * @precondition none
     * @postcondition none
     */
    public static void main(String[] args) {
        LOGGER.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return "[%s] %s %tF %tr: %s".formatted(record.getLevel().getName(), record.getLoggerName(), LocalDate.now(), LocalTime.now(), record.getMessage()) + System.lineSeparator();
            }
        });
        LOGGER.addHandler(handler);
        setupSingletons();
        launch(args);
    }

    private static void setupSingletons() {
        NetworkTagManager tagManager = new NetworkTagManager();
        TagManager.setTagManager(tagManager);
        NetworkArtworkManager artworkManager = new NetworkArtworkManager();
        ArtworkManager.setArtworkManager(artworkManager);
        NetworkUserManager userManager = new NetworkUserManager();
        UserManager.setUserManager(userManager);
    }

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
}
