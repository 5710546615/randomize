package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PickUpController extends Controller {
	@FXML
	private ImageView header_iv;
	@FXML
	private TextArea input_ta;
	@FXML
	private RadioButton norepeat_rb;
	@FXML
	private Label randomed_lb;

	private File file;
	private Image image;

	public void initialize() {
		file = new File("assets/header/pickup.png");
		image = new Image(file.toURI().toString());
		header_iv.setImage(image);
	}

	public void handleRandom(ActionEvent event) {
		if (norepeat_rb.isSelected() && rn.getRands() == null) {
			rn.setRands(new ArrayList<Integer>());
		}
		
		String str = input_ta.getText().trim().replaceAll("\\s+", "");
		List<String> list = new ArrayList<String>(Arrays.asList(str.split(",")));
		int randomed = 0;
		
		rn.setMax(list.size() - 1);
		randomed = rn.getRandomed();
		
		if (randomed != Integer.MIN_VALUE && !str.equals("")) {
			randomed_lb.setText(list.get(randomed));
		} else {
			randomed_lb.setText("?");
		}
	}

	public void handleClear(ActionEvent event) {
		randomed_lb.setText("?");
		input_ta.clear();
		norepeat_rb.setSelected(false);
	}
}
