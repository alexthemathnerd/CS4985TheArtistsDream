package edu.westga.devops.theartistsdreamclient.view.popups;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.view.PortfolioPage;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;

import java.io.IOException;


public class ApplicantsListPopup {
    private static final String PORTFOLIO_PAGE_FXML = "PortfolioPage.fxml";

    @FXML
    private ListView<User> applicantsListView;

    @FXML
    private Button viewProfileButton;

    @FXML
    private Button acceptButton;

    @FXML
    private Button declineButton;

    @FXML
    private Button closeButton;

    private List<User> users;

    public ApplicantsListPopup(List<User> users) {
        this.users = users;
    }

    @FXML
    void initialize() {
        this.applicantsListView.getItems().addAll(this.users);
    }

    @FXML
    void handleAcceptButtonClick(ActionEvent event) {
        User user = this.applicantsListView.getSelectionModel().getSelectedItem();
        if (user != null) {
            this.applicantsListView.getItems().clear();
            this.applicantsListView.getItems().add(user);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
            currentStage.close();
        }
    }

    @FXML
    void handleCloseButtonClick(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
            currentStage.close();
        } catch (Exception e) {

        }
    }

    @FXML
    void handleDeclineButtonClick(ActionEvent event) {
        User user = this.applicantsListView.getSelectionModel().getSelectedItem();
        this.applicantsListView.getItems().remove(user);
    }

    @FXML
    void handleViewProfileButtonClick(ActionEvent event) {
        try {
            User user = this.applicantsListView.getSelectionModel().getSelectedItem();
            Parent mainFrame = ((Node) event.getSource()).getParent();
            Stage popup = PopupLoader.loadPopup("Portfolio", PortfolioPage.class.getResource(PORTFOLIO_PAGE_FXML), new PortfolioPage(user), mainFrame);      
			popup.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the new list of applicants
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the list of applicants
     */
    public List<User> getApplicants() {
        return this.applicantsListView.getItems();
    }

}

