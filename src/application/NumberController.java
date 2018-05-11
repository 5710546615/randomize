package application;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
	
	private File file;
	private Image image;
	@FXML
	ImageView header_iv;
	
	public void initialize() {
		file = new File("assets/header/number.png");
		image = new Image(file.toURI().toString());
		header_iv.setImage(image);
	}

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
	
	public void handleClear(ActionEvent event) {
		min_tf.clear();
		max_tf.clear();
		randomed_lb.setText("?");
		norepeat_rb.setSelected(false);
		default_lb.setVisible(true);
		
		rn.setRands(null);
		rn.setMin(0);
		rn.setMax(99);
	}
}
