package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.Tag;

import java.util.List;
import java.util.ArrayList;

/**
 * Local Implementation of Collection Class ArtworkManager
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class LocalArtworkManager extends ArtworkManager {

	private final List<Artwork> artworks;

	/**
	 * Creates a new Artworks Collection
	 *
	 * @precondition none
	 * @postcondition size() == 0
	 *
	 */
	public LocalArtworkManager() {
		this.artworks = new ArrayList<Artwork>();
	}

	@Override
	public List<Artwork> getFirstFiftyArtworks() {
		return this.artworks.subList(0, 50);
	}

	@Override
	public List<Artwork> getFirstFiftyArtworks(int userId) {
		return null;
	}

	@Override
	public List<Artwork> getNextTenArtworks(int startingIndex) {
		return this.artworks.subList(startingIndex, startingIndex + 10);
	}

	@Override
	public List<Artwork> getNextTenArtworks(int startingIndex, int userId) {
		return null;
	}

	@Override
	public Artwork getArtwork(int id) {
		for (Artwork artwork : this.artworks) {
			if(artwork.getID() == id){
				return artwork;
			}
		}
		return null;
	}

	@Override
	public boolean addArtwork(Artwork artwork) {
		return this.artworks.add(artwork);
	}

	@Override
	public boolean removeArtwork(int id) {
		for (Artwork artwork: this.artworks) {
			if (artwork.getID() == id) {
				return this.artworks.remove(artwork);
			}
		}
		return false;
	}

	@Override
	public boolean editArtwork(int id, String newTitle, List<Integer> newTagIDs){
		if (newTitle == null) {
			throw new IllegalArgumentException();
		}
		if (newTitle.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if (newTagIDs == null) {
			throw new IllegalArgumentException();
		}
		Artwork artworkToEdit = this.getArtwork(id);
		if (artworkToEdit == null) {
			return false;
		}
		artworkToEdit.setTitle(newTitle);
		artworkToEdit.setTags(newTagIDs);
		return true;
	}

	@Override
	public List<Artwork> getFollowingArtworks(int userId) {
		return null;
	}

	@Override
	public List<Artwork> getArtworksOfArtist(int userId) {
		return null;
	}

	@Override
	public List<Artwork> getArtworksOfTags(List<Tag> tags) {
		List<Artwork> tagArtworks = new ArrayList<>();
		for (Artwork aArtwork: this.artworks) {
			for (Tag aTag: tags) {
				if (aArtwork.getTagIDs().contains(aTag.getId())) {
					tagArtworks.add(aArtwork);
					break;
				}
			}
		}
		return tagArtworks;
	}

	/**
	 * Gets the size
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the size
	 */
	public int size() {
		return this.artworks.size();
	}

	@Override
	public List<Artwork> getFirstFiftyArtworks(boolean isFollowing) {
		return null;
	}

	@Override 
	public List<Artwork> searchForArtworks(String searchTerm) {
		List<Artwork> searchedArtworks = new ArrayList<Artwork>();
		for (Artwork artwork: this.artworks) {
			if (artwork.getTitle().contains(searchTerm)) {
				searchedArtworks.add(artwork);
			}
		}
		return searchedArtworks;
	}
		
}
