package edu.westga.devops.theartistsdreamclient.view.popups;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.stage.WindowEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CommissionFormPopup {

    @FXML
    private VBox referencesLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label styleLabel;

    @FXML
    private TextField styleTextField;

    @FXML
    private Label budgetLabel;

    @FXML
    private TextField budgetTextField;

    @FXML
    private Label sizelabel;

    @FXML
    private TextField sizeTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Button uploadFilesButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button submitButton;

    @FXML
    private Label filesLabel;

    private List<File> files;

    public CommissionFormPopup() {
        this.files = new ArrayList<File>();
    }

    @FXML
    void handleCancelButtonClick(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
        currentStage.close();
    }

    @FXML
    void handleSubmitButtonClick(ActionEvent event) {

    }

    @FXML
    void handleUploadFilesClick(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select Files");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*.*"));
        File file = chooser.showOpenDialog(null);
        this.files.add(file);
        String fileList = this.filesLabel.getText() + " " + file.getName();
        this.filesLabel.setText(fileList);
    }

}