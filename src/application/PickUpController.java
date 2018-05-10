package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class PickUpController extends Controller {
	@FXML
	private TextArea input_ta;
	@FXML
	private RadioButton norepeat_rb;
	@FXML
	private Label randomed_lb;

	public void handleRandom(ActionEvent event) {

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
}
