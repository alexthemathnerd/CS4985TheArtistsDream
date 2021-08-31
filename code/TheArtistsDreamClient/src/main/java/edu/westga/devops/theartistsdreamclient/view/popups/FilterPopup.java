package edu.westga.devops.theartistsdreamclient.view.popups;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.view.controls.TagButton;
import edu.westga.devops.theartistsdreamclient.viewmodel.FilterPopupViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.List;

/**
 * Handle the functionality of the FilterPopup
 *
 * @author Alexander Schmidt
 */
public class FilterPopup {

    @FXML
    private TextField searchTagsTextField;

    @FXML
    private FlowPane tagsFlowPane;

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
        this.searchTagsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            this.addFoundTags(this.viewModel.getFoundTags(newValue));
        });
    }

    private void addFoundTags(List<Tag> tags) {
        for (Tag aTag: tags) {
            this.tagsFlowPane.getChildren().add(new TagButton(aTag, true));
        }
    }

    @FXML
    public void handleFilter(ActionEvent event) {

    }

    @FXML
    public void handleCancel(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }


}
