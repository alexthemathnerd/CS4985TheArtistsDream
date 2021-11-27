package edu.westga.devops.theartistsdreamclient.view.popups;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;

import edu.westga.devops.theartistsdreamclient.model.Style;
import edu.westga.devops.theartistsdreamclient.model.CommissionManager;

/**
 * The Controller Class for the CommissionFormPopup
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class CommissionFormPopup {

    @FXML
    private Label styleLabel;

    @FXML
    private ComboBox styleComboBox;

    @FXML
    private Label budgetLabel;

    @FXML
    private TextField budgetTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Button cancelButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextField titleTextField;

    private int userId;
    /**
     * Creates a new commission form popup
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param userId the userId of the user
     * 
     */
    public CommissionFormPopup(int userId) {
        this.userId = userId;
    }

    @FXML
    void initialize() {
        this.styleComboBox.setItems(FXCollections.observableArrayList(Style.values()));
    }

    @FXML
    void handleCancelButtonClick(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
        currentStage.close();
    }

    @FXML
    void handleSubmitButtonClick(ActionEvent event) {
        try {
            CommissionManager.getCommissionManager().addCommission(this.userId, (Style) this.styleComboBox.getSelectionModel().getSelectedItem(), Double.parseDouble(this.budgetTextField.getText()), this.descriptionTextArea.getText(), this.titleTextField.getText());
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setUserData("SUBMITTED");
            currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}