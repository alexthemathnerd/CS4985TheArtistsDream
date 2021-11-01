package edu.westga.devops.theartistsdreamclient.model;

import java.util.List;

/**
 * ArtworkManager Collection Abstract Class
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public abstract class ArtworkManager {

    private static ArtworkManager artworkManager = null;

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
     * @preconditon none
     * @postcondition ArtworkManager.getArtworkManager().equals(artworkManager)
     */
    public static void setArtworkManager(ArtworkManager artworkManager) {
        ArtworkManager.artworkManager = artworkManager;
    }

    /**
     * Gets the first fifty artworks
     *
     * @return the first 50 artworks
     * @precondition none
     * @postcondition none
     */
    public abstract List<Artwork> getFirstFiftyArtworks();

    /**
     * Gets the first fifty artworks of the specified user
     *
     * @param userId the user id to get the artworks of
     * @return the first fifty artworks of the user
     * @precondition none
     * @postcondition none
     */
    public abstract List<Artwork> getFirstFiftyArtworks(int userId);

    /**
     * Gets the first fifty artworks if the user is following
     *
     * @param isFollowing determines if the user is following
     * @return the first fifty artworks
     * @precondition none
     * @postcondition none
     */
    public abstract List<Artwork> getFirstFiftyArtworks(boolean isFollowing);

    /**
     * Gets the next ten artworks
     *
     * @param startingIndex the starting index to get the next 10 artworks from
     * @return the next ten artworks from the starting index
     * @precondition none
     * @postcondition none
     */
    public abstract List<Artwork> getNextTenArtworks(int startingIndex);

    /**
     * Gets the next ten artworks of the specified user
     *
     * @param startingIndex the starting index to get the next 10 artworks from
     * @param userId        the id of the user to get the next 10 artworks from
     * @return the next ten artworks of the user from the starting index
     * @precondition none
     * @postcondition none
     */
    public abstract List<Artwork> getNextTenArtworks(int startingIndex, int userId);

    /**
     * Adds the artwork
     *
     * @param imageData the image data of the artwork
     * @param title     the title of the artwork
     * @param artistID  the artist of the artwork's ID
     * @param tagIDs    the ids of the tags of the artwork
     * @param date      the date the artwork was posted
     * @return true if the artwork was successfully added, false otherwise
     * @precondition artwork != null
     * @postcondition getArtworks().size() == getArtworks().size() + 1 @prev
     */
    public abstract boolean addArtwork(byte[] imageData, String title, int artistID, List<Integer> tagIDs, String date);

    /**
     * Removes the artwork specified by the id
     *
     * @param id the id of the artwork to remove
     * @return true if the artwork was successfully removed, false otherwise
     * @precondition none
     * @postcondition getArtworks().size() == getArtworks().size() - 1 @prev
     */
    public abstract boolean removeArtwork(int id);

    /**
     * Edits the artwork of the specified id by changing its title and tags
     *
     * @param id        the id of the artwork to edit
     * @param newTitle  the new title of the artwork
     * @param newTagIDs the IDs of the new tags of the artwork
     * @return true if the artwork was successfully edited, false otherwise
     * @precondition !newTitle.isEmpty() && newTitle != null && newTags != null
     * @postcondition getArtwork(id).getTitle() == newTitle && getArtwork(id).getTags() == newTags
     */
    public abstract boolean editArtwork(int id, String newTitle, List<Integer> newTagIDs);

    /**
     * Gets the artworks specified by the tags
     *
     * @param tags The list of tags
     * @return the artworks specified by the tags
     * @precondition tags != null
     * @postcondition none
     */
    public abstract List<Artwork> getArtworksOfTags(List<Tag> tags);

    /**
     * Gets the artworks specified by the search term
     *
     * @param searchTerm the entered search value
     * @return the artworks specified by the searchTerm
     * @precondition searchTerm != null && !searchTerm.isEmpty()
     * @postcondition none
     */
    public abstract List<Artwork> searchForArtworks(String searchTerm);

    /**
     * Gets the artwork specified by the title
     *
     * @param title the title of the artwork
     * @return the artworks specified by the title
     * @precondition title != null && !title.isEmpty()
     * @postcondition none
     */
    public abstract Artwork retrieveSearchedArtwork(String title);

}
