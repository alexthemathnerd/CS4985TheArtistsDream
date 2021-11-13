package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

import java.io.IOException;

import edu.westga.devops.theartistsdreamclient.viewmodel.CommissionTileViewModel;
import edu.westga.devops.theartistsdreamclient.model.Commission;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;

import edu.westga.devops.theartistsdreamclient.view.popups.PopupLoader;
import edu.westga.devops.theartistsdreamclient.view.popups.ApplicantsListPopup;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.util.List;

/**
 * Controller for CommissionTile
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class CommissionTile extends VBox {

	public static final String COMMISSION_TILE_FXML = "CommissionTile.fxml";

	@FXML
	private Label titleLabel;

	@FXML
	private Label commissionerLabel;

	@FXML
	private TextArea descriptionTextArea;

	@FXML
	private Button applyButton;

	@FXML
	private Button viewApplicantsButton;

	@FXML
	private Label budgetLabel;

	@FXML
	private Label styleLabel;

	private CommissionTileViewModel viewModel;
	private Commission commission;

	private List<User> applicantList;

	/**
	 * Creates a new CommissionTile of the specified Commission
	 *
	 * @param commission the commission being displayed in the tile
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 */
	public CommissionTile(Commission commission) {
		FXMLLoader loader = new FXMLLoader(Header.class.getResource(COMMISSION_TILE_FXML));
		loader.setRoot(this);
		loader.setController(this);
		this.commission = commission;
		this.viewModel = new CommissionTileViewModel(commission);
		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		this.applicantList = UserManager.getUserManager().searchForUsers("a");
	}

	@FXML
	void initialize() {
		this.titleLabel.textProperty().bind(this.viewModel.titleProperty());
		this.commissionerLabel.textProperty().bind(this.viewModel.commissionerProperty());
		this.descriptionTextArea.textProperty().bind(this.viewModel.descriptionProperty());
		this.budgetLabel.textProperty().bind(this.viewModel.budgetProperty());
		this.styleLabel.textProperty().bind(this.viewModel.styleStringProperty());
		this.applyButton.setDisable(User.getUser().getUserId() == this.commission.getUserId());
		this.viewApplicantsButton.setDisable(User.getUser().getUserId() != this.commission.getUserId());
	}

	@FXML
	void handleApply(ActionEvent event) {
		this.viewModel.apply();
	}

	@FXML
	void handleViewApplicants(ActionEvent event) {
		try {
            Parent mainFrame = ((Node) event.getSource()).getParent().getParent().getParent();
            ApplicantsListPopup controller = new ApplicantsListPopup(this.applicantList);
			Stage popup = PopupLoader.loadPopup("Applicant List", ApplicantsListPopup.class.getResource("ApplicantsListPopup.fxml"), controller, mainFrame);      
			popup.show();
			controller.getResult();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

}
