package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.CommissionManager;
import edu.westga.devops.theartistsdreamclient.model.CommissionType;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

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
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;

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
	private Button approveButton;

	@FXML
	private Button denyButton;

	@FXML
	private Button submitButton;

	@FXML
	private Button getButton;

	@FXML
	private Label budgetLabel;

	@FXML
	private Label styleLabel;

	private CommissionTileViewModel viewModel;
	private Commission commission;
	private CommissionType type;

	private List<User> applicantList;

	/**
	 * Creates a new CommissionTile of the specified Commission
	 *
	 * @param commission the commission being displayed in the tile
	 * @param type the type of the commission
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 */
	public CommissionTile(Commission commission, CommissionType type) {
		FXMLLoader loader = new FXMLLoader(Header.class.getResource(COMMISSION_TILE_FXML));
		loader.setRoot(this);
		loader.setController(this);
		this.commission = commission;
		this.viewModel = new CommissionTileViewModel(commission);
		this.type = type;
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
		this.applyButton.setManaged(User.getUser().getUserId() != this.commission.getUserId() && this.type == CommissionType.OPEN);
		this.viewApplicantsButton.setManaged(User.getUser().getUserId() == this.commission.getUserId() && this.type == CommissionType.OPEN);
		this.approveButton.setManaged(this.type == CommissionType.DIRECT);
		this.denyButton.setManaged(this.type == CommissionType.DIRECT);
		this.submitButton.setManaged(this.type == CommissionType.ONGOING && User.getUser().getUserId() == this.commission.getArtistId());
		this.getButton.setManaged(this.type == CommissionType.ONGOING && User.getUser().getUserId() == this.commission.getUserId());
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
			this.applicantList = controller.getApplicants();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

	@FXML
	void handleAprove(ActionEvent event) {
		CommissionManager.getCommissionManager().approveCommission(this.commission.getId());
	}

	@FXML
	void handleDeny(ActionEvent event) {
		CommissionManager.getCommissionManager().denyCommission(this.commission.getId());
	}

	@FXML
	void handleSubmit(ActionEvent event) throws MalformedURLException {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Submit Art");
		chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png"));
		File file = chooser.showOpenDialog(null);
		if (file != null) {
			Image image = new Image(file.toURI().toURL().toExternalForm());
			BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
			try (ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream()) {
				ImageIO.write(bufferedImage, "png", byteArrayInputStream);
				byte[] imageBytes = byteArrayInputStream.toByteArray();
				CommissionManager.getCommissionManager().submitImage(this.commission.getId(), imageBytes);
			} catch (IOException e) {
				// todo
			}
		}
	}

	@FXML
	void handleGet(ActionEvent event) throws IOException {
		byte[] image = CommissionManager.getCommissionManager().getSubmission(this.commission.getId());
		if (image != null) {
			Image javafxImage = new Image(new ByteArrayInputStream(image));
			BufferedImage bufferedImage = SwingFXUtils.fromFXImage(javafxImage, null);
			FileChooser chooser = new FileChooser();
			chooser.setTitle("Save Submission");
			File file = chooser.showSaveDialog(null);
			if (file != null) {
				ImageIO.write(bufferedImage, "png", file);
			}
		}
	}

}
