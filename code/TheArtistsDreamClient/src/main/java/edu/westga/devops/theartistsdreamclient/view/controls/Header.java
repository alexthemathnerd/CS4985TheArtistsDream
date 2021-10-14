package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.view.popups.ArtworkPopup;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.view.PortfolioPage;
import edu.westga.devops.theartistsdreamclient.view.RecommendedPage;
import edu.westga.devops.theartistsdreamclient.view.FollowingPage;
import edu.westga.devops.theartistsdreamclient.view.WindowLoader;
import edu.westga.devops.theartistsdreamclient.view.popups.FilterPopup;
import edu.westga.devops.theartistsdreamclient.view.popups.PopupLoader;
import edu.westga.devops.theartistsdreamclient.viewmodel.HeaderViewModel;
import edu.westga.devops.theartistsdreamclient.utils.UI;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;

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
    private static final String ARTWORK_POPUP_FXML = "ArtworkPopup.fxml";

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

    @FXML
    private Button profileButton;

    private ListProperty<Tag> tagsToFilterListProperty;

    private HeaderViewModel viewModel;

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
        this.viewModel = new HeaderViewModel();
    }

    @FXML
    private void initialize() {
        ImageView graphic = new ImageView(new Image(new ByteArrayInputStream(User.getUser().getProfilePic())));
        graphic.setFitHeight(40);
        graphic.setFitWidth(40);
        graphic.setClip(new Circle(20, 20, 20));
        this.profileButton.setGraphic(graphic);
        this.profileButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        this.profileButton.setPadding(new Insets(0));
        this.setupChangeListeners();
    }

    private void setupChangeListeners() {
        this.searchComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            Platform.runLater(new Runnable() {
                @Override public void run() {
                    if (newValue != null) {
                        Header.this.searchComboBox.getEditor().setText(newValue.toString());
                    }
                }
            });
        });
        this.searchComboBox.getEditor().textProperty().addListener((obs, oldText, newText) -> {
            Platform.runLater(new Runnable() {
                @Override 
                public void run() {
                    if (newText != null && !newText.isEmpty()) {
                        if (newText.charAt(0) == '@') {
                            Header.this.searchComboBox.getItems().clear();
                            String searchTerm = newText.substring(1);
                            for (String username : Header.this.viewModel.searchForUsers(searchTerm)) {
                                Header.this.searchComboBox.getItems().add(username);
                            }
                        } else {
                            Header.this.searchComboBox.getItems().clear();
                            for (String title : Header.this.viewModel.searchForArtworks(newText)) {
                                Header.this.searchComboBox.getItems().add(title);
                            }
                        }
                    }
                }
            });
        });
    }

    @FXML
    void handleSearch(ActionEvent event) {
        if (((String) this.searchComboBox.getValue()).charAt(0) == '@') {
            String searchTerm = (String) this.searchComboBox.getValue();
            searchTerm = searchTerm.substring(1);
            User searchedUser = this.viewModel.getUser(searchTerm);
            if (searchedUser != null) {
                try {
                    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    WindowLoader.changeScene(currentStage, "PortfolioPage.fxml", new PortfolioPage(searchedUser), "The Artist's Dream", true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR, UI.ErrorMessages.USER_NOT_FOUND);
                alert.show();
            }
        } else {
            String searchTerm = (String) this.searchComboBox.getValue();
            Artwork artwork = this.viewModel.getArtwork(searchTerm);
            if (artwork != null) {
                try {
                    Node mainFrame = ((Node) event.getSource()).getParent().getParent();
                    Stage popup = PopupLoader.loadPopup("Artwork", ArtworkPopup.class.getResource(ARTWORK_POPUP_FXML), new ArtworkPopup(artwork, false), (Parent) mainFrame);
                    popup.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR, UI.ErrorMessages.ARTWORK_NOT_FOUND);
                alert.show();
            }
        }

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
        User.setUser(null);
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
            Stage stage = new Stage();
            stage.show();
            WindowLoader.changeScene(stage, "../" + TheArtistsDreamApplication.LOGIN_FXML, null, "The Artist's Dream", false);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleMessages(ActionEvent event) {

    }

    @FXML
    void handleViewProfile(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            WindowLoader.changeScene(currentStage, "PortfolioPage.fxml", new PortfolioPage(User.getUser()), "The Artist's Dream", false);
            currentStage.setMaximized(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleRecommended(ActionEvent event) {
        try {
            Stage currentStage = (Stage) this.navMenuButton.getScene().getWindow();
            WindowLoader.changeScene(currentStage, RECOMMENDED_PAGE_FXML, new RecommendedPage(), "The Artist's Dream", false);
            currentStage.setMaximized(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleFollowing(ActionEvent event) {
        try {
            Stage currentStage = (Stage) this.navMenuButton.getScene().getWindow();
            WindowLoader.changeScene(currentStage, FOLLOWING_PAGE_FXML, new FollowingPage(), "The Artist's Dream", false);
            currentStage.setMaximized(true);
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
