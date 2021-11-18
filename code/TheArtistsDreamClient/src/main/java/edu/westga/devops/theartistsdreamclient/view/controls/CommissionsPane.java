package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.Parent;
import javafx.stage.Stage;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.view.popups.PopupLoader;
import edu.westga.devops.theartistsdreamclient.view.popups.CommissionFormPopup;
import edu.westga.devops.theartistsdreamclient.view.WindowLoader;
import edu.westga.devops.theartistsdreamclient.view.InSearchOfPage;

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

	}

	@FXML
	void handleViewMore(ActionEvent event) {

	}

	@FXML
	void handlePostNewCommission(ActionEvent event) {
	    try {
		    Parent mainFrame = this.getScene().getRoot();
		    Stage popup = PopupLoader.loadPopup("Commision Form", CommissionFormPopup.class.getResource("CommissionFormPopup.fxml"), new CommissionFormPopup(User.getUser().getUserId()), mainFrame);
		    popup.setOnCloseRequest((event2) -> {
			    mainFrame.setEffect(null);
			    Object data = popup.getUserData();
			    if (data != null) {
				    try {
					    Stage currentStage = (Stage) this.getScene().getWindow();
					    WindowLoader.changeScene(currentStage, "InSearchOfPage.fxml", new InSearchOfPage(), "In Search Of", false);
					    currentStage.setMaximized(true);
				    } catch (IOException e) {
					    e.printStackTrace();
				    }
			    }
		    });
		    popup.show();
	    } catch (IOException e) {
		    throw new RuntimeException(e);
	    }
	}

}
