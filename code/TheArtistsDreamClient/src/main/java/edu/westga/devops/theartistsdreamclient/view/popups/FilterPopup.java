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
 */
public class FilterPopup {

    @FXML
    private TextField searchTagsTextField;

    @FXML
    private TagsPane tagsPane;

    private final FilterPopupViewModel viewModel;

    /**
     * Creates the FilterPopup
     */
    public FilterPopup() {
        this.viewModel = new FilterPopupViewModel();
    }

    @FXML
    public void initialize() {
        this.searchTagsTextField.textProperty().bindBidirectional(this.viewModel.searchStringProperty());
        this.tagsPane.tagsSetProperty().bindBidirectional(this.viewModel.searchTagsSetProperty());
        this.searchTagsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            this.viewModel.searchTags(5);
        });
    }

    @FXML
    public void handleFilter(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage ownerStage = (Stage) currentStage.getOwner();
        currentStage.setUserData(this.tagsPane.addedTagsSetProperty());
        currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
        currentStage.close();
    }

    @FXML
    public void handleCancel(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
        currentStage.close();
    }
}
