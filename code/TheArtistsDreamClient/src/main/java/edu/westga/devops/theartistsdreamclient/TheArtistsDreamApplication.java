package edu.westga.devops.theartistsdreamclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Handle Setting up The Artist's Dream Application
 */
public class TheArtistsDreamApplication extends Application {

	public static final String ICON_PATH = "icon.png";

	public static final String LOGIN_FXML = "view/TODO.fxml";

	// TODO: SINGLETONS

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TheArtistsDreamApplication.class.getResource(LOGIN_FXML));
		loader.load();
		Scene scene = new Scene(loader.getRoot());
		primaryStage.setTitle("The Artist's Dream");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image(TheArtistsDreamApplication.class.getResourceAsStream(ICON_PATH)));
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	/**
	 * Entry Point to running The Artist's Dream Application
	 *
	 * @param args the args for running the application
	 */
	public static void main(String[] args) {
		launch(args);
	}
}