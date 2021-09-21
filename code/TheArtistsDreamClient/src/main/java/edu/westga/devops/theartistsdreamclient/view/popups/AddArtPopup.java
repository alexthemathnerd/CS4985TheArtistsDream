package edu.westga.devops.theartistsdreamclient.view.popups;

import edu.westga.devops.theartistsdreamclient.viewmodel.AddArtPopupViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class AddArtPopup {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea tagsTextArea;

    @FXML
    private ImageView addedImageView;

    private AddArtPopupViewModel viewModel;

    public AddArtPopup() {
        this.viewModel = new AddArtPopupViewModel();
    }

    @FXML
    private void initialize() {
        this.titleTextField.textProperty().bindBidirectional(this.viewModel.titleProperty());
        this.tagsTextArea.textProperty().bindBidirectional(this.viewModel.tagsProperty());
        this.viewModel.imageObjectProperty().bind(this.addedImageView.imageProperty());
    }

    @FXML
    private void handleChooseFile(ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Add Art");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            this.addedImageView.setImage(new Image(file.toURI().toURL().toExternalForm()));
        }
    }

    @FXML
    private void handleAdd(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.viewModel.addArt();
        currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
        currentStage.close();
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
        currentStage.close();
    }

}
