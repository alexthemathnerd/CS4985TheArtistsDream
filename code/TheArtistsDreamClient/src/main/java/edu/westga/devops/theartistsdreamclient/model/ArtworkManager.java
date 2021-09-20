package edu.westga.devops.theartistsdreamclient.model;

import java.util.List;
import edu.westga.devops.theartistsdreamclient.model.Artwork;

/**
 * ArtworkManager Collection Abstract Class
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public abstract class ArtworkManager {

	private static ArtworkManager artworkManager = null;

	/**
	 * Gets the first fifty artworks
	 *
	 * @precondition none
	 * @postcondition none
	 * @return the first 50 artworks
	 */
	public abstract List<Artwork> getFirstFiftyArtworks();

	/**
	 * Gets the first fifty artworks of the specified user
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param userId the user id to get the artworks of
	 *
	 * @return the first fifty artworks of the user
	 */
	public abstract List<Artwork> getFirstFiftyArtworks(int userId);

	/**
	 * Gets the first fifty artworks if the user is following
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param isFollowing determines if the user is following
	 *
	 * @return the first fifty artworks
	 */
	public abstract List<Artwork> getFirstFiftyArtworks(boolean isFollowing);

	
	/**
	 * Gets the next ten artworks
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param startingIndex the starting index to get the next 10 artworks from
	 *
	 * @return the next ten artworks from the starting index
	 */
	public abstract List<Artwork> getNextTenArtworks(int startingIndex);

	/**
	 * Gets the next ten artworks of the specified user
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param startingIndex the starting index to get the next 10 artworks from
	 * @param userId the id of the user to get the next 10 artworks from
	 *
	 * @return the next ten artworks of the user from the starting index
	 */
	public abstract List<Artwork> getNextTenArtworks(int startingIndex, int userId);

	/**
	 * Gets the artwork specified by the id
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param id the id of the artwork to get
	 *
	 * @return the artwork specified by the id
	 */
	public abstract Artwork getArtwork(int id);

	/**
	 * Adds the artwork
	 *
	 * @precondition artwork != null
	 * @postcondition getArtworks().size() == getArtworks().size() + 1 @prev
	 *
	 * @param artwork the artwork to add
	 *
	 * @return true if the artwork was successfully added, false otherwise
	 */
	public abstract boolean addArtwork(Artwork artwork);

	/**
	 * Removes the artwork specified by the id
	 *
	 * @precondition none
	 * @postcondition getArtworks().size() == getArtworks().size() - 1 @prev
	 *
	 * @param id the id of the artwork to remove
	 *
	 * @return true if the artwork was successfully removed, false otherwise
	 */
	public abstract boolean removeArtwork(int id);

	/**
	 * Edits the artwork of the specified id by changing its title and tags
	 *
	 * @precondition !newTitle.isEmpty() && newTitle != null && newTags != null
	 * @postcondition getArtwork(id).getTitle() == newTitle && getArtwork(id).getTags() == newTags
	 *
	 * @param id the id of the artwork to edit
	 * @param newTitle the new title of the artwork
	 * @param newTags the new tags of the artwork
	 *
	 * @return true if the artwork was successfully edited, false otherwise
	 */
	public abstract boolean editArtwork(int id, String newTitle, List<Integer> newTagIDs);

	/**
	 * Gets the artworks of the artists the user follows
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param userId the id of the user logged in
	 *
	 * @return a list of the artworks from the artists followed
	 */
	public abstract List<Artwork> getFollowingArtworks(int userId);

	/**
	 * Gets the artworks of the user specified by the id
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param userId the id of the user to get the artworks from
	 *
	 * @return the artworks from the specified artist
	 */
	public abstract List<Artwork> getArtworksOfArtist(int userId);

    /**
     * Gets the singleton of the artwork manager
     *
     * @return the singleton of the artwork manager
     * @precondition none
     * @postcondition none
     */
    public static ArtworkManager getArtworkManager() {
        return ArtworkManager.artworkManager;
    }

    /**
     * Sets the artwork manager singleton
     *
     * @param artworkManager the new artwork manager
     * @preconditon artworkManager != null
     * @postcondition ArtworkManager.getArtworkManager().equals(artworkManager)
     */
    public static void setArtworkManager(ArtworkManager artworkManager) {
        if (artworkManager == null) {
            throw new IllegalArgumentException();
        }
        ArtworkManager.artworkManager = artworkManager;
    }

    /**
     * Gets the artworks specified by the tags
     *
     * @precondition tags != null
     * @postcondition none
     *
     * @return the artworks specified by the tags
     */
    public abstract List<Artwork> getArtworksOfTags(List<Tag> tags);

	public abstract List<Artwork> searchForArtworks(String searchTerm);

}
