package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class PickUpController {
	@FXML
	private TextArea input_ta;
	@FXML
	private RadioButton norepeat_rb;
	@FXML
	private Label randomed_lb;
	
	private RandomNumber rn;
	
	public RandomNumber getRandomNumber() {
		return rn;
	}

	public void setRandomNumber(RandomNumber rn) {
		this.rn = rn;
	}
	
	public void handlePick(ActionEvent event) {
		
		if (norepeat_rb.isSelected() && rn.getRands() == null) {
			rn.setRands(new ArrayList<Integer>());
		}
		
		String str = input_ta.getText().trim().replace(", ", ",").replace(" ,", "");
		
		List<String> list = new ArrayList<String>(Arrays.asList(str.split(",")));
		
		int randomed = 0;
		
		rn.setMax(list.size() - 1);
		
		randomed = rn.getRandomed();
		
		if (randomed != Integer.MIN_VALUE) {
			randomed_lb.setText(list.get(randomed));
		} else {
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
