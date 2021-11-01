package edu.westga.devops.theartistsdreamserver;

import edu.westga.devops.theartistsdreamserver.model.Receiver;
import edu.westga.devops.theartistsdreamserver.model.Tag;
import edu.westga.devops.theartistsdreamserver.model.User;
import edu.westga.devops.theartistsdreamserver.model.Artwork;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.LogRecord;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Formatter;

/**
 * Entry Point for the Server Application
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class TheArtistsDreamServer {

    public static final String ARTWORKS_PATH = "assets/local-images/artworks.txt";
    public static final Logger LOGGER = Logger.getLogger("The Artist's Dream Server");
    public static final List<Tag> TAGS = new ArrayList<Tag>();
    public static final List<User> USERS = new ArrayList<User>();
    public static final List<Artwork> ARTWORKS = new ArrayList<Artwork>();

    /**
     * Starts the Server
     *
     * @param args the args passed in
     *
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
        LOGGER.info("Receiver is starting.");
        setupFakeUserData();
        setupFakeTagData();
        setupFakeArtworkData();
        Receiver receiver = new Receiver("tcp://localhost:4444");
        receiver.start();
        LOGGER.info("Receiver is ending.");
    }

    private static void setupFakeUserData() {
        InputStream profile = TheArtistsDreamServer.class.getResourceAsStream("assets/default.jpg");
        byte[] image = new byte[0];
        try {
            image = IOUtils.toByteArray(profile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        USERS.add(new User(0, "admin@admin.com", "admin", "admin", image));
        USERS.add(new User(1, "alex@alex.com", "alex", "alex", image));
        USERS.add(new User(2, "aznella@aznella.com", "aznella", "aznella", image));
        USERS.add(new User(3, "jamia@jamia.com", "jamia", "jamia", image));
        USERS.add(new User(4, "corley@corley.com", "corley", "corley", image));
    }

    private static void setupFakeTagData() {
	    Tag pop = new Tag(0, "pop");
	    pop.incrementUseCount();
	    pop.incrementUseCount();
	    pop.incrementUseCount();
	    pop.incrementUseCount();
	    pop.incrementUseCount();
	    TAGS.add(pop);
	    Tag green = new Tag(1, "green");
	    green.incrementUseCount();
	    green.incrementUseCount();
	    green.incrementUseCount();
	    TAGS.add(green);
	    Tag oil = new Tag(2, "oil");
	    oil.incrementUseCount();
	    TAGS.add(oil);
	    Tag sad = new Tag(3, "sad");
	    sad.incrementUseCount();
	    sad.incrementUseCount();
	    TAGS.add(sad);
	    TAGS.add(new Tag(4, "happy"));
	    TAGS.add(new Tag(5, "nature"));
	    TAGS.add(new Tag(6, "animals"));
	    TAGS.add(new Tag(7, "portrait"));
	    TAGS.add(new Tag(8, "landscapes"));
	    TAGS.add(new Tag(9, "abstract"));
	    TAGS.add(new Tag(10, "3d"));
	    TAGS.add(new Tag(11, "sci-fi"));
	    TAGS.add(new Tag(12, "material"));
	    TAGS.add(new Tag(13, "contemporary"));
    }

    private static void setupFakeArtworkData() {
        InputStream artworksFolderResource = TheArtistsDreamServer.class.getResourceAsStream(TheArtistsDreamServer.ARTWORKS_PATH);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(artworksFolderResource))) {
            String line = reader.readLine();
            while (line != null) {
                InputStream artwork = TheArtistsDreamServer.class.getResourceAsStream("assets/local-images/" + line);

                String[] artworkParts = line.substring(0, line.indexOf(".")).split("_");
                String artworkName = artworkParts[0];
                int artistID = Integer.parseInt(artworkParts[1]);
                String[] artworkTags = artworkParts[2].split(",");
                List<Integer> artworkTagIDs = new ArrayList<Integer>();
                for (String tag : artworkTags) {
                    artworkTagIDs.add(Integer.parseInt(tag));
                }
                int artworkID = Integer.parseInt(artworkParts[3]);
                String artworkDate = artworkParts[4];

                byte[] image = IOUtils.toByteArray(artwork);
                Artwork currentArtwork = new Artwork(image, artworkName, artistID, artworkTagIDs, artworkID, artworkDate);
                ARTWORKS.add(currentArtwork);

                line = reader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
