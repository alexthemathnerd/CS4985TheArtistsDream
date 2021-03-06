package edu.westga.devops.theartistsdreamclient.model;

import java.util.List;

/**
 * An abstract class defining how to manage a list of {@link Tag} objects. It is also responsible to store a singleton
 * TagManager
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 * @see Tag
 */
public abstract class TagManager {

    private static TagManager tagManager = null;

    /**
     * Gets the singleton of the tag manager
     *
     * @return the singleton of the tag manager
     * @precondition none
     * @postcondition none
     */
    public static TagManager getTagManager() {
        return TagManager.tagManager;
    }

    /**
     * Sets the tagManager singleton
     *
     * @param tagManager the new tag manager
     * @preconditon none
     * @postcondition TagManager.getTagManager().equals(tagManager)
     */
    public static void setTagManager(TagManager tagManager) {
        TagManager.tagManager = tagManager;
    }

    /**
     * Gets the top tags that contains the given content with the size given by the amount.
     *
     * @param content the searched string
     * @param amount  the amount of string to be returned
     * @return a list of top tag containing the given content with a size of the given amount
     * @precondition amount >= 0 && content != null
     * @postcondition none
     */
    public abstract List<Tag> getTopTags(int amount, String content);

    /**
     * Adds a tag to the tag manager and returns it id.
     *
     * @param name the name of the tag
     * @return the id of the added tag
     * @precondition name != null && !name.isEmpty()
     * @postcondition none
     */
    public abstract int addTag(String name);


}
