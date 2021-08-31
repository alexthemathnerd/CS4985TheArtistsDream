package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * The Controller for the Custom Control for each single piece of artwork shown in the application
 * @author Aznella Joseph
 * @version Fall 2021
 */

public class ArtworkTile extends VBox {

	public static final String ARTWORK_TILE_FXML = "ArtworkTile.fxml";

	@FXML
	private Label titleLabel;

	@FXML
	private ImageView artworkImageView;

	/**
	 * Initializes the FXML for the ArtworkTile Control
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 */
	public ArtworkTile(){
		FXMLLoader loader = new FXMLLoader(Header.class.getResource(ARTWORK_TILE_FXML));
		loader.setRoot(this);
		loader.setController(this);
		try{
			loader.load();
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}

	@FXML
	void initialize(){
		//TODO: Bindings
		}

	@FXML
	void handleViewImage(MouseEvent event) {
		//TODO: use popup view
	}
}
