package edu.westga.devops.theartistsdreamserver;

import edu.westga.devops.theartistsdreamserver.model.Receiver;
import edu.westga.devops.theartistsdreamserver.model.Tag;
import edu.westga.devops.theartistsdreamserver.model.User;
import edu.westga.devops.theartistsdreamserver.model.Artwork;
import org.apache.commons.io.IOUtils;

import java.net.URI;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.logging.*;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.lang.ClassLoader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        USERS.add(new User(0, "admin@admin.com", "admin", "admin", null));
        USERS.add(new User(1, "alex@alex.com", "alex", "alex", null));
        USERS.add(new User(2, "aznella@aznella.com", "aznella", "aznella", null));
        USERS.add(new User(3, "jamia@jamia.com", "jamia", "jamia", null));
        USERS.add(new User(4, "corley@corley.com", "corley", "corley", null));
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
        Tag happy = new Tag(4, "happy");
        TAGS.add(happy);
        Tag nature = new Tag(5, "nature");
        TAGS.add(nature);
        Tag animals = new Tag(6, "animals");
        TAGS.add(animals);
        Tag portrait = new Tag(7, "portrait");
        TAGS.add(portrait);
        Tag landscapes = new Tag(8, "landscapes");
        TAGS.add(landscapes);
        Tag abst = new Tag(9, "abstract");
        TAGS.add(abst);
        Tag threeD = new Tag(10, "3d");
        TAGS.add(threeD);
        Tag sciFi = new Tag(11, "sci-fi");
        TAGS.add(sciFi);
        Tag material = new Tag(12, "material");
        TAGS.add(material);
        Tag contemporary = new Tag(13, "contemporary");
        TAGS.add(contemporary);
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

//                final Map<String, String> env = new HashMap<>();
//                final String[] array = artwork.toURI().toString().split("!");
//                final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);
//                final Path path = fs.getPath(array[1]);

//                byte[] image = Files.readAllBytes(path);
//                fs.close();
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
