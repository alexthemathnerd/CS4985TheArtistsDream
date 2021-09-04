package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.local.LocalArtwork;

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

	private List<LocalArtwork> artworks;

	/**
	 * Creates a new Artworks Collection
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 */
	public LocalArtworkManager() {
		super();
		this.artworks = new ArrayList<LocalArtwork>();
	}
		
}
