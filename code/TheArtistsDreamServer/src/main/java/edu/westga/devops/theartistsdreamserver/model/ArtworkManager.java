package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.Artwork;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Collection Class ArtworkManager
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class ArtworkManager {

	public static Request getFirstFiftyArtworks(Object[] data) {
		return this.artworks.subList(0, 50);
	}

	public static Request getNextTenArtworks(Object[] data) {
		int startingIndex;
		return this.artworks.subList(startingIndex, startingIndex + 10);
	}

	public static Request getArtwork(Object[] data) {
		int id;
		List<Artwork> artworks = new ArrayList<Artwork>();
		try {
			id = ((Double) data[0]).intValue());
		} catch (ClassCastException e) {
			return new Request("Invalid Format");
		}
		for (Artwork artwork : artworks) {
			if(artwork.getID() == id){
				return artwork;
			}
		}
		return null;
	}

	public static Request addArtwork(Object[] data) {
		int id;
		return this.artworks.add(artwork);
	}

	public static Request removeArtwork(Object[] data) {
		int id;
		for (Artwork artwork: this.artworks) {
			if (artwork.getID() == id) {
				return this.artworks.remove(artwork);
			}
		}
		return false;
	}

	public static Request editArtwork(Object[] data){
		int id;
		String newTitle;
		List<Integer> newTagIDs;
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

	public static Request getFollowingArtworks(Object[] data) {
		int userID;
		return null;
	}

	public static Request getArtworksOfArtist(Object[] data) {
		int userID;
		return null;
	}
		
}
