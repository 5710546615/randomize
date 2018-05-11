package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * YesOrNoController represents UI controller in YESorNo scene.
 * 
 * @author Visurt Anuttivong
 */
public class YesOrNoController extends Controller {
	@FXML
	private ImageView header_iv;
	@FXML
	private HBox list_hb;

	/** the source file */
	private File file;
	/** the image from file */
	private Image image;
	/** image view component */
	private ImageView imageview;

	/**
	 * Initialize a new YesOrNoController when creates the UI form.
	 */
	public void initialize() {
		file = new File("assets/header/yesno.png");
		image = new Image(file.toURI().toString());
		header_iv.setImage(image);

		file = new File("assets/yesno/yesno.png");
		image = new Image(file.toURI().toString());
		imageview = new ImageView(image);
		imageview.setFitHeight(212);
		imageview.setFitWidth(450);

		list_hb.getChildren().add(imageview);
	}

	/**
	 * Random handler is to random either yes or no
	 * 
	 * @param event the event when select
	 */
	public void handleRandom(ActionEvent event) {
		list_hb.getChildren().clear();

		file = new File("assets/yesno/" + rn.getRandomed() + ".png");
		image = new Image(file.toURI().toString());
		imageview = new ImageView(image);
		imageview.setFitHeight(212);
		imageview.setFitWidth(450);

		list_hb.getChildren().add(imageview);
	}

	/**
	 * Clear handler is to clear all components to default.
	 * 
	 * @param event the event when select
	 */
	public void handleClear(ActionEvent event) {
		list_hb.getChildren().clear();

		file = new File("assets/yesno/yesno.png");
		image = new Image(file.toURI().toString());
		imageview = new ImageView(image);
		imageview.setFitHeight(212);
		imageview.setFitWidth(450);

		list_hb.getChildren().add(imageview);
	}
}
