package edu.westga.devops.theartistsdreamclient.view;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.view.controls.ArtworksPane;
import edu.westga.devops.theartistsdreamclient.view.controls.Header;
import edu.westga.devops.theartistsdreamclient.view.controls.PortfolioPane;
import javafx.fxml.FXML;

/**
 * Controller for the PortfolioPage
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class PortfolioPage {

    private final User user;
    @FXML
    private Header header;
    @FXML
    private PortfolioPane portfolioPane;
    @FXML
    private ArtworksPane artworksPane;

    /**
     * Creates a new PortfolioPage of the specified user
     *
     * @param user the user
     * @precondition none
     * @postcondition none
     */
    public PortfolioPage(User user) {
        this.user = user;
    }

    @FXML
    private void initialize() {
        this.artworksPane.setUserId(this.user.getUserId());
        this.artworksPane.setOnProfile(true);
        this.artworksPane.setOnFollowingPage(false);
        this.portfolioPane.setUser(this.user);
        this.artworksPane.initArts();
        this.artworksPane.tagsToFilterListProperty().bindBidirectional(this.header.tagsToFilterListProperty());
    }

}
