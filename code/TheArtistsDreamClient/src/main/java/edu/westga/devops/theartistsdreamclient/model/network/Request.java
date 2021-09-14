package edu.westga.devops.theartistsdreamclient.model.network;

import edu.westga.devops.theartistsdreamclient.utils.UI;
import edu.westga.devops.theartistsdreamclient.utils.UI.ServerCodes;

/**
 * A data class to store a request to the server.
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class Request {
    private ServerCodes code;
    private Object[] data;

    /**
     * Creates a request object
     *
     * @param code the server code to be performed.
     * @param data the data need for the server
     * @precondition code != null
     * @postcondition getCode() == code && getData() == data
     */
    public Request(ServerCodes code, Object[] data) {
        if (code == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.CODE_NULL);
        }
        this.code = code;
        this.data = data;
    }

    /**
     * Gets the server code of the request
     *
     * @return the server code
     * @precondition none
     * @postcondition none
     * @see ServerCodes
     */
    public ServerCodes getCode() {
        return this.code;
    }

    /**
     * Gets the data of the request
     *
     * @return the data
     * @precondition none
     * @postcondition none
     */
    public Object[] getData() {
        return this.data;
    }

}