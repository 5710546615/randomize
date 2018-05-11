package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

/**
 * RPSController represents UI controller in RPS (Rock-Paper-Scissors) scene.
 * 
 * @author Visurt Anuttivong
 */
public class RPSController extends Controller {
	@FXML
	private ImageView header_iv;
	@FXML
	private TextField num_tf;
	@FXML
	private Label default_lb;
	@FXML
	private FlowPane list_fp;

	/** the image from file */
	private Image image;
	/** image view component */
	private ImageView imageview;

	/**
	 * Initialize a new RPSController when creates the UI form.
	 */
	public void initialize() {
		image = new Image(ResourceLoader.load("header/rps.png"));
		header_iv.setImage(image);
	}

	/**
	 * Random handler is to random either rock, paper or scissors.
	 * 
	 * @param event the event when select
	 */
	public void handleRandom(ActionEvent event) {
		default_lb.setVisible(false);
		int n = 1;

		try {
			n = Integer.parseInt(num_tf.getText().trim());
		} catch (Exception e) {
			num_tf.setText(String.valueOf(n));
		}

		list_fp.getChildren().clear();

		if (imageview == null && n > 0 && n < 5) {
			for (int i = 0; i < n; i++) {
				image = new Image(ResourceLoader.load("rps/question.png"));
				imageview = new ImageView(image);
				imageview.setFitHeight(125);
				imageview.setFitHeight(125);

				list_fp.getChildren().add(imageview);
			}
		} else if (n > 0 && n < 5) {
			for (int i = 0; i < n; i++) {
				image = new Image(ResourceLoader.load("rps/" + rn.getRandomed() + ".png"));
				imageview = new ImageView(image);
				imageview.setFitHeight(125);
				imageview.setFitHeight(125);

				list_fp.getChildren().add(imageview);
				imageview = null;
			}
		}
	}

	/**
	 * Clear handler is to clear all components to default.
	 * 
	 * @param event the event when select
	 */
	public void handleClear(ActionEvent event) {
		default_lb.setVisible(true);
		num_tf.clear();
		list_fp.getChildren().clear();
	}
}
