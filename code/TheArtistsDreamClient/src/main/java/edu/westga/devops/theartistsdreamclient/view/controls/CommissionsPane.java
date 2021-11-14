package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;

import edu.westga.devops.theartistsdreamclient.model.Style;
import edu.westga.devops.theartistsdreamclient.model.Commission;

import java.io.IOException;

/**
 * Controller for the CommissionsPane
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class CommissionsPane extends ScrollPane {

	public static final String COMMISSIONS_PANE_FXML = "CommissionsPane.fxml";

	@FXML
	private VBox commissionsVBox;

	@FXML
	private Button viewMoreButton;

	@FXML
	private Button postCommissionButton;

	public CommissionsPane() {
		FXMLLoader loader = new FXMLLoader(Header.class.getResource(COMMISSIONS_PANE_FXML));
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
		this.commissionsVBox.getChildren().add(new CommissionTile(new Commission(1, Style.ABSTRACT, 100.00, "An abstract art piece with lots of red", "Red Abstract Art")));
	}

	@FXML
	void handleViewMore(ActionEvent event) {

	}

	@FXML
	void handlePostNewCommission(ActionEvent event) {

	}

}
