package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ArrangeController {
	@FXML
	private TextArea input_ta;
	
	private RandomNumber rn;
	
	public RandomNumber getRandomNumber() {
		return rn;
	}

	public void setRandomNumber(RandomNumber rn) {
		this.rn = rn;
	}
	
	public void handleArrange(ActionEvent event) {
		String str = input_ta.getText().trim().replace(", ", ",").replace(" ,", "");
		
		List<String> list = new ArrayList<String>(Arrays.asList(str.split(",")));
		Collections.shuffle(list);
		
		input_ta.setText(list.toString().replace("[", "").replaceAll("]", ""));
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
