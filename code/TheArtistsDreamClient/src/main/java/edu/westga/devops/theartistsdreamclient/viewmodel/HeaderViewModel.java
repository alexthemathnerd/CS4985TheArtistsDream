package edu.westga.devops.theartistsdreamclient.viewmodel;

import javafx.collections.*;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import edu.westga.devops.theartistsdreamclient.model.*;
import edu.westga.devops.theartistsdreamclient.model.*;
import edu.westga.devops.theartistsdreamclient.model.network.*;

public class HeaderViewModel {

    public HeaderViewModel() {
    }

    public ObservableList<String> searchForUsers(String searchTerm) {
        ArrayList<String> usernames = new ArrayList<String>();
        for (User user: UserManager.getUserManager().searchForUsers(searchTerm)) {
            usernames.add("@" + user.getUsername());
        }
        ObservableList<String> searchedUsers = FXCollections.observableList(usernames);
        return searchedUsers;
    }

    public ObservableList<String> searchForArtworks(String searchTerm) {
        ArrayList<String> titles = new ArrayList<String>();
        for (Artwork artwork: ArtworkManager.getArtworkManager().searchForArtworks(searchTerm)) {
            titles.add(artwork.getTitle());
        }
        ObservableList<String> searchedArtwork = FXCollections.observableList(titles);
        return searchedArtwork;
    }

    public User getUser(String username) {
        return UserManager.getUserManager().retrieveSearchedUser(username);
    }

    // public Artwork getArtwork(String title) {

    // }
}


