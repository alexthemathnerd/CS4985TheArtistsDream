package edu.westga.devops.theartistsdreamserver.model;

import java.util.List;
import java.time.LocalDate;

/**
 * Model Class Artwork
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class Artwork implements Comparable<Artwork> {

	private final byte[] imageData;
	private String title;
	private final int artistID;
	private List<Integer> tagIDs;
	private final int id;
	private final String date;

	/**
	 * Creates a new Artwork
	 *
	 * @param imageData 	the image bytes of the artwork
	 * @param title 	the title of the artwork
	 * @param artistID	the id of the artist who created the artwork
	 * @param tagIDs	the tag ids of the artwork
	 * @param id		the id of the artwork
	 * @param date		the date of the artwork
	 *
	 * @throws IllegalArgumentException if a precondition is not met
	 *
	 * @precondition imageBytes != null && !title.isEmpty() && title != null && artistID > 0 && tagIDs != null && id > 0 && date != null
	 * @postcondition getImageBytes() == imageBytes && getTitle() == title && getArtistID() == artistID && getTagIDs() == tagIDs && getID() == id && getDate() == date
	 */
	public Artwork(byte[] imageData, String title, int artistID, List<Integer> tagIDs, int id, String date) {
		if (imageData == null) {
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
		if (id < 0) {
			throw new IllegalArgumentException();
		}
		if (date == null) {
			throw new IllegalArgumentException();
		}

		this.imageData = imageData;
		this.title = title;
		this.artistID = artistID;
		this.tagIDs = tagIDs;
		this.id = id;
		this.date = date;
	}


	    /**
     * Gets the image bytes of the Artwork
     *
     * @precondition none
     * @postcondition none
     *
     * @return the image bytes of the artwork
     */
    public byte[] getImageData() {
       	return this.imageData;
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
     * @param data the set of data with the new tags
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to set the tags of the artwork
     *
     */
    public Request setTags(Object[] data) {
	    List<Integer> newTagIDs;
	    try {
		    newTagIDs = (List<Integer>) data[0];
	    } catch (ClassCastException e) {
		    return new Request("Invalid Format");
	    }
	    this.tagIDs = newTagIDs;
	    return new Request(this.tagIDs);
    }

    /**
     * Sets the title of the artwork
     *
     * @param data the data that has the new title
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to set the title of the artwork
     *
     */
    public Request setTitle(Object[] data) {
	    String newTitle;
	    try {
		    newTitle = (String) data[0];
	    } catch (ClassCastException e) {
		    return new Request("Invalid Format");
	    }

	    this.title = newTitle;
	    return new Request(null, this.title);
    }

	@Override
	public int compareTo(Artwork otherArtwork) {
		return -1 * LocalDate.parse(this.date).compareTo(LocalDate.parse(otherArtwork.getDate()));
	}
}
