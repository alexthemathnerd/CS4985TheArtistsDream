package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.Tag;

/**
 * A local implementation of the {@link Tag} class
 *
 * @author Alexander Schmidt
 * @version Fall2021
 */
public class LocalTag extends Tag {

    private final String name;
    private int useCount;

    /**
     * Creates a Local tag with a given name
     *
     * @precondition name != null
     * @postcondition none
     *
     * @param name the name of the tag
     */
    public LocalTag(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name.toLowerCase();
        this.useCount = 1;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void incrementUseCount() {
        this.useCount++;
    }

    @Override
    public int getUseCount() {
        return this.useCount;
    }

    @Override
    public int compareTo(Tag otherTag) {
        if (otherTag == null) {
            throw new NullPointerException();
        }
        int result = otherTag.getUseCount() - this.useCount;

        if (result == 0) {
            return this.getName().compareTo(otherTag.getName());
        }
        return result;
    }
}