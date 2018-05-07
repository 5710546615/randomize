package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NumberController {
	@FXML
	private TextField min;
	@FXML
	private TextField max;
	@FXML
	private Label randomed;
	@FXML
	private RadioButton norepeat;
	@FXML
	private Label defaultfield;

	private List<Integer> numbers;

	public List<Integer> all;

	private Random rn;

	public void initialize() {
		all = new ArrayList<Integer>();
		rn = new Random();
	}

	public void changeSceneToHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("RandomizeUI.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	public void changeSceneToRecent(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RecentNumberUI.fxml"));
		Parent root = (Parent) loader.load();

		RecentNumberController secController = loader.getController();
		
		int[] intArray = new int[all.size()];
		for (int i = 0; i < intArray.length; i++) {
		    intArray[i] = all.get(i);
		}
		
		secController.setArr(intArray);

		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
	}

	public void handleRandom(ActionEvent event) {
		defaultfield.setVisible(false);

		boolean isSet = false;

		int min_num;
		int max_num;

		try {
			min_num = Integer.parseInt(min.getText());
			max_num = Integer.parseInt(max.getText());
		} catch (Exception ex) {
			min_num = 0;
			max_num = 99;
		}

		if (min_num > max_num) {
			int tmp = min_num;
			min_num = max_num;
			max_num = tmp;
		}

		int range = max_num - min_num + 1;
		int rand = rn.nextInt(range) + min_num;

		if (norepeat.isSelected()) {
			if (!numbers.contains(rand)) {
				numbers.add(rand);
			} else if (numbers.size() < range) {
				do {
					rand = rn.nextInt(range) + min_num;
				} while (numbers.contains(rand));

				numbers.add(rand);
			} else {
				isSet = true;
				randomed.setText("?");
				numbers = new ArrayList<Integer>();
				System.out.println("You generated all numbers in between min and max. I gonna start over again");
			}
		}

		if (!isSet) {
			min.setText(String.valueOf(min_num));
			max.setText(String.valueOf(max_num));

			all.add(rand);

			randomed.setText(String.valueOf(rand));
		}
	}

	public void handleNoRepeat(ActionEvent event) {
		numbers = new ArrayList<Integer>();
	}
}
