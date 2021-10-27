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

/**
 * The commission form class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
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

    /**
     * Creates a new commission form popup
     * 
     * @precondition none
     * @postcondition none
     * 
     */
    public CommissionFormPopup() {}

    @FXML
    void handleCancelButtonClick(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
        currentStage.close();
    }

    @FXML
    void handleSubmitButtonClick(ActionEvent event) {
        try {
            Commision newCommission = new Commission(this.nameTextField.getText(), this.styleTextField.getText(), Double.parseDouble(this.budgetTextField.getText()), this.sizeTextField.getText(), this.descriptionTextArea.getText());
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, e.getMessage());
            alert.show(); 
        }
    }

}