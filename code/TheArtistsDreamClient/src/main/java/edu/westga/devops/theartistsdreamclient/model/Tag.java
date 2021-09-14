package edu.westga.devops.theartistsdreamclient.model;

/**
 * An abstract class defining a data class for a Tag
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class Tag {

    private int id;
    private String name;
    private int useCount;

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
        this.useCount = 1;
    }

    public Tag(int id, String name, int useCount) {
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

    @Override
    public boolean equals(Object obj) {
        Tag tag = (Tag) obj;
        return this.getId() == tag.getId();
    }

}
