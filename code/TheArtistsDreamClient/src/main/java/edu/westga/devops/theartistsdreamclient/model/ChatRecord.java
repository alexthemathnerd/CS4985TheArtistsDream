package edu.westga.devops.theartistsdreamclient.model;

/**
 * The class chat record
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class ChatRecord {
    private final int userId;
    private final String message;

    /**
     * Creates a new chat record
     *
     * @param userId  the user that sent the message
     * @param message the message that was sent
     * @precodition none
     * @postcondition none
     */
    public ChatRecord(int userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    /**
     * Gets the user id of who sent the message
     *
     * @return the user who sent the message
     * @precondition none
     * @postcondition none
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * Gets the message that was sent
     *
     * @return the message that was sent
     * @precondition none
     * @postcondition none
     */
    public String getMessage() {
        return this.message;
    }
}
