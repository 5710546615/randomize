package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DiceController {
	@FXML
	private TextField num_tf;
	@FXML
	private Label randomed_lb;
	@FXML
	private Label default_lb;

	private RandomNumber rn;

	public RandomNumber getRandomNumber() {
		return rn;
	}

	public void setRandomNumber(RandomNumber rn) {
		this.rn = rn;
	}

	public void handleRoll(ActionEvent event) {
		default_lb.setVisible(false);

		int min = rn.getMin();
		int max = rn.getMax();
		int randomed = 0;
		int n = 1;
		try {
			n = Integer.parseInt(num_tf.getText().trim());
			max = 6 * n;
		} catch (Exception e) {

		}

		num_tf.setText(String.valueOf(max / 6));

		rn.setMin(min);
		rn.setMax(max);

		do {
			randomed = rn.getRandomed();
		} while (randomed < n);
		
		randomed_lb.setText(String.valueOf(randomed));
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
