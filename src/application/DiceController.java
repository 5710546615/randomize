package application;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DiceController {
	@FXML
	private TextField num_tf;
	@FXML
	private Label default_lb;
	@FXML
	private HBox HBox1;
	@FXML
	private HBox HBox2;

	private RandomNumber rn;
	
	public void initialize() {
		HBox1.setVisible(false);
		HBox2.setVisible(false);
	}

	public RandomNumber getRandomNumber() {
		return rn;
	}

	public void setRandomNumber(RandomNumber rn) {
		this.rn = rn;
	}

	public void handleRoll(ActionEvent event) {
		default_lb.setVisible(false);

		int randomed = 0;
		int n = 1;
		try {
			n = Integer.parseInt(num_tf.getText().trim());
		} catch (Exception e) {
			num_tf.setText(String.valueOf(n));
		}

		if (n == 1) {
			HBox1.setVisible(true);
			HBox2.setVisible(false);
		} else if (n == 2) {
			HBox1.setVisible(false);
			HBox2.setVisible(true);
		}

//		int sum = 0;
//		for (int i = 0; i < n; i++) {
//			sum += rn.getRandomed();
//		}
//
//		randomed = sum;
//
//		File file = new File("images/dices/dice" + randomed + ".png");
//		Image image = new Image(file.toURI().toString());
//		rand1_iv.setImage(image);

	}

	public void handleBack(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("RandomizeUI.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	public void handleRecent(ActionEvent event) throws IOException {
		RecentView view = new RecentView(rn);
		rn.addObserver(view);
		view.run();
	}
}
