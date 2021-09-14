package edu.westga.devops.theartistsdreamserver.model;

public class Tag implements Comparable<Tag> {

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
    public Tag(int id, String name) {
//        if (id < 0) {
//            throw new IllegalArgumentException(UI.ErrorMessages.NEGATIVE_ID);
//        }
//        if (name == null) {
//            throw new IllegalArgumentException(UI.ErrorMessages.TAG_NAME_NULL);
//        }
//        if (name.isEmpty()) {
//            throw new IllegalArgumentException(UI.ErrorMessages.TAG_NAME_EMPTY);
//        }
        this.id = id;
        this.name = name.toLowerCase();
        this.useCount = 1;
    }
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void incrementUseCount() {
        this.useCount++;
    }

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
