package edu.westga.devops.theartistsdreamserver.model;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.utils.UI;

/**
 * Response Class
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class Response {

    private UI.ServerCodes code;
    private Object[] data;

    /**
     * Creates a new Response
     *
     * @param code the ServerCode of the repsonse
     * @param data the data of the response
     *
     * @precondition code != null
     * @postcondition getCode() == code && getData() == data
     *
     * @throws IllegalArgumentException if the precondition is not met
     */
    public Response(UI.ServerCodes code, Object[] data) {
        if (code == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.CODE_NULL);
        }
        this.code = code;
        this.data = data;
    }

    /**
     * Executes the response
     *
     * @precondition none
     * @postcondition none
     *
     * @return the executed request
     */
    public Request execute() {
        TheArtistsDreamServer.LOGGER.info("Executing server action: " + this.code.name());
        return this.code.execute(this.data);
    }

    /**
     * Gets the code
     *
     * @precondition none
     * @postcondition none
     *
     * @return the code
     */
    public UI.ServerCodes getCode() {
        return this.code;
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
