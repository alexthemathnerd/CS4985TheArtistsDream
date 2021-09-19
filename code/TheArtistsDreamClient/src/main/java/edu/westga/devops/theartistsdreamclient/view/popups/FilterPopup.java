package edu.westga.devops.theartistsdreamclient.view.popups;

import edu.westga.devops.theartistsdreamclient.view.controls.TagsPane;
import edu.westga.devops.theartistsdreamclient.viewmodel.FilterPopupViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Handle the functionality of the FilterPopup
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class FilterPopup {

    @FXML
    private TextField searchTagsTextField;

    @FXML
    private TagsPane tagsPane;

    private final FilterPopupViewModel viewModel;

    /**
     * Creates the FilterPopup
     *
     * @precondition none
     * @postcondition none
     */
    public FilterPopup() {
        this.viewModel = new FilterPopupViewModel();
    }

    @FXML
    void initialize() {
        this.searchTagsTextField.textProperty().bindBidirectional(this.viewModel.searchStringProperty());
        this.tagsPane.tagsListProperty().bindBidirectional(this.viewModel.searchTagsListProperty());
    }

    @FXML
    void handleSearch(ActionEvent event) {
        this.viewModel.searchTags(5);
    }

    @FXML
    void handleFilter(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setUserData(this.tagsPane.getAddedButtons());
        currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
        currentStage.close();
    }

    @FXML
    void handleCancel(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
        currentStage.close();
    }
}
