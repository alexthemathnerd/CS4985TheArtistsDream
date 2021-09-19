package edu.westga.devops.theartistsdreamserver.model;

/**
 * Request Class
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class Request {

    private String error;
    private Object data;

    /**
     * Creates a new request
     *
     * @param error the error message of the request
     * @param data the data of the request
     *
     * @precondition none
     * @postcondition getError() == error && getData() == data
     */
    public Request(String error, Object data) {
        this.error = error;
        this.data = data;
    }

    /**
     * Creates a new Request
     *
     * @param error the error message of the request
     *
     * @precondition none
     * @postcondition getError() == error && getData() == null
     */
    public Request(String error) {
        this(error, null);
    }

    /**
     * Creates a new Request
     *
     * @param data the data of the request
     *
     * @precondition none
     * @postcondition getError() == null && getData() == data
     */
    public Request(Object data) {
        this(null, data);
    }

    /**
     * Gets the error message
     *
     * @precondition none
     * @postcondition none
     *
     * @return the error message
     */
    public String getError() {
	return this.error;
    }

    /**
     * Gets the data
     *
     * @precondition none
     * @postcondition none
     *
     * @return the data 
     */
    public Object getData() {
	return this.data;
    }
}
