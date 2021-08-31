package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * The Controller for the Custom Control for each single piece of artwork shown in the application
 */

public class ArtworkTile extends VBox {

	public static final String ARTWORK_TILE_FXML = "ArtworkTile.fxml";

	/**
	 * Initializes the FXML for the ArtworkTile Control
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
}
