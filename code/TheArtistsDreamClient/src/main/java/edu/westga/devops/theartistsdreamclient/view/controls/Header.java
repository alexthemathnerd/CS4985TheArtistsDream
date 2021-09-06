package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.view.popups.FilterPopup;
import edu.westga.devops.theartistsdreamclient.view.popups.PopupLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import java.io.IOException;

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
    private TextField searchTextField;

    @FXML
    private MenuButton navMenuButton;

    @FXML
    private MenuItem recommendedMenuItem;

    @FXML
    private MenuItem followingMenuItem;

    @FXML
    private MenuItem inSearchOfMenuItem;

    /**
     * Initializes the FXML for the Header control
     */
    public Header() {
        FXMLLoader loader = new FXMLLoader(Header.class.getResource(HEADER_FXML));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            this.toFront();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
        // TODO: Setup bindings
    }

    @FXML
    void handleSearch(ActionEvent event) {

    }

    @FXML
    void handleFilter(ActionEvent event) {
        try {
            Stage popup = PopupLoader.loadPopup("Filter", FilterPopup.class.getResource(FILTER_POPUP_FXML), new FilterPopup(), this.getScene().getWindow());
            popup.setOnCloseRequest((event2) -> {
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            });
            popup.show();
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }

    @FXML
    void handleLogout(ActionEvent event) {

    }

    @FXML
    void handleMessages(ActionEvent event) {

    }

    @FXML
    void handleViewProfile(ActionEvent event) {

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

}
