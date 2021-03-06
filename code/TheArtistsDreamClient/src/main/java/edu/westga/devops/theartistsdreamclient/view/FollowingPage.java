package edu.westga.devops.theartistsdreamclient.view;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.view.controls.ArtworksPane;
import edu.westga.devops.theartistsdreamclient.view.controls.Header;
import javafx.fxml.FXML;

/**
 * CodeBehind for the FollowingPage
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class FollowingPage {

    @FXML
    private Header header;

    @FXML
    private ArtworksPane artworksPane;

    @FXML
    private void initialize() {
        this.artworksPane.setUserId(User.getUser().getUserId());
        this.artworksPane.setOnFollowingPage(true);
        this.artworksPane.setOnProfile(false);
        this.artworksPane.initArts();
        this.artworksPane.tagsToFilterListProperty().bindBidirectional(this.header.tagsToFilterListProperty());
    }

}

