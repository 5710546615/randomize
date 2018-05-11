package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ArrangeController extends Controller {
	@FXML
	private TextArea input_ta;
	
	File file;
	Image image;
	@FXML
	ImageView header_iv;

	public void initialize() {
		file = new File("assets/header/arrange.png");
		image = new Image(file.toURI().toString());
		header_iv.setImage(image);
	}

	public void handleRandom(ActionEvent event) {
		String str = input_ta.getText().trim().replace(", ", ",").replace(" ,", "");

		List<String> list = new ArrayList<String>(Arrays.asList(str.split(",")));
		Collections.shuffle(list);

		input_ta.setText(list.toString().replace("[", "").replaceAll("]", ""));
	}
	
	public void handleClear(ActionEvent event) {
		input_ta.clear();
	}
}
