package edu.westga.devops.theartistsdreamclient.view;

import edu.westga.devops.theartistsdreamclient.view.controls.CommissionsPane;
import edu.westga.devops.theartistsdreamclient.model.CommissionType;

import javafx.fxml.FXML;

public class CommissionView {

    @FXML
    private CommissionsPane unapprovedCommissions;

    @FXML
    private CommissionsPane ongoingCommissions;

    @FXML
    private void initialize() {
	    this.ongoingCommissions.initCommissions();
	    this.ongoingCommissions.setCommissionType(CommissionType.ONGOING);
	    this.unapprovedCommissions.initCommissions();
	    this.unapprovedCommissions.setCommissionType(CommissionType.DIRECT);
    }
}
