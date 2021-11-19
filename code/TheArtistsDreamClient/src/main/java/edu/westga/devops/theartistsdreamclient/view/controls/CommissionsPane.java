package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.CommissionManager;
import edu.westga.devops.theartistsdreamclient.model.CommissionType;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;

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

	private ObjectProperty<CommissionType> commissionType;

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
		this.postCommissionButton.managedProperty().bind(this.commissionTypeProperty().isNotEqualTo(CommissionType.OPEN));
	}

	public void initCommissions() {
		for (Commission aCommission : CommissionManager.getCommissionManager().getFirstFiveCommissions(this.getCommissionType())) {
			this.commissionsVBox.getChildren().add(new CommissionTile(aCommission, this.getCommissionType()));
		}
	}

	@FXML
	void handleViewMore(ActionEvent event) {

	}

	@FXML
	void handlePostNewCommission(ActionEvent event) {

	}

	public final CommissionType getCommissionType() {
		return this.commissionTypeProperty().get();
	}

	public final void setCommissionType(CommissionType commissionType) {
		this.commissionTypeProperty().set(commissionType);
	}

	public final ObjectProperty<CommissionType> commissionTypeProperty() {
		if (this.commissionType == null) {
			this.commissionType = new ObjectPropertyBase<CommissionType>(CommissionType.DIRECT) {
				@Override
				public Object getBean() {
					return CommissionsPane.this;
				}

				@Override
				public String getName() {
					return "commissionType";
				}
			};
		}
		return this.commissionType;
	}


}
