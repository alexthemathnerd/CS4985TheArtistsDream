package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.Artwork;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Local Implementation of Collection Class ArtworkManager
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class LocalArtworkManager extends ArtworkManager {

	private final List<LocalArtwork> artworks;

	/**
	 * Creates a new Artworks Collection
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 */
	public LocalArtworkManager() {
		this.artworks = new ArrayList<LocalArtwork>();
	}

	@Override
	public List<Artwork> getFirstFiftyArtworks() {
		List<Artwork> abstractArtworks = (List)new ArrayList<LocalArtwork>(this.artworks);
		return abstractArtworks.subList(0, 50);
	}

	@Override
	public List<Artwork> getNextTenArtworks(int startingIndex) {
		List<Artwork> abstractArtworks = (List)new ArrayList<LocalArtwork>(this.artworks);
		return abstractArtworks.subList(startingIndex, startingIndex + 10);
	}

	@Override
	public Artwork getArtwork(int id) {
		for (LocalArtwork artwork : this.artworks) {
			if(artwork.getID() == id){
				return (Artwork)artwork;
			}
		}
		return null;
	}

	@Override
	public boolean addArtwork(Artwork artwork) {
		return this.artworks.add((LocalArtwork)artwork);
	}

	@Override
	public boolean removeArtwork(int id) {
		for (LocalArtwork artwork: this.artworks) {
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
	public Iterator iterator() {
		return this.artworks.iterator();
	}

	@Override
	public int size() {
		return this.artworks.size();
	}
		
}
