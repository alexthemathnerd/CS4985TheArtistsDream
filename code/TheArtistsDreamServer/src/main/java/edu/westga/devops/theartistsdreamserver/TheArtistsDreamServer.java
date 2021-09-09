package edu.westga.devops.theartistsdreamserver;

import edu.westga.devops.theartistsdreamserver.model.Receiver;

import java.io.Console;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class TheArtistsDreamServer {

    public static final Logger LOGGER = Logger.getLogger("The Artist's Dream Server");

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
        Receiver receiver = new Receiver("tcp://localhost:4444");
        receiver.start();
        LOGGER.info("Receiver is ending.");
    }
}