package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.view.PortfolioPage;
import edu.westga.devops.theartistsdreamclient.view.RecommendedPage;
import edu.westga.devops.theartistsdreamclient.view.FollowingPage;
import edu.westga.devops.theartistsdreamclient.view.WindowLoader;
import edu.westga.devops.theartistsdreamclient.view.popups.FilterPopup;
import edu.westga.devops.theartistsdreamclient.view.popups.PopupLoader;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Controller for the Custom Control for the Header of the application
 *
 * @author Alexander Schmidt
 * @version Fall2021
 */
public class Header extends HBox {

    private static final String HEADER_FXML = "Header.fxml";
    private static final String FILTER_POPUP_FXML = "FilterPopup.fxml";
    private static final String RECOMMENDED_PAGE_FXML = "RecommendedPage.fxml";
    private static final String FOLLOWING_PAGE_FXML = "FollowingPage.fxml";

    @FXML
    private TextField searchTextField;

    @FXML
    private MenuButton navMenuButton;

    @FXML
    private MenuItem recommendedMenuItem;

    @FXML
    private MenuItem followingMenuItem;

    @FXML
    private MenuItem inSearchOfMenuItem;

    private ListProperty<Tag> tagsToFilterListProperty;

    /**
     * Initializes the FXML for the Header control
     *
     * @precondition none
     * @postcondition none
     */
    public Header() {
        FXMLLoader loader = new FXMLLoader(Header.class.getResource(HEADER_FXML));
        loader.setRoot(this);
        loader.setController(this);
        try {
            this.tagsToFilterListProperty = new SimpleListProperty<Tag>(FXCollections.observableArrayList());
            loader.load();
            this.toFront();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleSearch(ActionEvent event) {

    }

    @FXML
    void handleFilter(ActionEvent event) {
        try {
            Node mainFrame = ((Node) event.getSource()).getParent().getParent();
            Stage popup = PopupLoader.loadPopup("Filter", FilterPopup.class.getResource(FILTER_POPUP_FXML), new FilterPopup(), (Parent) mainFrame);
            popup.setOnCloseRequest((event2) -> {
                mainFrame.setEffect(null);
                this.tagsToFilterListProperty.clear();
                this.tagsToFilterListProperty.setAll(this.getTags((List<TagButton>) popup.getUserData()));
            });
            popup.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<Tag> getTags(List<TagButton> buttons) {
        if (buttons == null) {
            return new ArrayList<>();
        }
        List<Tag> tag = new ArrayList<Tag>();
        for (TagButton aButton : buttons) {
            tag.add(aButton.tagProperty().get());
        }
        return tag;
    }

    @FXML
    void handleLogout(ActionEvent event) {

    }

    @FXML
    void handleMessages(ActionEvent event) {

    }

    @FXML
    void handleViewProfile(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            WindowLoader.changeScene(currentStage, "PortfolioPage.fxml", new PortfolioPage(User.getUser()), "The Artist's Dream");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleRecommended(ActionEvent event) {
           try {
                Stage currentStage = (Stage) this.navMenuButton.getScene().getWindow();
                WindowLoader.changeScene(currentStage, RECOMMENDED_PAGE_FXML, new RecommendedPage(), "The Artist's Dream");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    @FXML
    void handleFollowing(ActionEvent event) {
           try {
                Stage currentStage = (Stage) this.navMenuButton.getScene().getWindow();
                WindowLoader.changeScene(currentStage, FOLLOWING_PAGE_FXML, new FollowingPage(), "The Artist's Dream");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    @FXML
    void handleInSearchOf(ActionEvent event) {

    }

    /**
     * Gets the tags to filter list property
     *
     * @precondition none
     * @postcondition none
     *
     * @return the tags to filter list property
     */
    public ListProperty<Tag> tagsToFilterListProperty() {
        return this.tagsToFilterListProperty;
    }

}
