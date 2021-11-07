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
		this.viewModel.viewApplicants();
	}

}