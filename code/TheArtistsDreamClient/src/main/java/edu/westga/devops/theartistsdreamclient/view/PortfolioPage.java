package edu.westga.devops.theartistsdreamclient.view;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.view.controls.ArtworksPane;
import edu.westga.devops.theartistsdreamclient.view.controls.Header;
import edu.westga.devops.theartistsdreamclient.view.controls.PortfolioPane;
import javafx.fxml.FXML;

public class PortfolioPage {

    @FXML
    private Header header;

    @FXML
    private PortfolioPane portfolioPane;

    @FXML
    private ArtworksPane artworksPane;

    private User user;

    public PortfolioPage(User user) {
        this.user = user;
    }

    @FXML
    private void initialize() {
        this.artworksPane.setUserId(this.user.getUserId());
        this.portfolioPane.setUser(this.user);
        this.artworksPane.initArts();
        this.artworksPane.tagsToFilterListProperty().bindBidirectional(this.header.tagsToFilterListProperty());
    }

}
