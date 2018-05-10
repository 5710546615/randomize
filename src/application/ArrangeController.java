package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ArrangeController extends Controller {
	@FXML
	private TextArea input_ta;

	public void handleRandom(ActionEvent event) {
		String str = input_ta.getText().trim().replace(", ", ",").replace(" ,", "");

		List<String> list = new ArrayList<String>(Arrays.asList(str.split(",")));
		Collections.shuffle(list);

		input_ta.setText(list.toString().replace("[", "").replaceAll("]", ""));
	}
	
	public void handleClear(ActionEvent event) {
		
	}
}
