package edu.westga.devops.theartistsdreamclient.view;

import edu.westga.devops.theartistsdreamclient.view.controls.ArtworksPane;
import edu.westga.devops.theartistsdreamclient.view.controls.Header;
import javafx.fxml.FXML;

/**
 * Controller for the Recommended Page
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class RecommendedPage {

    @FXML
    private Header header;

    @FXML
    private ArtworksPane artworksPane;

    public RecommendedPage() {
    }

    @FXML
    private void initialize() {
        this.artworksPane.setUserId(-1);
	    this.artworksPane.setOnProfile(false);
        this.artworksPane.initArts();
        this.artworksPane.tagsToFilterListProperty().bindBidirectional(this.header.tagsToFilterListProperty());
    }



}
