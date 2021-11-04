package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

import java.io.IOException;

import javafx.collections.FXCollections;

import edu.westga.devops.theartistsdreamclient.viewmodel.CommissionTileViewModel;
import edu.westga.devops.theartistsdreamclient.model.Commission;
import edu.westga.devops.theartistsdreamclient.model.Style;

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
	private ComboBox styleComboBox;

	private CommissionTileViewModel viewModel;

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
		try {
			loader.load();
			this.viewModel = new CommissionTileViewModel(commission);
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
		this.styleComboBox.setItems(FXCollections.observableArrayList(Style.values()));
		this.styleComboBox.getSelectionModel().select(this.viewModel.styleProperty().get());
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
