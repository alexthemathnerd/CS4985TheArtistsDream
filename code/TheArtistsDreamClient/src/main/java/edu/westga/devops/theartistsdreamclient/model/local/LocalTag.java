package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.Tag;

/**
 * A local implementation of the {@link Tag} class
 *
 * @author Alexander Schmidt
 * @version Fall2021
 */
public class LocalTag extends Tag {

    private int id;
    private String name;
    private int useCount;

    /**
     * Creates a Local tag with a given name
     *
     * @precondition id >= 0 &&  name != null
     * @postcondition getId() == id && getName().equals(name.toLowerCase()) && getUseCount() == 1
     *
     * @param id the id of the tag
     * @param name the name of the tag
     */
    public LocalTag(int id, String name) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = name.toLowerCase();
        this.useCount = 1;
    }

    @Override
    public int getId() {
        return this.id;
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