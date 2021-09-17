package edu.westga.devops.theartistsdreamclient.view;

import edu.westga.devops.theartistsdreamclient.view.controls.ArtworksPane;
import edu.westga.devops.theartistsdreamclient.view.controls.Header;
import javafx.fxml.FXML;

public class RecommendedPage {

    @FXML
    private Header header;

    @FXML
    private ArtworksPane artworksPane;

    public RecommendedPage() {
    }

    @FXML
    private void initialize() {
        this.artworksPane.tagsToFilterListProperty().bindBidirectional(this.header.tagsToFilterListProperty());
    }



}
