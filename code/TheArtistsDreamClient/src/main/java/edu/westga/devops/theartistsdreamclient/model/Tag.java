package edu.westga.devops.theartistsdreamclient.model;

import java.util.Objects;
import edu.westga.devops.theartistsdreamclient.utils.UI;

/**
 * A data class for a Tag
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class Tag implements Comparable<Tag> {

    private final int id;
    private final String name;
    private int useCount;

    /**
     * Creates a new Tag
     *
     * @param id   the id of the tag
     * @param name the name of the tag
     * @throws IllegalArgumentException if a precondition is not met
     * @precondition id >= 0 && !name.isEmpty() && name != null
     * @postcondition getId() == id && getName() == name
     */
    public Tag(int id, String name) {
        if (id < 0) {
            throw new IllegalArgumentException(UI.ErrorMessages.NEGATIVE_ID);
        }
        if (name == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.TAG_NAME_NULL);
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.TAG_NAME_EMPTY);
        }
        this.id = id;
        this.name = name;
        this.useCount = 1;
    }

    /**
     * Creates a new Tag
     *
     * @param id       the id of the tag
     * @param name     the name of the tag
     * @param useCount the use count of the tag
     * @throws IllegalArgumentException if a precondition is not met
     * @precondition id >= 0 && !name.isEmpty() && name != null && useCount >= 0
     * @postcondition getId() == id && getName() == name && getUseCount() == useCount
     */
    public Tag(int id, String name, int useCount) {
        if (id < 0) {
            throw new IllegalArgumentException(UI.ErrorMessages.NEGATIVE_ID);
        }
        if (name == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.TAG_NAME_NULL);
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.TAG_NAME_EMPTY);
        }
        if (useCount < 0) {
            throw new IllegalArgumentException(UI.ErrorMessages.NEGATIVE_USE_COUNT);
        }
        this.id = id;
        this.name = name;
        this.useCount = useCount;
    }

    /**
     * Gets the id of the tag.
     *
     * @return the id of the tag
     * @precondition none
     * @postcondition none
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Gets the name of the tag
     *
     * @return the name of the tag
     * @precondition none
     * @postcondtion none
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Gets the use count of the tag
     *
     * @return the use count of the tag
     * @precondition none
     * @postcondition none
     */
    public final int getUseCount() {
        return this.useCount;
    }

    /**
     * Increments the use count of the tag
     *
     * @precondition none
     * @postcondition getUseCount() == getUseCount() + 1 @ pre
     */
    public void incrementUseCount() {
        this.useCount++;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tag) {
            return this.getId() == ((Tag) obj).getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.useCount);
    }

    @Override
    public int compareTo(Tag otherTag) {
        if (otherTag == null) {
            throw new NullPointerException(UI.ErrorMessages.TAG_NULL);
        }
        int result = otherTag.getUseCount() - this.useCount;

        if (result == 0) {
            return this.getName().compareTo(otherTag.getName());
        }
        return result;
    }

}
