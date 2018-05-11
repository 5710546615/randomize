package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * ArrangeController represents UI Controller in Arrange scene.
 * 
 * @author Visurt Anuttivong
 */
public class ArrangeController extends Controller {
	@FXML
	private ImageView header_iv;
	@FXML
	private TextArea input_ta;

	/** the image from file */
	private Image image;

	/**
	 * Initialize a new ArrangeController when creates the UI form.
	 */
	public void initialize() {
		image = new Image(ResourceLoader.load("header/arrange.png"));
		header_iv.setImage(image);
	}

	/**
	 * Random handler is to rearrange the list from input field.
	 * 
	 * @param event the event when select
	 */
	public void handleRandom(ActionEvent event) {
		String str = input_ta.getText().trim().replaceAll("\\s+", "");

		List<String> list = new ArrayList<String>(Arrays.asList(str.split(",")));
		Collections.shuffle(list);

		input_ta.setText(list.toString().replace("[", "").replaceAll("]", ""));
	}

	/**
	 * Clear handler is to clear all components to default.
	 * 
	 * @param event the event when select
	 */
	public void handleClear(ActionEvent event) {
		input_ta.clear();
	}
}
