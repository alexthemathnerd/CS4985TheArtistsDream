package edu.westga.devops.theartistsdreamclient;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalTagManager;
import edu.westga.devops.theartistsdreamclient.model.network.NetworkTagManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.time.LocalDate;

/**
 * Handle Setting up The Artist's Dream Application.
 *
 * @author Alexander Schmidt
 */
public class TheArtistsDreamApplication extends Application {
    public static final String ICON_PATH = "icon.png";

    public static final String LOGIN_FXML = "view/Login.fxml";

    public static final String LOCAL_ARTWORKS_PATH = "view/local-images/";
    public static final Logger LOGGER = Logger.getLogger("The Artist's Dream Server");
    public static ArtworkManager artworkManager;

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
        //setupLocalTagManager();
        setupLocalArtworkManager();
    }

//    private static void setupLocalTagManager() {
//        TagManager tagManager = new LocalTagManager();
//        tagManager.addTag("Pop");
//        tagManager.addTag("Pop");
//        tagManager.addTag("Pop");
//        tagManager.addTag("Pop");
//        tagManager.addTag("Pop");
//        tagManager.addTag("Pop");
//        tagManager.addTag("Green");
//        tagManager.addTag("Green");
//        tagManager.addTag("Green");
//        tagManager.addTag("Green");
//        tagManager.addTag("Oil");
//        tagManager.addTag("Oil");
//        tagManager.addTag("Oil");
//        tagManager.addTag("Oil");
//        tagManager.addTag("Sad");
//        tagManager.addTag("Sad");
//        tagManager.addTag("Sad");
//        tagManager.addTag("Happy");
//        tagManager.addTag("Happy");
//        tagManager.addTag("Happy");
//        tagManager.addTag("Nature");
//        tagManager.addTag("Animals");
//        tagManager.addTag("Portrait");
//        tagManager.addTag("Landscapes");
//        tagManager.addTag("Abstract");
//        tagManager.addTag("3D");
//        tagManager.addTag("Sci-Fi");
//        tagManager.addTag("Material");
//        tagManager.addTag("Contemporary");
//        TagManager.setTagManager(tagManager);
//    }

    private static void setupLocalArtworkManager() {
        artworkManager = new LocalArtworkManager();

        URL artworksFolderResource = TheArtistsDreamApplication.class.getResource(TheArtistsDreamApplication.LOCAL_ARTWORKS_PATH);

        try {
            File artworksFolder = new File(artworksFolderResource.toURI());

            for (File artwork : artworksFolder.listFiles()) {

                String artworkURLPath = artwork.toURI().toURL().toString();

                String[] artworkParts = artwork.getName().substring(0, artwork.getName().indexOf(".")).split("_");
                String artworkName = artworkParts[0];
                int artistID = Integer.parseInt(artworkParts[1]);
                String[] artworkTags = artworkParts[2].split(",");
                List<Integer> artworkTagIDs = new ArrayList<Integer>();
                for (String tag : artworkTags) {
                    artworkTagIDs.add(Integer.parseInt(tag));
                }
                int artworkID = Integer.parseInt(artworkParts[3]);
		LocalDate artworkDate = LocalDate.parse(artworkParts[4]);
                Artwork currentArtwork = new Artwork(new Image(artworkURLPath), artworkName, artistID, artworkTagIDs, artworkID, artworkDate);
                artworkManager.addArtwork(currentArtwork);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
