package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * A main class for the Randomize. It is responsible for loading FXML and
 * showing it.
 * 
 * @author Visurt Anuttivong
 */
public class Main extends Application {

	/**
	 * Loading main scene FXML and showing it.
	 */
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("RandomizeUI.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setResizable(false);
			stage.setTitle("Randomize");
			stage.show();
		} catch (Exception e) {
			System.out.println("Exception creating scene: " + e.getMessage());
		}
	}

	/**
	 * Launch the application.
	 * 
	 * @param args not use.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
