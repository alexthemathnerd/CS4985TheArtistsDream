package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.view.PortfolioPage;
import edu.westga.devops.theartistsdreamclient.view.RecommendedPage;
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
import javafx.scene.control.ComboBox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

/**
 * The Controller for the Custom Control for the Header of the application
 *
 * @author Alexander Schmidt
 * @version Fall2021
 */
public class Header extends HBox {

    private static final String HEADER_FXML = "Header.fxml";
    private static final String FILTER_POPUP_FXML = "FilterPopup.fxml";

    @FXML
    private ComboBox searchComboBox;

    @FXML
    private MenuButton navMenuButton;

    @FXML
    private MenuItem recommendedMenuItem;

    @FXML
    private MenuItem followingMenuItem;

    @FXML
    private MenuItem inSearchOfMenuItem;

    private ListProperty<Tag> tagsToFilterListProperty;

    private HeaderViewModel viewModel;



    /**
     * Initializes the FXML for the Header control
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
        this.viewModel = new HeaderViewModel();
    }

    @FXML
    void handleSearch(ActionEvent event) {

    }

    @FXML 
    public void initialize() {
        this.searchComboBox.setEditable(true);
        this.searchComboBox.getEditor().textProperty().addListener((obs, oldText, newText) -> {
            this.searchComboBOx.setItems(this.viewModel.searchForUsers(newText));
        });
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

    }

    @FXML
    void handleFollowing(ActionEvent event) {

    }

    @FXML
    void handleInSearchOf(ActionEvent event) {

    }

    public ListProperty<Tag> tagsToFilterListProperty() {
        return this.tagsToFilterListProperty;
    }

}
