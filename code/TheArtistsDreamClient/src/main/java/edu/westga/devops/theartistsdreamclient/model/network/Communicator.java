package edu.westga.devops.theartistsdreamclient.model.network;

import com.google.gson.Gson;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.utils.UI;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.io.Closeable;
import java.lang.reflect.Type;

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

    private final ZContext context;
    private final ZMQ.Socket socket;

    /**
     * Creates a Communicator with the server that is connected to the given address
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
     * @param <T>     the type of the response
     * @param type    the type
     * @return the response from the server
     * @precondition server must be connected
     * @postcondition none
     * @see Response
     */
    public <T> Response<T> request(Request request, Type type) {
        if (this.context.isClosed()) {
            throw new IllegalStateException();
        }
        Gson gson = new Gson();
        String json = gson.toJson(request);
        TheArtistsDreamApplication.LOGGER.info("Sending Message " + request.getCode());
        this.socket.send(json);
        String reply = this.socket.recvStr(0);
        return gson.fromJson(reply, type);
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
     * @return true if the communicator is closed, false otherwise
     * @precondition none
     * @postcondition none
     */
    public boolean isClosed() {
        return this.context.isClosed();
    }
}
