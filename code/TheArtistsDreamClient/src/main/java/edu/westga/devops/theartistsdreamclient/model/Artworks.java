package edu.westga.devops.theartistsdreamclient.model;

/**
 * Collection Class Artworks
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */

import java.util.List;
import java.util.ArrayList;

import edu.westga.devops.theartistsdreamclient.model.Artwork;

public class Artworks {

	private List<Artwork> artworks;

	/**
	 * Creates a new Artworks Collection
	 *
	 * @precondition none
	 * @postcondition getArtworks() != null
	 *
	 */
	public Artworks(){
		this.artworks = new ArrayList<Artwork>();
	}

	/**
	 * Gets the artworks
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the artworks
	 */
	public List<Artwork> getArtworks() {
		return this.artworks;
	}

}
