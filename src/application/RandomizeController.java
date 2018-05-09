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

	public void changeSceneToYesOrNo(ActionEvent event) throws IOException {
		int min = 1;
		int max = 2;
		RandomNumber rn = new RandomNumber(min, max);

		try {
			URL url = getClass().getResource("YesOrNoUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: YesOrNoUI.fxml");
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();

			YesOrNoController controller = loader.getController();
			controller.setRandomNumber(rn);

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setTitle("YES or NO");
			stage.show();
		} catch (Exception e) {
			System.out.println("Exception creating scene: " + e.getMessage());
		}
	}

	public void changeSceneToCard(ActionEvent event) {

	}

	public void changeSceneToCoin(ActionEvent event) {
		int min = 1;
		int max = 2;
		RandomNumber rn = new RandomNumber(min, max);

		try {
			URL url = getClass().getResource("CoinUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: CoinUI.fxml");
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();

			CoinController controller = loader.getController();
			controller.setRandomNumber(rn);

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setTitle("YES or NO");
			stage.show();
		} catch (Exception e) {
			System.out.println("Exception creating scene: " + e.getMessage());
		}
	}

	public void changeSceneToRPS(ActionEvent event) {

	}

	public void changeSceneToFood(ActionEvent event) {

	}

	public void changeSceneToArrange(ActionEvent event) {

	}

	public void changeSceneToPickUp(ActionEvent event) {

	}

}
