package edu.westga.devops.theartistsdreamclient.model;

import javafx.scene.image.Image;
import java.util.List;
import java.time.LocalDate;

/**
 * Model Class Artwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class Artwork {
	
	private byte[] imageData;
	private transient Image image;
	private String title;
	private int artistID;
	private List<Integer> tagIDs;
	private int id;
	private String date;
  
    /**
     * Creates a new Artwork
     *
     * @param image          the image of the artwork
     * @param title          the title of the artwork
     * @param artistUsername the artist of the artwork's username
     * @param tags           the tags of the artwork
     * @param id             the id of the artwork
     * @throws IllegalArgumentException if a precondition is not met
     * @precondition image != null && !title.isEmpty() && title != null && artistID >= 0&& tagIDs != null && id >= 0 && date != null
     * @postcondition getImage() == image && getTitle == title && getArtistID() == artistID && getTagIDs() == tagIDs && getID == id && getDate() == date
     */
    public Artwork(Image image, String title, int artistID, List<Integer> tagIDs, int id, String date) {
        if (image == null) {
            throw new IllegalArgumentException();
        }
        if (title == null) {
            throw new IllegalArgumentException();
        }
        if (title.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (artistID < 0) {
            throw new IllegalArgumentException();
        }
        if (tagIDs == null) {
            throw new IllegalArgumentException();
        }
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
	if (date == null) {
		throw new IllegalArgumentException();
	}
        this.image = image;
        this.title = title;
        this.artistID = artistID;
        this.tagIDs = tagIDs;
        this.id = id;
	this.date = date;
    }

    /**
     * Gets the image of the Artwork
     *
     * @precondition none
     * @postcondition none
     *
     * @return the image of the artwork
     */
    public Image getImage() {
       	return this.image;
    }

    /**
     * Gets the title of the artwork
     *
     * @precondition none
     * @postcondition none
     *
     * @return the title of the artwork
     */
    public String getTitle() {
	    return this.title;
    }

    /**
     * Gets the artist id of the artwork
     *
     * @precondition none
     * @postcondition none
     *
     * @return the artist id of the artwork
     */
    public int getArtistID() {
       	return this.artistID;
    }

    /**
     * Gets the tag ids of the artwork
     *
     * @precondition none
     * @postcondition none
     *
     * @return the tag ids of the artwork
     */
    public List<Integer> getTagIDs() {
	    return this.tagIDs;
    }

    /**
     * Gets the id of the artwork
     *
     * @precondition none
     * @postcondition none
     *
     * @return the id of the artwork
     */
    public int getID() {
	    return this.id;
    }

    /**
     * Gets the date of the artwork
     *
     * @precondition none
     * @postcondition none
     *
     * @return the date of the artwork
     */
    public String getDate() {
	    return this.date;
    }

    /**
     * Sets the tags of the artwork
     *
     * @precondition newTagIDs != null
     * @postcondition getTagIDs() == newTagIDs
     *
     */
    public void setTags(List<Integer> newTagIDs) {
	    if(newTagIDs == null) {
		    throw new IllegalArgumentException();
	    }
	    this.tagIDs = newTagIDs;
    }

    /**
     * Sets the title of the artwork
     *
     * @precondition newTitle != null && !newTitle.isEmpty()
     * @postcondition getTitle() == newTitle
     *
     */
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

