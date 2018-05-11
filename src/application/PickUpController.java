package application;

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

/**
 * PickUpController represents UI controller in PickUp scene.
 * 
 * @author Visurt Anuttivong
 */
public class PickUpController extends Controller {
	@FXML
	private ImageView header_iv;
	@FXML
	private TextArea input_ta;
	@FXML
	private RadioButton norepeat_rb;
	@FXML
	private Label randomed_lb;

	/** the image from file */
	private Image image;

	/**
	 * Initialize a new PickUpController when creates the UI form.
	 */
	public void initialize() {
		image = new Image(ResourceLoader.load("header/pickup.png"));
		header_iv.setImage(image);
	}

	/**
	 * Random handler is to random an element in list from input field
	 * 
	 * @param event the event when select
	 */
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

	/**
	 * Clear handler is to clear all components to default.
	 * 
	 * @param event the event when select
	 */
	public void handleClear(ActionEvent event) {
		randomed_lb.setText("?");
		input_ta.clear();
		norepeat_rb.setSelected(false);
	}
}
