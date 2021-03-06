package edu.westga.devops.theartistsdreamserver.model;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.utils.UI;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

/**
 * Receiver Class
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class Receiver extends Thread {

    private final String address;

    /**
     * Creates a receiver at the specified address
     *
     * @param address the address to set the receiver to
     *
     * @precondition none
     * @postcondition none
     */
    public Receiver(String address) {
        this.address = address;
    }

    @Override
    public void start() {
        try (ZContext context = new ZContext(1)) {
            ZMQ.Socket socket = context.createSocket(SocketType.REP);
            TheArtistsDreamServer.LOGGER.info("Connecting Reciever on " + this.address);
            if (!socket.bind(this.address)) {
                TheArtistsDreamServer.LOGGER.severe("server was not able to establish on" + this.address);
                throw new IllegalStateException(UI.ErrorMessages.SERVER_START);
            }
            Gson gson = new Gson();
            while (!Thread.currentThread().isInterrupted()) {
                String reply = socket.recvStr(0);
                TheArtistsDreamServer.LOGGER.info("received message");
                Request message;
                try {
                    Response response = gson.fromJson(reply, Response.class);
                    message = response.execute();
                } catch (JsonIOException e) {
                    TheArtistsDreamServer.LOGGER.warning("received data no in the correct format");
                    message = new Request("received data no in the correct format");
                }
                this.delay(1000);

                String json = gson.toJson(message);
                TheArtistsDreamServer.LOGGER.info("Sending back a reply");
                socket.send(json);
            }
        }
    }

    private void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("[INTERUPT]");
        }
    }
}
