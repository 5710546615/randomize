package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * DiceController represents UI controller in Dice scene.
 * 
 * @author Visurt Anuttivong
 */
public class DiceController extends Controller {
	@FXML
	private ImageView header_iv;
	@FXML
	private TextField num_tf;
	@FXML
	private Label default_lb;
	@FXML
	private HBox list_hb;

	/** the source file */
	private File file;
	/** the image from file */
	private Image image;
	/** image view component */
	private ImageView imageview;

	/**
	 * Initialize a new DiceController when creates the UI form.
	 */
	public void initialize() {
		file = new File("assets/header/dice.png");
		image = new Image(file.toURI().toString());
		header_iv.setImage(image);
	}

	/**
	 * Random handler is to random dice face from 1 to 6.
	 * 
	 * @param event the event when select
	 */
	public void handleRandom(ActionEvent event) {
		default_lb.setVisible(false);
		int n = 1;

		try {
			n = Integer.parseInt(num_tf.getText().trim());
			if (n < 1 || n > 4) {
				n = 1;
			}
		} catch (Exception e) {

		}

		num_tf.setText(String.valueOf(n));
		list_hb.getChildren().clear();

		for (int i = 0; i < n; i++) {
			file = new File("assets/dice/" + rn.getRandomed() + ".png");
			image = new Image(file.toURI().toString());
			imageview = new ImageView(image);
			imageview.setFitHeight(125);
			imageview.setFitWidth(125);

			list_hb.getChildren().add(imageview);
		}
	}

	/**
	 * Clear handler is to clear all components to default.
	 * 
	 * @param event the event when select
	 */
	public void handleClear(ActionEvent event) {
		num_tf.clear();
		default_lb.setVisible(true);
		list_hb.getChildren().clear();
	}
}
