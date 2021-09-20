package edu.westga.devops.theartistsdreamclient.viewmodel;

import javafx.collections.*;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import edu.westga.devops.theartistsdreamclient.model.*;
import edu.westga.devops.theartistsdreamclient.model.*;
import edu.westga.devops.theartistsdreamclient.model.network.*;

/**
 * The viewModel for the Header class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class HeaderViewModel {

    /**
     * Searches for the users with usernames containing the searchterm
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param searchTerm the term to search by
     * 
     * @return a list of usernames containing the search term
     */
    public ObservableList<String> searchForUsers(String searchTerm) {
        ArrayList<String> usernames = new ArrayList<String>();
        for (User user: UserManager.getUserManager().searchForUsers(searchTerm)) {
            usernames.add("@" + user.getUsername());
        }
        ObservableList<String> searchedUsers = FXCollections.observableList(usernames);
        return searchedUsers;
    }

     /**
     * Searches for the artworks with titles containing the searchterm
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param searchTerm the term to search by
     * 
     * @return a list of titles containing the search term
     */
    public ObservableList<String> searchForArtworks(String searchTerm) {
        ArrayList<String> titles = new ArrayList<String>();
        for (Artwork artwork: ArtworkManager.getArtworkManager().searchForArtworks(searchTerm)) {
            titles.add(artwork.getTitle());
        }
        ObservableList<String> searchedArtwork = FXCollections.observableList(titles);
        return searchedArtwork;
    }

     /**
     * Gets the user with username matching the username
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param username the username of the user to find
     * 
     * @return the user
     */
    public User getUser(String username) {
        return UserManager.getUserManager().retrieveSearchedUser(username);
    }

    /**
     * Gets the artwork with title matching the title
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param title the tile of the artwork to find
     * 
     * @return the artwork
     */
    public Artwork getArtwork(String title) {
        return ArtworkManager.getArtworkManager().retrieveSearchedArtwork(title);
    }
}


