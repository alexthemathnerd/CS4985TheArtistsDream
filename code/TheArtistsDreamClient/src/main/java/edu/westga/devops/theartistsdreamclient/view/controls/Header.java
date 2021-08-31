package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.view.popups.FilterPopup;
import edu.westga.devops.theartistsdreamclient.view.popups.PopupLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Controller for the Custom Control for the Header of the application
 *
 * @author Alexander Schmidt
 */
public class Header extends HBox {

    private static final String HEADER_FXML = "Header.fxml";
    private static final String FILTER_POPUP_FXML = "FilterPopup.fxml";

    @FXML
    private TextField searchTextField;

    /**
     * Initializes the FXML for the Header control
     */
    public Header() {
        FXMLLoader loader = new FXMLLoader(Header.class.getResource(HEADER_FXML));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initialize() {
        // TODO: Setup bindings
    }

    @FXML
    public void handleSearch(ActionEvent event) {

    }

    @FXML
    public void handleFilter(ActionEvent event) {
        try {
            Stage popup = PopupLoader.loadPopup(FilterPopup.class.getResource(FILTER_POPUP_FXML), new FilterPopup());
            popup.show();
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }

    @FXML
    public void handleLogout(ActionEvent event) {

    }

    @FXML
    public void handleMessages(ActionEvent event) {

    }

    @FXML
    public void handleViewProfile(ActionEvent event) {

    }

    @FXML
    public void handleNavDropdown(ActionEvent event) {
        //TODO make dropdown
    }

}
