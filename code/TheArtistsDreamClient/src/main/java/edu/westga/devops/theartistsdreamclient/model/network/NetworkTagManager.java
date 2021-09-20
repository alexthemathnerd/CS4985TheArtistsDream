package edu.westga.devops.theartistsdreamclient.model.network;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.TagManager;
import edu.westga.devops.theartistsdreamclient.utils.UI;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Alexander Schmidt
 */
public class NetworkTagManager extends TagManager {

    private Communicator communicator;

    public NetworkTagManager() {
        this.communicator = new Communicator("tcp://localhost:4444");
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
        Type type = new TypeToken<Integer>() {
        }.getType();
        Response<Integer> response = this.communicator.request(new Request(UI.ServerCodes.ADD_TAG, new Object[]{name}));
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return -1;
        }
        return response.getData();
    }

    @Override
    public Iterator<Tag> iterator() {
        return null;
    }

}