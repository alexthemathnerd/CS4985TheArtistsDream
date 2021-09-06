package edu.westga.devops.theartistsdreamclient.model;

import java.util.List;

import javafx.scene.image.Image;

/**
 * Artwork Abstract Class
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public abstract class Artwork {

    private final Image image;
    private String title;
    private final String artistUsername;
    private List<Tag> tags;
    private final int id;


    /**
     * Creates a new Artwork
     *
     * @param image          the image of the artwork
     * @param title          the title of the artwork
     * @param artistUsername the artist of the artwork's username
     * @param tags           the tags of the artwork
     * @param id             the id of the artwork
     * @throws IllegalArgumentException if a precondition is not met
     * @precondition image != null && !title.isEmpty() && title != null && !artistUsername.isEmpty() && artistUsername != null && tags != null && id > 0
     * @postcondition getImage() == image && getTitle == title && getArtistUsername() == artistUsername && getTags() == tags && getID == id
     */
    public Artwork(Image image, String title, String artistUsername, List<Tag> tags, int id) {
        if (image == null) {
            throw new IllegalArgumentException();
        }
        if (title == null) {
            throw new IllegalArgumentException();
        }
        if (title.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (artistUsername == null) {
            throw new IllegalArgumentException();
        }
        if (artistUsername.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (tags == null) {
            throw new IllegalArgumentException();
        }
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        this.image = image;
        this.title = title;
        this.artistUsername = artistUsername;
        this.tags = tags;
        this.id = id;
    }

    /**
     * Gets the image of the Artwork
     *
     * @return the image of the artwork
     * @precondition none
     * @postcondition none
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Gets the title of the artwork
     *
     * @return the title of the artwork
     * @precondition none
     * @postcondition none
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the artist of the artwork's username
     *
     * @return the artist of the artwork's username
     * @precondition none
     * @postcondition none
     */
    public String getArtistUsername() {
        return this.artistUsername;
    }

    /**
     * Gets the tags of the artwork
     *
     * @return the tags of the artwork
     * @precondition none
     * @postcondition none
     */
    public List<Tag> getTags() {
        return this.tags;
    }

    /**
     * Gets the id of the artwork
     *
     * @return the id of the artwork
     * @precondition none
     * @postcondition none
     */
    public int getID() {
        return this.id;
    }

    /**
     * Changes the title of the artwork
     *
     * @precondition newTitle != null && !newTitle.isEmpty()
     * @postcondition getTitle() == newTitle
     */
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    /**
     * Changes the tags of the artwork
     *
     * @precondition newTags != null
     * @postcondition getTags() == newTags
     */
    public void setTags(List<Tag> newTags) {
        this.tags = newTags;
    }
}
