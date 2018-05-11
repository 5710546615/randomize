package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RandomizeController {
	@FXML
	private ImageView logo_iv;

	private File file;
	private Image image;

	public void initialize() {
		file = new File("assets/etc/randomize.png");
		image = new Image(file.toURI().toString());
		logo_iv.setImage(image);
	}

	public void changeScene(ActionEvent event, String fxml, String title, Controller controller, int max) {
		try {
			RandomNumber rn = new RandomNumber(0, max);

			URL url = getClass().getResource(fxml);
			if (url == null) {
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();

			controller = loader.getController();
			controller.setRandomNumber(rn);

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setResizable(false);
			stage.setTitle(title);
			stage.show();
		} catch (IOException e) {

		}
	}

	public void changeSceneToNumber(ActionEvent event) throws IOException {
		changeScene(event, "NumberUI.fxml", "Number", new NumberController(), 99);
	}

	public void changeSceneToDice(ActionEvent event) throws IOException {
		changeScene(event, "DiceUI.fxml", "Dice", new DiceController(), 5);
	}

	public void changeSceneToYesOrNo(ActionEvent event) throws IOException {
		changeScene(event, "YesOrNoUI.fxml", "YES or NO", new YesOrNoController(), 1);
	}

	public void changeSceneToCard(ActionEvent event) {
		changeScene(event, "CardUI.fxml", "Card", new CardController(), 51);
	}

	public void changeSceneToCoin(ActionEvent event) {
		changeScene(event, "CoinUI.fxml", "Coin", new CoinController(), 1);
	}

	public void changeSceneToRPS(ActionEvent event) {
		changeScene(event, "RPSUI.fxml", "Rock-Paper-Scissors", new RPSController(), 2);
	}

	public void changeSceneToFood(ActionEvent event) {
		changeScene(event, "FoodUI.fxml", "Food", new FoodController(), 0);
	}

	public void changeSceneToArrange(ActionEvent event) {
		changeScene(event, "ArrangeUI.fxml", "Arrange", new ArrangeController(), 0);
	}

	public void changeSceneToPickUp(ActionEvent event) {
		changeScene(event, "PickUpUI.fxml", "Pick Up", new PickUpController(), 1);
	}
}
