package edu.westga.devops.theartistsdreamclient.model;

import java.util.List;
import java.util.ArrayList;
import edu.westga.devops.theartistsdreamclient.model.Artwork;

/**
 * ArtworkManager Collection Abstract Class
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public abstract class ArtworkManager {

	private List<Artwork> artworks;

	/**
	 * Creates a new ArtworkManager
	 *
	 * @precondition artworks != null
	 * @postcondition getArtworks() == artworks
	 *
	 * @throws IllegalArgumentException if artworks is null
	 */
	public ArtworkManager() {
		this.artworks = new ArrayList<Artwork>();
	}

	/**
	 * Gets the artworks
	 *
	 * @precondition none
	 * @postcondition none
	 * @return the artworks
	 */
	public List<Artwork> getArtworks() {
		return this.artworks;
	}

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
	public Artwork getArtwork(int id) {
		for (Artwork artwork : this.artworks) {
			if(artwork.getID() == id){
				return artwork;
			}
		}
		return null;
	}

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
	public boolean addArtwork(Artwork artwork) {
		return this.artworks.add(artwork);
	}

	/**
	 * Removes the artwork specified by the id
	 *
	 * @precondition none
	 * @postcondition getArtworks().size() == getArtworks().size() - 1 @prev
	 *
	 * @param id the id of the artwork to remove
	 *
	 * @return trueif the artwork was successfully removed, false otherwise
	 */
	public boolean removeArtwork(int id) {
		for (Artwork artwork: this.artworks) {
			if (artwork.getID() == id) {
				return this.artworks.remove(artwork);
			}
		}
		return false;
	}

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
	public boolean editArtwork(int id, String newTitle, List<Tag> newTags){
		if (newTitle == null) {
			throw new IllegalArgumentException();
		}
		if (newTitle.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if (newTags == null) {
			throw new IllegalArgumentException();
		}
		Artwork artworkToEdit = this.getArtwork(id);
		artworkToEdit.setTitle(newTitle);
		artworkToEdit.setTags(newTags);
		return true;
	}

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
	public List<Artwork> getFollowingArtworks(int userId) {
		return null;
	}

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
	public List<Artwork> getArtworksOfArtist(int userId) {
		return null;
	}
}
