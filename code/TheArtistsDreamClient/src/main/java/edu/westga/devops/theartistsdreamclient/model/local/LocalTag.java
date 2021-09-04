package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.Tag;

public class LocalTag extends Tag {

    private final String name;
    private int useCount;

    public LocalTag(String name) {
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
        return otherTag.getUseCount() - this.useCount;
    }
}
