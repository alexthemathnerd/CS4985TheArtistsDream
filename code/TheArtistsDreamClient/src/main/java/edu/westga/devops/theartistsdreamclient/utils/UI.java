package edu.westga.devops.theartistsdreamclient.utils;

public class UI {

    public enum ServerCodes {
        TODO;
    }

    public static class ErrorMessages {
        public static final String NEGATIVE_ID = "id cannot be negative";
        public static final String CONTENT_NULL = "content cannot be null";
        public static final String TAG_NAME_NULL = "tag name cannot be null";
        public static final String NEGATIVE_AMOUNT = "amount cannot be negative";
        public static final String TAG_NAME_EMPTY = "tag name cannot be empty";
        public static final String SEVER_CONNECTION = "server connection failed, check address";
        public static final String CODE_NULL = "server code cannot be null";
    }

    public static class GuiMessages {
        public static final String INVALID_EMAIL = "Must enter a valid email";
        public static final String INVALID_PASSWORD = "Password must be at least 7 characters long";
        public static final String MISMATCH_PASSWORD = "Passwords must match";
        public static final String USER_EXISTS = "User already exists";
    }

}
