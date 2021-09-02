package edu.westga.devops.theartistsdreamclient.model;

/**
 * Local Implementation of Collection Class ArtworkManager
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */

import java.util.List;
import java.util.ArrayList;

import edu.westga.devops.theartistsdreamclient.model.LocalArtwork;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;

public class LocalArtworkManager extends ArtworkManager {

	private List<LocalArtwork> artworks;

	/**
	 * Creates a new Artworks Collection
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 */
	public LocalArtworkManager(List<LocalArtwork> artworks){
		super(new ArrayList<Artwork>()); //TODO: Change to <LocalArtwork>

		this.artworks = artworks;
	}
		
}
