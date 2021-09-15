package edu.westga.devops.theartistsdreamclient.model;

import javafx.scene.image.Image;
import java.util.List;

/**
 * Model Class Artwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class Artwork {
	
	private Image image;
	private String title;
	private int artistID;
	private List<Integer> tagIDs;
	private int id;
  
    /**
     * Creates a new Artwork
     *
     * @param image          the image of the artwork
     * @param title          the title of the artwork
     * @param artistUsername the artist of the artwork's username
     * @param tags           the tags of the artwork
     * @param id             the id of the artwork
     * @throws IllegalArgumentException if a precondition is not met
     * @precondition image != null && !title.isEmpty() && title != null && artistID > 0&& tagIDs != null && id > 0
     * @postcondition getImage() == image && getTitle == title && getArtistID() == artistID && getTagIDs() == tagIDs && getID == id
     */
    public Artwork(Image image, String title, int artistID, List<Integer> tagIDs, int id) {
        if (image == null) {
            throw new IllegalArgumentException();
        }
        if (title == null) {
            throw new IllegalArgumentException();
        }
        if (title.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (artistID <= 0) {
            throw new IllegalArgumentException();
        }
        if (tagIDs == null) {
            throw new IllegalArgumentException();
        }
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        this.image = image;
        this.title = title;
        this.artistID = artistID;
        this.tagIDs = tagIDs;
        this.id = id;
    }

	public Image getImage() {
        	return this.image;
	}

	public String getTitle() {
        	return this.title;
	}

	public int getArtistID() {
        	return this.artistID;
	}

	public List<Integer> getTagIDs() {
        	return this.tagIDs;
	}

	public int getID() {
        	return this.id;
	}

	public void setTags(List<Integer> newTagIDs) {
		if(newTagIDs == null) {
			throw new IllegalArgumentException();
		}
		this.tagIDs = newTagIDs;
	}

	public void setTitle(String newTitle) {
		if(newTitle == null) {
			throw new IllegalArgumentException();
		}
		if(newTitle.isEmpty()) {
			throw new IllegalArgumentException();
		}
        	this.title = newTitle;
	}

}

