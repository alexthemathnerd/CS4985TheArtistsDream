package edu.westga.devops.theartistsdreamserver.utils;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.model.Request;
import edu.westga.devops.theartistsdreamserver.model.TagManager;
import edu.westga.devops.theartistsdreamserver.model.UserManager;
import edu.westga.devops.theartistsdreamserver.model.ArtworkManager;

/**
 * UI Class
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class UI {

    public enum ServerCodes {
        TODO((response) -> new Request("error", null)),
        ADD_TAG(TagManager::addTag),
        ADD_USER(UserManager::addUser),
        GET_USER(UserManager::getUser),
        FIND_USER(UserManager::findUser),
        GET_TOP_TAGS(TagManager::getTopTags),
        GET_FIRST_FIFTY_ARTWORKS(ArtworkManager::getFirstFiftyArtworks),
        GET_NEXT_TEN_ARTWORKS(ArtworkManager::getNextTenArtworks),
        ADD_ARTWORK(ArtworkManager::addArtwork),
        REMOVE_ARTWORK(ArtworkManager::removeArtwork),
        EDIT_ARTWORK(ArtworkManager::editArtwork),
        GET_ARTWORKS_OF_TAGS(ArtworkManager::getArtworksOfTags);


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
