package edu.westga.devops.theartistsdreamclient.model.network;

import com.google.gson.Gson;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.utils.UI;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.io.Closeable;

/**
 * A class to handle communication with the server. Example of use:
 * <p>
 * try (Communicator communicator = new Communicator("tcp://localhost:4444")) {
 * <p>
 * //USE COMMUNICATOR
 * <p>
 * }
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class Communicator implements Closeable {

    private ZContext context;
    private ZMQ.Socket socket;

    /**
     * Creates a Communicator with the server that is connected to the give address
     *
     * @param serverAddress the address of the server
     * @precondition serverAddress is valid
     * @postcondition connected to server
     */
    public Communicator(String serverAddress) {
        this.context = new ZContext(1);
        this.socket = this.context.createSocket(SocketType.REQ);
        try {
            if (!this.socket.connect(serverAddress)) {
                TheArtistsDreamApplication.LOGGER.severe("Unable to connect to server");
                this.close();
            }
        } catch (IllegalArgumentException e) {
            TheArtistsDreamApplication.LOGGER.severe(UI.ErrorMessages.SEVER_CONNECTION);
            this.close();
        }
    }

    /**
     * Requests to the server with the given request and returns its response
     *
     * @param request the request to be sent to the server
     * @return the response from the server
     * @precondition server must be connected
     * @postcondition none
     * @see Response
     */
    public Response request(Request request) {
        if (this.context.isClosed()) {
            throw new IllegalStateException();
        }
        Gson gson = new Gson();
        String json = gson.toJson(request);
        this.socket.send(json);
        String reply = this.socket.recvStr(0);
        return gson.fromJson(reply, Response.class);
    }

    @Override
    public void close() {
        this.context.close();
    }

    @Override
    public void finalize() {
        this.close();
    }

    /**
     * Checks if communicator is closed
     *
     * @precondition none
     * @postcondition none
     *
     * @return true if communicator is closed; false otherwise
     */
    public boolean isClosed() {
        return this.context.isClosed();
    }
}
