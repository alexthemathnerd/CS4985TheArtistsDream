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

    /**
     * Gets the image of the Artwork
     *
     * @return the image of the artwork
     * @precondition none
     * @postcondition none
     */
    public abstract Image getImage();

    /**
     * Gets the title of the artwork
     *
     * @return the title of the artwork
     * @precondition none
     * @postcondition none
     */
    public abstract String getTitle();

    /**
     * Gets the artist of the artwork's username
     *
     * @return the artist of the artwork's username
     * @precondition none
     * @postcondition none
     */
    public abstract int getArtistID();

    /**
     * Gets the tags of the artwork
     *
     * @return the tags of the artwork
     * @precondition none
     * @postcondition none
     */
    public abstract List<Integer> getTagIDs();

    /**
     * Gets the id of the artwork
     *
     * @return the id of the artwork
     * @precondition none
     * @postcondition none
     */
    public abstract int getID();

    /**
     * Changes the title of the artwork
     * @param newTitle the new title of the artwork
     *
     * @precondition newTitle != null && !newTitle.isEmpty()
     * @postcondition getTitle() == newTitle
     */
    public abstract void setTitle(String newTitle);

    /**
     * Changes the tags of the artwork
     *
     * @param newTagIDs the ids of the new tags of the artwork
     *
     * @precondition newTags != null
     * @postcondition getTagIDs() == newTagIDs
     */
    public abstract void setTags(List<Integer> newTagIDs);
}
