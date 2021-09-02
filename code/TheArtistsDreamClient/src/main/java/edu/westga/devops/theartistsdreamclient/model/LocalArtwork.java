package edu.westga.devops.theartistsdreamclient.model;

import javafx.scene.image.Image;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.Artwork;
import java.util.List;

/**
 * Local Implementation of Model Class Artwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class LocalArtwork extends Artwork {
	
	private Image image;
	private String title;
	private String artistUsername;
	private List<Tag> tags;
	private int id;

	/**
	 * Creates an Artwork Object
	 *
	 * @param artwork the image of the artwork
	 * @param artworkTitle the title of the artwork
	 *
	 * @precondition none
	 * @postcondition none
	 */
	public LocalArtwork(Image image, String title, String artistUsername, List<Tag> tags, int id) {
		super(image, title, artistUsername, tags, id);

	}
}

