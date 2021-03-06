package edu.westga.devops.theartistsdreamclient.view;

import edu.westga.devops.theartistsdreamclient.view.controls.CommissionsPane;
import edu.westga.devops.theartistsdreamclient.view.controls.Header;
import edu.westga.devops.theartistsdreamclient.model.CommissionType;

import javafx.fxml.FXML;

/**
 * Controller for the In Search Of Page
 *
 * @author Aznella Joseph
 * @version Fall 2021
 *
 */
public class InSearchOfPage {

	@FXML
	private Header header;

	@FXML
	private CommissionsPane commissionsPane;

	@FXML
	private void initialize() {
		this.commissionsPane.setCommissionType(CommissionType.OPEN);
		this.commissionsPane.initCommissions();
	}

}
