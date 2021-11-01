package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

import java.io.IOException;

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

	public CommissionTile() {
		FXMLLoader loader = new FXMLLoader(Header.class.getResource(COMMISSION_TILE_FXML));
		loader.setRoot(this);
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@FXML
	void initialize() {

	}

	@FXML
	void handleApply(ActionEvent event) {

	}

}
