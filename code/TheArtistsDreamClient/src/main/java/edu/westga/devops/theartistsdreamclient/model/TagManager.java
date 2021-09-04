package edu.westga.devops.theartistsdreamclient.model;

import java.util.List;

public abstract class TagManager implements Iterable<Tag> {
    public abstract List<Tag> getTopTenTags(String name);
    public abstract void addTag(String name);

}
