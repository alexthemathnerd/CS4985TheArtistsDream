package edu.westga.devops.theartistsdreamclient.model.network;

import com.google.gson.reflect.TypeToken;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.utils.UI;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Network Implementation of TagManager Collection Class
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class NetworkTagManager extends TagManager {

    private final Communicator communicator;

    /**
     * Creates a new NetworkTagManager
     *
     * @precondition none
     * @postcondition none
     */
    public NetworkTagManager() {
        this.communicator = new Communicator("tcp://localhost:4444");
    }

    /**
     * Creates a new NetworkTagManager (Use only for testing)
     *
     * @param communicator the communicator to connect with
     * @precondition none
     * @postcondition none
     */
    public NetworkTagManager(Communicator communicator) {
        this.communicator = communicator;
    }

    @Override
    public List<Tag> getTopTags(int amount, String content) {
        Type type = new TypeToken<Response<ArrayList<Tag>>>() {
        }.getType();
        Response<ArrayList<Tag>> response = this.communicator.request(new Request(UI.ServerCodes.GET_TOP_TAGS, new Object[]{amount, content}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<>();
        }
        return response.getData();
    }

    @Override
    public int addTag(String name) {
        Type type = new TypeToken<Response<Double>>() {
        }.getType();
        Response<Double> response = this.communicator.request(new Request(UI.ServerCodes.ADD_TAG, new Object[]{name}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return -1;
        }
        return (response.getData()).intValue();
    }

}
