package application;

import java.io.IOException;
import java.net.URL;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RandomizeController {

	public void changeSceneToNumber(ActionEvent event) throws IOException {
		int min = 0;
		int max = 99;
		RandomNumber rn = new RandomNumber(min, max);

		try {
			URL url = getClass().getResource("NumberUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: NumberUI.fxml");
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();

			NumberController controller = loader.getController();
			controller.setRandomNumber(rn);

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setTitle("Random Number");
			stage.show();
		} catch (Exception e) {
			System.out.println("Exception creating scene: " + e.getMessage());
		}
	}
	
	public void changeSceneToDice(ActionEvent event) throws IOException {
		int min = 1;
		int max = 6;
		RandomNumber rn = new RandomNumber(min, max);
		
		try {
			URL url = getClass().getResource("DiceUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: DiceUI.fxml");
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();

			DiceController controller = loader.getController();
			controller.setRandomNumber(rn);

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setTitle("Dice Roller");
			stage.show();
		} catch (Exception e) {
			System.out.println("Exception creating scene: " + e.getMessage());
		}
	}

}
