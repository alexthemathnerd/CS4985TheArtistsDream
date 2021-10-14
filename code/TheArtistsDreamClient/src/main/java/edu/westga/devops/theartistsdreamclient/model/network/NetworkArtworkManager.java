package edu.westga.devops.theartistsdreamclient.model.network;

import edu.westga.devops.theartistsdreamclient.utils.UI;
import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.Tag;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import java.util.List;
import java.util.ArrayList;

/**
 * Network Implementation of Collection Class ArtworkManager
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class NetworkArtworkManager extends ArtworkManager {


    private Communicator communicator;

    /**
     * Creates a new NetworkArtworkManager
     *
     * @precondition none
     * @postcondition none
     */
    public NetworkArtworkManager() {
        this.communicator = new Communicator("tcp://localhost:4444");
    }

    @Override
    public List<Artwork> getFirstFiftyArtworks() {
        Type type = new TypeToken<Response<ArrayList<Artwork>>>() {
        }.getType();
        Response<ArrayList<Artwork>> response = this.communicator.request(new Request(UI.ServerCodes.GET_FIRST_FIFTY_ARTWORKS, new Object[]{}), type);

        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<Artwork>();
        }
        return response.getData();
    }

    @Override
    public List<Artwork> getFirstFiftyArtworks(int userId) {
        Type type = new TypeToken<Response<ArrayList<Artwork>>>() {
        }.getType();
        Response<ArrayList<Artwork>> response = this.communicator.request(new Request(UI.ServerCodes.GET_FIRST_FIFTY_ARTWORKS, new Object[]{userId}), type);
        System.out.println(userId);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<Artwork>();
        }
        return response.getData();
    }

    @Override
    public List<Artwork> getNextTenArtworks(int startingIndex) {

        Type type = new TypeToken<Response<ArrayList<Artwork>>>() {
        }.getType();
        Response response = this.communicator.request(new Request(UI.ServerCodes.GET_NEXT_TEN_ARTWORKS, new Object[]{startingIndex}));
        System.out.println(response.getData().getClass());
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<Artwork>();
        }

        return (List<Artwork>) response.getData();
    }

    @Override
    public List<Artwork> getNextTenArtworks(int startingIndex, int userId) {
        Type type = new TypeToken<Response<ArrayList<Artwork>>>() {
        }.getType();

        Response<ArrayList<Artwork>> response = this.communicator.request(new Request(UI.ServerCodes.GET_NEXT_TEN_ARTWORKS, new Object[]{startingIndex, userId}));
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<Artwork>();
        }


        return response.getData();
    }

    @Override
    public Artwork getArtwork(int id) {
        Type type = new TypeToken<Artwork>() {
        }.getType();

        Response<Artwork> response = this.communicator.request(new Request(UI.ServerCodes.GET_ARTWORK, new Object[]{id}), type);

        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return null;
        }

        return response.getData();
    }

    @Override
    public boolean addArtwork(byte[] imageData, String title, int artistID, List<Integer> tagIDs, String date) {

        Type type = new TypeToken<Response<Boolean>>() {
        }.getType();

        Response<Boolean> response = this.communicator.request(new Request(UI.ServerCodes.ADD_ARTWORK, new Object[]{imageData, title, artistID, tagIDs, date}), type);

        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return false;
        }

        return response.getData();
    }

    @Override
    public boolean removeArtwork(int id) {
        Type type = new TypeToken<Response<Boolean>>() {
        }.getType();
        Response<Boolean> response = this.communicator.request(new Request(UI.ServerCodes.REMOVE_ARTWORK, new Object[]{id}), type);

        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return false;
        }

        return response.getData();
    }

    @Override
    public boolean editArtwork(int id, String newTitle, List<Integer> newTagIDs) {
        Type type = new TypeToken<Response<Boolean>>() {
        }.getType();
        Response<Boolean> response = this.communicator.request(new Request(UI.ServerCodes.EDIT_ARTWORK, new Object[]{id, newTitle, newTagIDs}), type);

        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return false;
        }
        return response.getData();
    }

    @Override
    public List<Artwork> getFollowingArtworks(int userId) {
        return null;

    }

    @Override
    public List<Artwork> getArtworksOfArtist(int userId) {
        Type type = new TypeToken<Response<ArrayList<Artwork>>>() {
        }.getType();
        return new ArrayList<Artwork>();
    }

    @Override
    public List<Artwork> getArtworksOfTags(List<Tag> tags) {
        Type type = new TypeToken<Response<ArrayList<Artwork>>>() {
        }.getType();
        Response<ArrayList<Artwork>> response = this.communicator.request(new Request(UI.ServerCodes.GET_ARTWORKS_OF_TAGS, new Object[]{tags}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<>();
        }
        return response.getData();
    }

    @Override 
    public List<Artwork> searchForArtworks(String searchTerm) {
        Type type = new TypeToken<Response<ArrayList<Artwork>>>() {
        }.getType();
        Response<ArrayList<Artwork>> response = this.communicator.request(new Request(UI.ServerCodes.SEARCH_ARTWORKS, new Object[]{searchTerm}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<>();
        }
        return response.getData();
    }

    @Override 
    public Artwork retrieveSearchedArtwork(String title) {
        Type type = new TypeToken<Response<Artwork>>() {
        }.getType();
        Response<Artwork> response = this.communicator.request(new Request(UI.ServerCodes.RETRIEVE_ARTWORK, new Object[]{title}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return null;
        }
        return response.getData();
    }

    @Override
    public List<Artwork> getFirstFiftyArtworks(boolean isFollowing) {
        Type type = new TypeToken<Response<ArrayList<Artwork>>>() { }.getType();
        Response<ArrayList<Artwork>> response = this.communicator.request(new Request(UI.ServerCodes.GET_FIRST_FIFTY_ARTWORKS, new Object[]{isFollowing}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<>();
        }
        return response.getData();
    }

}
