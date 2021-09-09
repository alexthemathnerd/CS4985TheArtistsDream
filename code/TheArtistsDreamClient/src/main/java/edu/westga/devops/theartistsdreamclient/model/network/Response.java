package edu.westga.devops.theartistsdreamclient.model.network;

/**
 * A data class to store information of the server's responce
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class Response {

    private String error;
    private Object data;

    /**
     * Creates a response. Should only be used by Gson
     *
     * @param error the error of the response
     * @param data the data of the response
     * @precondition none
     * @postcondition getError() == error && getData() == data
     * @see com.google.gson.Gson
     */
    public Response(String error, Object data) {
        this.error = error;
        this.data = data;
    }

    /**
     * Gets the error of the response
     *
     * @return the error
     * @precondition none
     * @postcondition none
     */
    public String getError() {
        return this.error;
    }

    /**
     * Gets the data of the response
     *
     * @return the data
     * @precondition none
     * @postcondition none
     */
    public Object getData() {
        return this.data;
    }
}
