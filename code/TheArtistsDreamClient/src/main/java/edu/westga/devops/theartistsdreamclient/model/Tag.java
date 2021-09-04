package edu.westga.devops.theartistsdreamclient.model;

public abstract class Tag implements Comparable<Tag> {

    public abstract String getName();
    public abstract void incrementUseCount();
    public abstract int getUseCount();

}
