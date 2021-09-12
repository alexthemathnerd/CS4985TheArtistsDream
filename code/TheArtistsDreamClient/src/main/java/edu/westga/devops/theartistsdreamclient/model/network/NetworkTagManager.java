package edu.westga.devops.theartistsdreamclient.model.network;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.TagManager;

import java.util.Iterator;
import java.util.List;

/**
 * @author Alexander Schmidt
 */
public class NetworkTagManager extends TagManager {

    private transient Communicator communicator;

    public NetworkTagManager() {
        this.communicator = new Communicator("tcp://localhost:4444");
    }

    public NetworkTagManager(Communicator communicator) {

    }

    @Override
    public List<Tag> getTopTags(int amount, String content) {
        return null;
    }

    @Override
    public int addTag(String name) {
        return 0;
    }

    @Override
    public Iterator<Tag> iterator() {
        return null;
    }

}
