package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * UI Controller for events and initializing components.
 * 
 * @author Visurt Anuttivong
 */

public class Controller {

	/** the random system */
	protected RandomNumber rn;

	/**
	 * Get the random system
	 * 
	 * @return RandomNumber
	 */
	public RandomNumber getRandomNumber() {
		return rn;
	}

	/**
	 * Set the random system
	 * 
	 * @param rn the RandomNumber
	 */
	public void setRandomNumber(RandomNumber rn) {
		this.rn = rn;
	}

	/**
	 * Back handler is to return to the main scene.
	 * 
	 * @param event the event when select
	 */
	public void handleBack(ActionEvent event) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("RandomizeUI.fxml"));
		} catch (IOException e) {

		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Randomize");
		stage.show();
	}
}
