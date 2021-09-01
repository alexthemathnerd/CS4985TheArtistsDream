package edu.westga.devops.theartistsdreamclient.model;

/**
 * Artwork Model Class
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */

import javafx.scene.image.Image;
import java.lang.String;

public class Artwork {
	
	private Image artworkImage;
	private String artworkTitle;

	/**
	 * Creates an Artwork Object
	 *
	 * @param artwork the image of the artwork
	 * @param artworkTitle the title of the artwork
	 *
	 * @precondition artworkImage != null && !artworkTitle.isEmpty() && artworkTitle != null
	 * @postcondition getArtworkImage() == artworkImage && getArtworkTitle() == artworkTitle
	 */
	public Artwork(Image artworkImage, String artworkTitle) {
		this.artworkImage = artworkImage;
		this.artworkTitle = artworkTitle;
	}

	/**
	 * Gets the artwork image
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the artwork image
	 */
	public Image getArtworkImage() {
		return this.artworkImage;
	}

	/**
	 * Gets the artwork title
	 *
	 * @precondition none
	 * @postcondition none
	 */
	public String getArtworkTitle() {
		return this.artworkTitle;
	}
}
