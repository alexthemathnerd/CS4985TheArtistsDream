package edu.westga.devops.theartistsdreamserver.utils;

import edu.westga.devops.theartistsdreamserver.model.*;

/**
 * UI Class
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class UI {

    /**
     * ServerCodes Enum
     *
     * @author Alexander Schmidt
     * @version Fall 2021
     */
    public enum ServerCodes {
        TODO((response) -> new Request("error", null)),
        ADD_TAG(TagManager::addTag),
        ADD_USER(UserManager::addUser),
        GET_USER(UserManager::getUser),
	    FIND_USER(UserManager::findUser),
        RETRIEVE_USER(UserManager::retrieveSearchedUser),
        RETRIEVE_ARTWORK(ArtworkManager::retrieveSearchedArtwork),
        GET_TOP_TAGS(TagManager::getTopTags),
        SEARCH_USERS(UserManager::searchForUser),
        SEARCH_ARTWORKS(ArtworkManager::searchForArtworks),
        GET_FIRST_FIFTY_ARTWORKS(ArtworkManager::getFirstFiftyArtworks),
        GET_NEXT_TEN_ARTWORKS(ArtworkManager::getNextTenArtworks),
        ADD_ARTWORK(ArtworkManager::addArtwork),
        REMOVE_ARTWORK(ArtworkManager::removeArtwork),
        EDIT_ARTWORK(ArtworkManager::editArtwork),
        GET_ARTWORKS_OF_TAGS(ArtworkManager::getArtworksOfTags),
        FOLLOW_ARTIST(UserManager::followArtist),
        UNFOLLOW_ARTIST(UserManager::unfollowArtist),
        GET_FOLLOWERS(UserManager::getFollowerIds),
        GET_FOLLOWINGS(UserManager::getFollowingIds),
        IS_FOLLOWING(UserManager::isFollowing);

        private ServerAction action;

        ServerCodes(ServerAction action) {
            this.action = action;
        }

	/**
	 * Executes the ServerAction
	 *
	 * @param data the data
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return a request to execute the data
	 */
        public Request execute(Object[] data) {
            return this.action.execute(data);
        }

	/**
	 * ServerAction Interface
	 *
	 * @author Alexander Schmidt
	 * @version Fall 2021
	 */
        public interface ServerAction {

            Request execute(Object[] data);

        }
    }

    /**
     * ErrorMessages Class
     *
     * @author Alexander Schmidt
     * @version Fall 2021
     */
    public static class ErrorMessages {

        public static final String SERVER_START = "server failed to start check address";
        public static final String SERVER_CLOSED = "server already closed";
        public static final String CODE_NULL = "server code cannot be null";
        public static final String INVALID_FORMAT = "Invalid format";
        public static final String ARTWORK_NOT_FOUND = "Artwork not found";
        public static final String USER_EXISTS = "User already exists";
        public static final String USER_NOT_FOUND = "User not found";
    }
}
