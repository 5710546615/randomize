package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class NumberController extends Controller {
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

	public void handleRandom(ActionEvent event) {
		default_lb.setVisible(false);

		if (norepeat_rb.isSelected() && rn.getRands() == null) {
			rn.setRands(new ArrayList<Integer>());
		}

		int min = rn.getMin();
		int max = rn.getMax();
		int randomed = 0;

		try {
			min = Integer.parseInt(min_tf.getText().trim());
			max = Integer.parseInt(max_tf.getText().trim());
		} catch (Exception e) {

		}

		min_tf.setText(String.valueOf(min));
		max_tf.setText(String.valueOf(max));

		rn.setMin(min);
		rn.setMax(max);

		randomed = rn.getRandomed();

		randomed_lb.setText(String.valueOf(randomed));

		if (randomed == Integer.MIN_VALUE) {
			randomed_lb.setText("?");
		}

	}
}
