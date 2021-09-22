package edu.westga.devops.theartistsdreamclient.model.network;

/**
 * A data class to store information of the server's responce
 * 
 * @param <T> The type of the response
 * 
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class Response<T> {

    private String error;
    private T data;

    /**
     * Creates a response. Should only be used by Gson
     *
     * @param error the error of the response
     * @param data the data of the response
     * @precondition none
     * @postcondition getError() == error && getData() == data
     * @see com.google.gson.Gson
     */
    public Response(String error, T data) {
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
    public T getData() {
        return this.data;
    }
}
