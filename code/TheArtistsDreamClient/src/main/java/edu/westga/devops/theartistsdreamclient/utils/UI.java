package edu.westga.devops.theartistsdreamclient.utils;

/**
 * The UI Class
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class UI {

    /**
     * The ServerCodes Enum that holds codes of method names to be used in the Server project
     *
     * @author Alexander Schmidt
     * @version Fall 2021
     */
    public enum ServerCodes {
        TODO,
        ADD_TAG,
        GET_TOP_TAGS,
        ADD_USER,
        GET_USER,
        SEARCH_USERS,
        RETRIEVE_USER,
        FIND_USER,
        RETRIEVE_ARTWORK,
        SEARCH_ARTWORKS,
        GET_FIRST_FIFTY_ARTWORKS,
        GET_NEXT_TEN_ARTWORKS,
        GET_ARTWORK,
        ADD_ARTWORK,
        REMOVE_ARTWORK,
        EDIT_ARTWORK,
        GET_FOLLOWING_ARTWORKS,
        GET_ARTWORKS_OF_ARTIST,
        GET_ARTWORKS_OF_TAGS,
        SEND_MESSAGE,
        FOLLOW_ARTIST,
        UNFOLLOW_ARTIST,
        GET_FOLLOWERS,
        GET_FOLLOWINGS,
        IS_FOLLOWING
    }

    /**
     * ErrorMessages Class that provides error messages for Exceptions
     *
     * @author Alexander Schmidt
     * @version Fall 2021
     */
    public static class ErrorMessages {
        public static final String NEGATIVE_ID = "id cannot be negative";
        public static final String CONTENT_NULL = "content cannot be null";
        public static final String TAG_NAME_NULL = "tag name cannot be null";
        public static final String NEGATIVE_AMOUNT = "amount cannot be negative";
        public static final String TAG_NAME_EMPTY = "tag name cannot be empty";
        public static final String SEVER_CONNECTION = "server connection failed, check address";
        public static final String CODE_NULL = "server code cannot be null";
        public static final String USER_NOT_FOUND = "User is not found";
        public static final String COMMUNICATOR_NULL = "Communicator cannot be null";
        public static final String COMMUNICATOR_IS_CLOSED = "Communicator must be open";
        public static final String EMAIL_NULL = "Email cannot be null";
        public static final String EMAIL_EMPTY = "Email cannot be empty";
        public static final String USERNAME_NULL = "User name cannot be null";
        public static final String USERNAME_EMPTY = "Username cannot be empty";
        public static final String PASSWORD_NULL = "Password cannot be null";
        public static final String PASSWORD_EMPTY = "Password cannot be empty";
        public static final String USER_NULL = "User cannot be null";
        public static final String ARTWORK_NOT_FOUND = "Artwork not found";
        public static final String SEARCH_TERM_NULL = "Search term cannot be null";
        public static final String TITLE_NULL = "Title cannot be null";
        public static final String TITLE_EMPTY = "Title cannot be empty";
    }

    /**
     * GuiMessages Class that provides useful strings to be used in GUI error messages
     *
     * @author Alexander Schmidt
     * @version Fall 2021
     */
    public static class GuiMessages {
        public static final String INVALID_EMAIL = "Must enter a valid email";
        public static final String INVALID_PASSWORD = "Password must be at least 7 characters long";
        public static final String MISMATCH_PASSWORD = "Passwords must match";
        public static final String USER_EXISTS = "User already exists";
        public static final String USER_DOES_NOT_EXIST = "User does not exist";
    }

}
