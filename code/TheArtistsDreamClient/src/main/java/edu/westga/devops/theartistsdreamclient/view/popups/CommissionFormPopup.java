package edu.westga.devops.theartistsdreamclient.view.popups;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;
import edu.westga.devops.theartistsdreamclient.model.Commission;
import edu.westga.devops.theartistsdreamclient.model.CommissionManager;
import edu.westga.devops.theartistsdreamclient.utils.UI;


/**
 * The commission form class
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
        this.styleComboBox.getItems().addAll(
            UI.Style.ABSTRACT, 
            UI.Style.MODERN, 
            UI.Style.FANTASY, 
            UI.Style.CHARCOAL, 
            UI.Style.SURREALISM, 
            UI.Style.MINIMALIST);
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
            Commission newCommission = new Commission(this.userId, (UI.Style) this.styleComboBox.getSelectionModel().getSelectedItem(), Double.parseDouble(this.budgetTextField.getText()), this.descriptionTextArea.getText());
            CommissionManager.getCommissionManager().addCommission(newCommission);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
            currentStage.close();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, e.getMessage());
            alert.show();
        }
    }

}