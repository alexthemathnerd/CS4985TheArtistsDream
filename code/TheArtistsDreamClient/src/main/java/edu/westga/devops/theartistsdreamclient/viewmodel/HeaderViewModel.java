package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

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
     * @param searchTerm the term to search by
     * @return a list of usernames containing the search term
     * @precondition none
     * @postcondition none
     */
    public ObservableList<String> searchForUsers(String searchTerm) {
        ArrayList<String> usernames = new ArrayList<String>();
        for (User user : UserManager.getUserManager().searchForUsers(searchTerm)) {
            usernames.add("@" + user.getUsername());
        }
        return FXCollections.observableList(usernames);
    }

    /**
     * Searches for the artworks with titles containing the searchterm
     *
     * @param searchTerm the term to search by
     * @return a list of titles containing the search term
     * @precondition none
     * @postcondition none
     */
    public ObservableList<String> searchForArtworks(String searchTerm) {
        ArrayList<String> titles = new ArrayList<String>();
        for (Artwork artwork : ArtworkManager.getArtworkManager().searchForArtworks(searchTerm)) {
            titles.add(artwork.getTitle());
        }
        return FXCollections.observableList(titles);
    }

    /**
     * Gets the user with username matching the username
     *
     * @param username the username of the user to find
     * @return the user
     * @precondition none
     * @postcondition none
     */
    public User getUser(String username) {
        return UserManager.getUserManager().retrieveSearchedUser(username);
    }

    /**
     * Gets the artwork with title matching the title
     *
     * @param title the tile of the artwork to find
     * @return the artwork
     * @precondition none
     * @postcondition none
     */
    public Artwork getArtwork(String title) {
        return ArtworkManager.getArtworkManager().retrieveSearchedArtwork(title);
    }
}


