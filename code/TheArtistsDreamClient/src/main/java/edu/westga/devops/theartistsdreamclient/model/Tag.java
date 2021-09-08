package edu.westga.devops.theartistsdreamclient.model;

/**
 * An abstract class defining a data class for a Tag
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public abstract class Tag implements Comparable<Tag> {

    /**
     * Gets the id of the tag.
     *
     * @return the id of the tag
     * @precondition none
     * @postcondition none
     */
    public abstract int getId();

    /**
     * Gets the name of the tag
     *
     * @return the name of the tag
     * @precondition none
     * @postcondtion none
     */
    public abstract String getName();

    /**
     * Increments the use count of the tag
     *
     * @precondition none
     * @postcondition getUseCount() == getUseCount()@prev + 1
     */
    public abstract void incrementUseCount();

    /**
     * Gets the use count of the tag
     *
     * @return the use count of the tag
     * @precondition none
     * @postcondition none
     */
    public abstract int getUseCount();

    @Override
    public boolean equals(Object obj) {
        Tag tag = (Tag) obj;
        return this.getId() == tag.getId();
    }

}
