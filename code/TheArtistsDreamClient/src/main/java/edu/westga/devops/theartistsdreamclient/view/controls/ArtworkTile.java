package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import edu.westga.devops.theartistsdreamclient.model.Artwork;

/**
 * The Controller for the Custom Control for each single piece of artwork shown in the application
 * 
 * @author Aznella Joseph
 * @version Fall 2021
 *
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

	/**
	 * Creates an ArtworkTile with a specified artwork
	 *
	 * @precondition artwork != null
	 * @postcondition none
	 */
	public ArtworkTile(Artwork artwork){
		FXMLLoader loader = new FXMLLoader(Header.class.getResource(ARTWORK_TILE_FXML));
		loader.setRoot(this);
		loader.setController(this);
		try{
			loader.load();
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		this.artworkImageView.setImage(artwork.getImage());
		this.titleLabel.setText(artwork.getTitle());
	}

	@FXML
	void initialize(){

	}

	@FXML
	void handleViewImage(MouseEvent event) {
		//TODO: use popup view
	}
}
