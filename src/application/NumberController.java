package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NumberController {
	@FXML
	private TextField min_tf;
	@FXML
	private TextField max_tf;
	@FXML
	private Label randomed_lb;
	@FXML
	private RadioButton norepeat_rb;
	@FXML
	private Label default_lb;

	private RandomNumber rn;

	public RandomNumber getRandomNumber() {
		return rn;
	}

	public void setRandomNumber(RandomNumber rn) {
		this.rn = rn;
	}

	public void handleRandom(ActionEvent event) {
		default_lb.setVisible(false);
		int min = rn.getMin();
		int max = rn.getMax();
		int randomed = 0;

		try {
			min = Integer.parseInt(min_tf.getText().trim());
			max = Integer.parseInt(max_tf.getText().trim());
		} catch (Exception e) {

		}

		rn.setMin(min);
		rn.setMax(max);

		randomed = rn.getRandomed();

		randomed_lb.setText(String.valueOf(randomed));

		if (randomed == Integer.MIN_VALUE) {
			randomed_lb.setText("?");
		}

	}

	public void handleNoRepeat(ActionEvent event) {
		rn.setRands(new ArrayList<Integer>());
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
