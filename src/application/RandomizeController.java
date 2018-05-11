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

/**
 * RandomizeController represents UI Controller in main scene.
 * 
 * @author Visurt Anuttivong
 */
public class RandomizeController {
	@FXML
	private ImageView logo_iv;

	/** the source file */
	private File file;
	/** the image from file */
	private Image image;

	/**
	 * Initialize a new RandomizeController when creates the UI form.
	 */
	public void initialize() {
		file = new File("assets/etc/randomize.png");
		image = new Image(file.toURI().toString());
		logo_iv.setImage(image);
	}

	/**
	 * Change scene to target scene.
	 * 
	 * @param event the event when select
	 * @param fxml the fxml of target scene
	 * @param title the title of target scene
	 * @param controller the controller of target scene
	 * @param max the maximum of random number. Default, min equals to zero
	 */
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

	/**
	 * Change scene to Number scene.
	 * 
	 * @param event the event when select
	 */
	public void changeSceneToNumber(ActionEvent event) {
		changeScene(event, "NumberUI.fxml", "Number", new NumberController(), 99);
	}

	/**
	 * Change scene to Dice scene.
	 * 
	 * @param event the event when select
	 */
	public void changeSceneToDice(ActionEvent event) {
		changeScene(event, "DiceUI.fxml", "Dice", new DiceController(), 5);
	}

	/**
	 * Change scene to YesOrNo scene.
	 * 
	 * @param event the event when select
	 */
	public void changeSceneToYesOrNo(ActionEvent event) {
		changeScene(event, "YesOrNoUI.fxml", "YES or NO", new YesOrNoController(), 1);
	}

	/**
	 * Change scene to Card scene.
	 * 
	 * @param event the event when select
	 */
	public void changeSceneToCard(ActionEvent event) {
		changeScene(event, "CardUI.fxml", "Card", new CardController(), 51);
	}

	/**
	 * Change scene to Coin scene.
	 * 
	 * @param event the event when select
	 */
	public void changeSceneToCoin(ActionEvent event) {
		changeScene(event, "CoinUI.fxml", "Coin", new CoinController(), 1);
	}

	/**
	 * Change scene to RPS scene.
	 * 
	 * @param event the event when select
	 */
	public void changeSceneToRPS(ActionEvent event) {
		changeScene(event, "RPSUI.fxml", "Rock-Paper-Scissors", new RPSController(), 2);
	}

	/**
	 * Change scene to Food scene.
	 * 
	 * @param event the event when select
	 */
	public void changeSceneToFood(ActionEvent event) {
		changeScene(event, "FoodUI.fxml", "Food", new FoodController(), 0);
	}

	/**
	 * Change scene to Arrange scene.
	 * 
	 * @param event the event when select
	 */
	public void changeSceneToArrange(ActionEvent event) {
		changeScene(event, "ArrangeUI.fxml", "Arrange", new ArrangeController(), 0);
	}

	/**
	 * Change scene to PickUp scene.
	 * 
	 * @param event the event when select
	 */
	public void changeSceneToPickUp(ActionEvent event) {
		changeScene(event, "PickUpUI.fxml", "Pick Up", new PickUpController(), 1);
	}
}
