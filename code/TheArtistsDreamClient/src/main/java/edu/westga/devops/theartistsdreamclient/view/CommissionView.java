package edu.westga.devops.theartistsdreamclient.view;

import edu.westga.devops.theartistsdreamclient.view.controls.CommissionsPane;
import javafx.fxml.FXML;

public class CommissionView {

    @FXML
    private CommissionsPane unapprovedCommissions;

    @FXML
    private CommissionsPane ongoingCommissions;

    @FXML
    private void initialize() {
        this.ongoingCommissions.initCommissions();
        this.unapprovedCommissions.initCommissions();
    }
}
