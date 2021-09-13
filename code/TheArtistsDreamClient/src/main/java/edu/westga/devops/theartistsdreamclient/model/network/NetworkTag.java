package edu.westga.devops.theartistsdreamclient.model.network;

import edu.westga.devops.theartistsdreamclient.model.Tag;

public class NetworkTag extends Tag {

    private Communicator communicator;

    public NetworkTag(Communicator communicator) {
        if (communicator == null) {
            throw new IllegalArgumentException();
        }
        if (communicator.isClosed()) {
            throw new IllegalArgumentException();
        }
        this.communicator = communicator;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void incrementUseCount() {

    }

    @Override
    public int getUseCount() {
        return 0;
    }

    @Override
    public int compareTo(Tag tag) {
        return 0;
    }
}
