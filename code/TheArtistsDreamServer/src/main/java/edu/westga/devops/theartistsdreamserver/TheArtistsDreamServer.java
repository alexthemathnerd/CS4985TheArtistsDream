package edu.westga.devops.theartistsdreamserver;

import edu.westga.devops.theartistsdreamserver.model.Receiver;
import edu.westga.devops.theartistsdreamserver.model.Tag;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class TheArtistsDreamServer {

    public static final Logger LOGGER = Logger.getLogger("The Artist's Dream Server");
    public static final List<Tag> TAGS = new ArrayList<Tag>();

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
        setupFakeServerData();
        Receiver receiver = new Receiver("tcp://localhost:4444");
        receiver.start();
        LOGGER.info("Receiver is ending.");
    }

    private static void setupFakeServerData() {
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
}