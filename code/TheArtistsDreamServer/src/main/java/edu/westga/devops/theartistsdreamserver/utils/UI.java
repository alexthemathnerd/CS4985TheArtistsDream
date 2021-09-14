package edu.westga.devops.theartistsdreamserver.utils;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.Request;
import edu.westga.devops.theartistsdreamserver.model.TagManager;

public class UI {

    public enum ServerCodes {
        TODO((response) -> new Request("error", null)),
        ADD_TAG(TagManager::addTag),
        GET_TOP_TAGS(TagManager::getTopTags);

        private ServerAction action;

        ServerCodes(ServerAction action) {
            this.action = action;
        }

        public Request execute(Object[] data) {
            return this.action.execute(data);
        }

        public interface ServerAction {

            Request execute(Object[] data);

        }
    }

    public static class ErrorMessages {

        public static final String SERVER_START = "server failed to start check address";
        public static final String SERVER_CLOSED = "server already closed";
        public static final String CODE_NULL = "server code cannot be null";
    }
}
